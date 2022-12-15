package logica;

import gui.*;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SistemaRobotsImpl sistema = new SistemaRobotsImpl();
		sistema.leerArmas();
		sistema.leerPiezas();
		Menu menu= new Menu();
		menu.setVisible(true);
	}

}
