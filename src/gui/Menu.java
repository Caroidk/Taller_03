package gui;

import logica.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Men\u00FA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JTextPane txtpnMenDeOpciones = new JTextPane();
		txtpnMenDeOpciones.setBounds(5, 5, 426, 19);
		txtpnMenDeOpciones.setEditable(false);
		txtpnMenDeOpciones.setText("Men\u00FA de opciones:");
		panel.add(txtpnMenDeOpciones);
		
		JButton simular = new JButton("Iniciar simulaci\u00F3n");
		simular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel, "En desarrollo...");
			}
		});
		simular.setBounds(21, 53, 233, 21);
		panel.add(simular);
		
		JButton anadirPiezas = new JButton("A\u00F1adir piezas");
		anadirPiezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirPiezas piezas = new AnadirPiezas();
				piezas.setVisible(true);
				invisible(e);
			}
		});
		anadirPiezas.setBounds(21, 103, 233, 21);
		panel.add(anadirPiezas);
		
		JButton ensamblar = new JButton("Ensamblar robot");
		ensamblar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel, "En desarrollo...");
			}
		});
		ensamblar.setBounds(21, 155, 233, 21);
		panel.add(ensamblar);
		
		JButton cambiarPiezas = new JButton("Cambiar piezas de robot");
		cambiarPiezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel, "En desarrollo...");
			}
		});
		cambiarPiezas.setBounds(21, 204, 233, 21);
		panel.add(cambiarPiezas);
		
		JButton cambairArmas = new JButton("Cambiar las armas");
		cambairArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel, "En desarrollo...");
			}
		});
		cambairArmas.setBounds(286, 53, 223, 21);
		panel.add(cambairArmas);
		
		JButton estadisticas = new JButton("Estadísticas de robots");
		estadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsRobots stats = new StatsRobots();
				stats.setVisible(true);
				dispose();
			}
		});
		estadisticas.setBounds(286, 103, 225, 21);
		panel.add(estadisticas);
		
		JButton robotsPiloto = new JButton("Robots manejados por un piloto");
		robotsPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RobotsPiloto piloto = new RobotsPiloto();
				piloto.setVisible(true);
				dispose();
			}
		});
		robotsPiloto.setBounds(286, 155, 223, 21);
		panel.add(robotsPiloto);
		
		JButton robotsEquipo = new JButton("Robots en equipo ingresado");
		robotsEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RobotsEquipo eq = new RobotsEquipo();
				eq.setVisible(true);
				dispose();
			}
		});
		robotsEquipo.setBounds(286, 204, 223, 21);
		panel.add(robotsEquipo);
		
		JButton estVictorias = new JButton("Estad\u00EDsticas de victorias de la humanidad");
		estVictorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsVictorias vic = new StatsVictorias();
				vic.setVisible(true);
				dispose();
			}
		});
		estVictorias.setBounds(21, 255, 276, 21);
		panel.add(estVictorias);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBounds(402, 305, 85, 21);
		panel.add(salir);
	}
	public void invisible(ActionEvent e) {
		this.setVisible(false);
	}
}
