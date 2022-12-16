package logica;
import java.util.ArrayList;

import dominio.*;
public interface SistemaRobots {

	/***
	 * Reads and saves the information from "armas.txt".
	 */
	public void leerArmas();
	/***
	 * Reads and saves the information from "piezas.txt".
	 */
	public void leerPiezas();
	/***
	 * Reads and saves the information from "Robots.txt".
	 */
	public void leerRobots();
	/***
	 * Reads and saves the information from "combates.txt".
	 */
	public void leerCombates();
	/***
	 * Adds a new piece to the system.
	 * @param nombre
	 * @param rareza
	 * @param tipo
	 * @param velocidad
	 * @param vida
	 * @param ataque
	 */
	public void anadirPieza(String nombre, String rareza, String tipo, int velocidad, int vida, int ataque);
	/***
	 * Returns the robots list.
	 * @return robots
	 */
	public ArrayList<Robot> getRobots();
	/***
	 * Looks for a weapon according to the entered name.
	 * @param nombre
	 * @return Arma
	 */
	public Arma buscarArma(String nombre);
	/***
	 * Assigns a weapon to a certain robot.
	 * @param robot
	 * @param arma
	 */
	public void ponerArma(Robot robot, Arma arma);
	/***
	 * Looks for a piece according to the entered name.
	 * @param nombre
	 * @return
	 */
	public Pieza buscarPieza(String nombre);
	/***
	 * Assigns a piece to a certain robot.
	 * @param robot
	 * @param pieza
	 */
	public void ponerPieza(Robot robot, Pieza pieza);
	/***
	 * Looks for a certain robot according to the entered name.
	 * @param nombre
	 * @return
	 */
	public Robot buscarRobot(String nombre);
	/***
	 * Adds a robot to an existing combat.
	 * @param combate
	 * @param robot
	 */
	public void agregarRobot(Combate combate,Robot robot);
	/***
	 * Looks for all the robots driven by a certain pilot.
	 * @param nombre
	 * @return
	 */
	public ArrayList<Robot> robotsPiloto(String nombre);
	/***
	 * Looks for all the robots belonging to a certain team.
	 * @param nombre
	 * @return
	 */
	public ArrayList<Robot> robotsEquipo(String nombre);
	/***
	 * Calculates the stats of a certain robot.
	 * @param robot
	 * @return calculated stats.
	 */
	public int[] statsRobot(Robot robot);
	/***
	 * Shows all the human victories.
	 * @return the count of human victories.
	 */
	public int getVictorias();
}
