package logica;
import java.util.ArrayList;

import dominio.*;
public interface SistemaRobots {

	public void leerArmas();
	
	public void leerPiezas();
	
	public void leerRobots();
	
	public void leerCombates();
	
	public void anadirPieza(String nombre, String rareza, String tipo, int velocidad, int vida, int ataque);
	
	public ArrayList<Robot> getRobots();
	
	public Arma buscarArma(String nombre);
	
	public void ponerArma(Robot robot, Arma arma);
	
	public Pieza buscarPieza(String nombre);
	
	public void ponerPieza(Robot robot, Pieza pieza);
	
	public Robot buscarRobot(String nombre);
	
	public void agregarRobot(Combate combate,Robot robot);
	
	public ArrayList<Robot> robotsPiloto(String nombre);
	
	public ArrayList<Robot> robotsEquipo(String nombre);
	
	public int[] statsRobot(Robot robot);
	
	public int getVictorias();
}
