package dominio;

public class Arma {

	private String nombre;
	private int da�o;
	private int velocidadAtaque;
	
	public Arma(String nombre, int da�o, int velocidadAtaque) {
		this.nombre = nombre;
		this.da�o = da�o;
		this.velocidadAtaque = velocidadAtaque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	public int getVelocidadAtaque() {
		return velocidadAtaque;
	}

	public void setVelocidadAtaque(int velocidadAtaque) {
		this.velocidadAtaque = velocidadAtaque;
	}

	@Override
	public String toString() {
		return "Arma [nombre=" + nombre + ", da�o=" + da�o + ", velocidadAtaque=" + velocidadAtaque + "]";
	}
	
}
