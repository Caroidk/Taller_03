package dominio;

public class Pieza {

	private String nombre;
	private int vidaBase;
	private int vidaTotal;
	
	public Pieza(String nombre, int vidaTotal) {
		this.nombre = nombre;
		vidaBase = 2000;
		this.vidaTotal = vidaBase+vidaTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public void setVidaBase(int vidaBase) {
		this.vidaBase = vidaBase;
	}

	public int getVidaTotal() {
		return vidaTotal;
	}

	public void setVidaTotal(int vidaTotal) {
		this.vidaTotal = vidaTotal;
	}

	@Override
	public String toString() {
		return "Pieza [nombre=" + nombre + ", vidaBase=" + vidaBase + ", vidaTotal=" + vidaTotal + "]";
	}
	
}
