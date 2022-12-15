package dominio;

public class Piernas extends Pieza{

	private int velocidad;
	
	public Piernas(String nombre, int vidaTotal, int velocidad) {
		super(nombre,vidaTotal);
		this.velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Piernas [nombre="+getNombre()+", velocidad=" + velocidad+ "]";
	}
}
