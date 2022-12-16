package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.SistemaRobotsImpl;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatsVictorias extends JFrame {

	private JPanel panel;
	private JTextField victorias;
	private SistemaRobotsImpl sistema;

	/**
	 * Create the frame.
	 */
	public StatsVictorias() {
		sistema = new SistemaRobotsImpl();
		sistema.leerPiezas();
		sistema.leerRobots();
		sistema.leerCombates();
		setTitle("Estad\u00EDsticas de victorias humanidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		JTextArea txtrCantidadDeVictorias = new JTextArea();
		txtrCantidadDeVictorias.setEditable(false);
		txtrCantidadDeVictorias.setText("Cantidad de victorias:");
		txtrCantidadDeVictorias.setBounds(20, 10, 192, 27);
		panel.add(txtrCantidadDeVictorias);
		
		victorias = new JTextField();
		victorias.setEditable(false);
		victorias.setBounds(245, 13, 26, 19);
		panel.add(victorias);
		victorias.setText(String.valueOf(sistema.getVictorias()));
		victorias.setColumns(10);
		
		JButton atras = new JButton("Atr\u00E1s");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		atras.setBounds(10, 232, 85, 21);
		panel.add(atras);
		
		this.setLocationRelativeTo(null);
	}

}
