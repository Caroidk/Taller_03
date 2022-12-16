package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Robot;
import dominio.RobotHumano;
import logica.SistemaRobotsImpl;

public class RobotsEquipo extends JFrame {

	private JPanel panel;
	private DefaultTableModel tabla;
	private JTable table;
	private SistemaRobotsImpl sistema;
	private JTextField nombreEquipo;
	private JButton atras;

	/**
	 * Create the frame.
	 */
	public RobotsEquipo() {
		sistema = new SistemaRobotsImpl();
		sistema.leerRobots();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 64, 342, 124);
		panel.add(scrollPane);
		
		tablas(scrollPane);
		
		JTextArea txtr = new JTextArea();
		txtr.setEditable(false);
		txtr.setText("Nombre de equipo:");
		txtr.setBounds(26, 10, 155, 22);
		panel.add(txtr);
		
		nombreEquipo = new JTextField();
		nombreEquipo.setBounds(191, 13, 123, 19);
		panel.add(nombreEquipo);
		nombreEquipo.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				String nombre = nombreEquipo.getText();
				setDatos(nombre);
			}
		});
		buscar.setBounds(330, 12, 85, 21);
		panel.add(buscar);
		
		atras = new JButton("Atr\u00E1s");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		atras.setBounds(26, 220, 85, 21);
		panel.add(atras);
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
	}
	public void setModelo() {
		String[] cabecera = {"Nombre","Piloto","Equipo"};
		tabla.setColumnIdentifiers(cabecera);
		table.setModel(tabla);
	}
		
	public void setDatos(String nombre) {
		ArrayList<Robot> robots = sistema.robotsEquipo(nombre);
		
		Object[] datos = new Object[4];
        for(int i=0; i<robots.size(); i++) {
        	
        	RobotHumano robot = (RobotHumano) robots.get(i);
        	Object[] fila = {robot.getNombre(),robot.getPiloto(),robot.getEquipo()};
        	tabla.addRow(fila);
        	
        	
        }
	}
	
	public void limpiar(){
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        int a = table.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        	tb.removeRow(tb.getRowCount()-1);
        }
    }

}
