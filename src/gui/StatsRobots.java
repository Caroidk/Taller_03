package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.*;
import logica.*;

import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;

public class StatsRobots extends JFrame {

	private JPanel panel;
	private JTable table;
	private DefaultTableModel tabla;
	private JTextPane txtpnRobots;
	private SistemaRobotsImpl sistema;

	/**
	 * Create the frame.
	 */
	public StatsRobots() {
		sistema = new SistemaRobotsImpl();
		setTitle("Estad\u00EDsticas de robots");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 247);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		atras.setBounds(10, 173, 63, 21);
		panel.add(atras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 39, 342, 124);
		panel.add(scrollPane);
		
		tablas(scrollPane);
		setDatos();
		
		txtpnRobots = new JTextPane();
		txtpnRobots.setEditable(false);
		txtpnRobots.setText("Robots:");
		txtpnRobots.setBounds(45, 10, 84, 19);
		panel.add(txtpnRobots);
		
		this.setLocationRelativeTo(null);
	}
	public void tablas(JScrollPane scrollPane) {
		table = new JTable();
		scrollPane.setViewportView(table);
		tabla = new DefaultTableModel() {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		setModelo();
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
	}
	public void setModelo() {
		String[] cabecera = {"Nombre","Vida","Ataque","Velocidad"};
		tabla.setColumnIdentifiers(cabecera);
		table.setModel(tabla);
	}
	public void setDatos() {
        Object[] datos = new Object[4];
        for(Robot robot : sistema.getRobots()) {
        	int vida = 0;
        	int ataque = 0;
        	int velocidad = 0;
        	datos[0] = robot.getNombre();
        	for(Pieza pieza : robot.getPiezas()) {
        		vida = pieza.getVidaTotal();
        		if(pieza instanceof Piernas) {
        			Piernas piernas = (Piernas) pieza;
        			velocidad += piernas.getVelocidad();
        		}
        		if(pieza instanceof Brazos) {
        			Brazos brazos = (Brazos) pieza;
        			ataque += brazos.getAtaque();
        		}
        		if(pieza instanceof Torax) {
        			Torax torax = (Torax) pieza;
        			vida += torax.getVida();
        		}
        		if(pieza instanceof Cabeza) {
        			Cabeza cabeza = (Cabeza) pieza;
        			vida += cabeza.getVida();
        			velocidad += cabeza.getVelocidad();
        		}
        	}
        	datos[1] = vida;
        	datos[2] = ataque;
        	datos[3] = velocidad;
        	tabla.addRow(datos);
        }
		/*
		 * datos[0] = "Hola"; datos[1] = "100"; datos[2] = "200"; datos[3] = "156";
		 * tabla.addRow(datos);
		 */
        
	}
	
}
