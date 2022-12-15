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
}
