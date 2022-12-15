package dominio;

public class Arma {

	private String nombre;
	private int daño;
	private int velocidadAtaque;
	
	public Arma(String nombre, int daño, int velocidadAtaque) {
		this.nombre = nombre;
		this.daño = daño;
		this.velocidadAtaque = velocidadAtaque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getVelocidadAtaque() {
		return velocidadAtaque;
	}

	public void setVelocidadAtaque(int velocidadAtaque) {
		this.velocidadAtaque = velocidadAtaque;
	}

	@Override
	public String toString() {
		return "Arma [nombre=" + nombre + ", daño=" + daño + ", velocidadAtaque=" + velocidadAtaque + "]";
	}
	
}
