package dominio;

public class Brazos extends Pieza{

	private int ataque;
	
	public Brazos(String nombre, int vidaTotal, int ataque) {
		super(nombre, vidaTotal);
		this.ataque = ataque;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	@Override
	public String toString() {
		return "Brazos [nombre="+getNombre()+", ataque=" + ataque + "]";
	}
}
