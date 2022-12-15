package logica;

import dominio.*;
import java.util.*;
import java.io.*;

public class SistemaRobotsImpl implements SistemaRobots{

	ArrayList<Robot> robots = new ArrayList<Robot>();
	ArrayList<Combate> combates = new ArrayList<Combate>();
	ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	ArrayList<Arma> armas = new ArrayList<Arma>();
	ArrayList<String> rarezas = new ArrayList<String>();
	
	public void leerArmas(){
		try {
			Scanner archA = new Scanner(new File("armas.txt"));
			while(archA.hasNextLine()) {
				String[] partes = archA.nextLine().split(",");
				Arma arma = new Arma(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
				armas.add(arma);
			}
			archA.close();
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		}
	}
	
	public void leerPiezas() {
		try {
			Scanner archP = new Scanner(new File("piezas.txt"));
			int vidaExtra = 0;
			int ataque = 0;
			while(archP.hasNextLine()) {
				String[] partes = archP.nextLine().split(",");
				rarezas.add(partes[1]);
				if(partes[1].equals("PP")) {
					vidaExtra = 3000;
					ataque = 200;
				}else if(partes[1].equals("PE")) {
					vidaExtra = 2000;
					ataque = 100;
				}else {
					vidaExtra = 1000;
				}
				if(partes[2].equals("P")) {
					Piernas piernas = new Piernas(partes[0],vidaExtra,Integer.parseInt(partes[3]));
					piezas.add(piernas);
				}else if(partes[2].equals("B")) {
					Brazos brazos = new Brazos(partes[0],vidaExtra,(Integer.parseInt(partes[3])+ataque));
					piezas.add(brazos);
				}else if(partes[2].equals("T")) {
					Torax torax = new Torax(partes[0],vidaExtra,Integer.parseInt(partes[3]));
					piezas.add(torax);
				}else {
					Cabeza cabeza = new Cabeza(partes[0],vidaExtra,Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
					piezas.add(cabeza);
				}
			}
			archP.close();
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		}
	}
	
	public void leerRobots() {
		try {
			Scanner archR = new Scanner(new File("Robots.txt"));
			while(archR.hasNextLine()) {
				String[] partes = archR.nextLine().split(",");
				if(partes[6].equals("H")) {
					try {
						RobotHumano roboth = new RobotHumano(partes[0],partes[7],partes[8]);
						ponerArma(roboth, buscarArma(partes[1]));
						ponerPieza(roboth, buscarPieza(partes[2]));
						ponerPieza(roboth, buscarPieza(partes[3]));
						ponerPieza(roboth, buscarPieza(partes[4]));
						ponerPieza(roboth, buscarPieza(partes[5]));
						robots.add(roboth);
					}catch(IndexOutOfBoundsException e) {
						RobotHumano roboth = new RobotHumano(partes[0],null,null);
						ponerArma(roboth, buscarArma(partes[1]));
						ponerPieza(roboth, buscarPieza(partes[2]));
						ponerPieza(roboth, buscarPieza(partes[3]));
						ponerPieza(roboth, buscarPieza(partes[4]));
						ponerPieza(roboth, buscarPieza(partes[5]));
						robots.add(roboth);
					}
				}else {
					RobotAlien robota = new RobotAlien(partes[0],partes[7]);
					ponerArma(robota, buscarArma(partes[1]));
					ponerPieza(robota, buscarPieza(partes[2]));
					ponerPieza(robota, buscarPieza(partes[3]));
					ponerPieza(robota, buscarPieza(partes[4]));
					ponerPieza(robota, buscarPieza(partes[5]));
					robots.add(robota);
				}
				
				
			}
			archR.close();
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		}
	}
	
	public void leerCombates() {
		try {
			Scanner archC = new Scanner(new File("combates.txt"));
			while(archC.hasNextLine()) {
				String[] partes = archC.nextLine().split(",");
				Combate combate = new Combate();
				agregarRobot(combate, buscarRobot(partes[0]));
				agregarRobot(combate, buscarRobot(partes[1]));
				agregarRobot(combate, buscarRobot(partes[2]));
				agregarRobot(combate, buscarRobot(partes[3]));
				agregarRobot(combate, buscarRobot(partes[4]));
				agregarRobot(combate, buscarRobot(partes[5]));
				combate.setGanador(partes[6]);
				combates.add(combate);
			}
			archC.close();
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		}
	}
	
	public void anadirPieza(String nombre, String rareza, String tipo, int velocidad, int vida, int ataque) {
		if(tipo.equals("Piernas")) {
			Piernas piernas = new Piernas(nombre,vida,velocidad);
			piezas.add(piernas);
			rarezas.add(rareza);
		}else if(tipo.equals("Brazos")) {
			Brazos brazos = new Brazos(nombre,vida,ataque);
			piezas.add(brazos);
			rarezas.add(rareza);
		}else if(tipo.equals("Tórax")) {
			Torax torax = new Torax(nombre,vida,0);
			piezas.add(torax);
			rarezas.add(rareza);
		}else {
			Cabeza cabeza = new Cabeza(nombre,vida,velocidad,0);
			piezas.add(cabeza);
			rarezas.add(rareza);
		}
	}
	
	public ArrayList<Robot> getRobots() {
		return robots;
	}
	
	public Arma buscarArma(String nombre) {
		for(Arma arma : armas) {
			if(arma.getNombre().equals(nombre)) {
				return arma;
			}
		}
		return null;
	}
	
	public void ponerArma(Robot robot, Arma arma) {
		robot.setArma(arma);
	}
	
	public Pieza buscarPieza(String nombre) {
		for(Pieza pieza : piezas) {
			if(pieza.getNombre().equals(nombre)) {
				return pieza;
			}
		}
		return null;
	}
	
	public void ponerPieza(Robot robot, Pieza pieza) {
		robot.getPiezas().add(pieza);
	}
	
	public Robot buscarRobot(String nombre) {
		for(Robot robot : robots) {
			if(robot.getNombre().equals(nombre)){
				return robot;
			}
		}
		return null;
	}
	
	public void agregarRobot(Combate combate,Robot robot) {
		if(robot instanceof RobotHumano) {
			RobotHumano roboth = (RobotHumano) robot;
			combate.anadirHumano(roboth);;
		}else {
			RobotAlien robota = (RobotAlien) robot;
			combate.anadirAlien(robota);;
		}
	}
}
