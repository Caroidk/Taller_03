package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Pieza;
import dominio.Robot;
import dominio.RobotHumano;
import logica.SistemaRobotsImpl;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotsPiloto extends JFrame {

	private JPanel panel;
	private JTextField nombrePiloto;
	private DefaultTableModel tabla;
	private JTable table;
	private SistemaRobotsImpl sistema;
	private JButton atras;

	/**
	 * Create the frame.
	 */
	public RobotsPiloto() {
		sistema = new SistemaRobotsImpl();
		sistema.leerRobots();
		setTitle("Mostrar robots por piloto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		JTextArea txtrNombreDePiloto = new JTextArea();
		txtrNombreDePiloto.setEditable(false);
		txtrNombreDePiloto.setText("Nombre de piloto:");
		txtrNombreDePiloto.setBounds(26, 10, 155, 22);
		panel.add(txtrNombreDePiloto);
		
		nombrePiloto = new JTextField();
		nombrePiloto.setBounds(191, 13, 123, 19);
		panel.add(nombrePiloto);
		nombrePiloto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 64, 342, 124);
		panel.add(scrollPane);
		
		tablas(scrollPane);
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				String nombre = nombrePiloto.getText();
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
		ArrayList<Robot> robots = sistema.robotsPiloto(nombre);
		
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
