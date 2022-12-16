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
import java.util.ArrayList;
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
		sistema.leerPiezas();
		sistema.leerRobots();
		
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
		ArrayList<Robot> robots = sistema.getRobots();
		
		Object[] datos = new Object[4];
        for(int i=0; i<robots.size(); i++) {
        	int[] stats = sistema.statsRobot(robots.get(i));
        	
        	Object[] fila = {robots.get(i).getNombre(),stats[0],stats[1],stats[2]};
        	tabla.addRow(fila);
        }
	}
	
}
