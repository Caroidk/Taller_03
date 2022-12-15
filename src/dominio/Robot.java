package dominio;

import java.util.ArrayList;

public class Robot {

	private String nombre;
	private ArrayList<Pieza> piezas;
	private Arma arma;
	
	public Robot(String nombre) {
		this.nombre = nombre;
		piezas = new ArrayList<Pieza>();
		arma = null;
	}

	public void anadirPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas = piezas;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	@Override
	public String toString() {
		return "Robot [nombre=" + nombre + ", piezas=" + piezas + ", arma=" + arma + "]";
	}
}
