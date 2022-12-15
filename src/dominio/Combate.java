package dominio;

import java.util.ArrayList;

public class Combate {

	private ArrayList<RobotHumano> robotsHumanos;
	private ArrayList<RobotAlien> robotsAliens;
	private String ganador;
	
	public Combate() {
		robotsHumanos = new ArrayList<RobotHumano>();
		robotsAliens = new ArrayList<RobotAlien>();
		ganador = null;
	}

	public void anadirHumano(RobotHumano humano) {
		robotsHumanos.add(humano);
	}
	
	public void anadirAlien(RobotAlien alien) {
		robotsAliens.add(alien);
	}
	
	public ArrayList<RobotHumano> getRobotsHumanos() {
		return robotsHumanos;
	}

	public void setRobotsHumanos(ArrayList<RobotHumano> robotsHumanos) {
		this.robotsHumanos = robotsHumanos;
	}

	public ArrayList<RobotAlien> getRobotsAliens() {
		return robotsAliens;
	}

	public void setRobotsAliens(ArrayList<RobotAlien> robotsAliens) {
		this.robotsAliens = robotsAliens;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	@Override
	public String toString() {
		return "Combate [robotsHumanos=" + robotsHumanos + ", robotsAliens=" + robotsAliens + ", ganador=" + ganador
				+ "]";
	}
}
