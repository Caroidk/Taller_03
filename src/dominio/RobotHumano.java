package dominio;

public class RobotHumano extends Robot{

	private String piloto;
	private String equipo;
	
	public RobotHumano(String nombre, String piloto, String equipo) {
		super(nombre);
		this.piloto = piloto;
		this.equipo = equipo;
	}
	
	public String getPiloto() {
		return piloto;
	}



	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}



	public String getEquipo() {
		return equipo;
	}



	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "RobotHumano [nombre="+getNombre()+"piloto=" + piloto + ", equipo=" + equipo + "]";
	}
}
