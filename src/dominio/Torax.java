package dominio;

public class Torax extends Pieza{

	private int vida;
	
	public Torax(String nombre, int vidaTotal, int vida) {
		super(nombre, vidaTotal);
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Torax [nombre="+getNombre()+", vida=" + vida + "]";
	}
}
