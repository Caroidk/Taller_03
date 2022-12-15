package dominio;

public class Cabeza extends Pieza{

	private int vida;
	private int velocidad;
	
	public Cabeza(String nombre, int vidaTotal, int velocidad, int vida) {
		super(nombre, vidaTotal);
		this.vida = vida;
		this.velocidad = velocidad;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Cabeza [nombre="+getNombre()+", vida=" + vida + ", velocidad=" + velocidad + "]";
	}
}
