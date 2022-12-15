package gui;

import logica.*;
import dominio.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AnadirPiezas extends JFrame {

	private JPanel panel;
	private JTextField textField;
	private JTextField velocidad;
	private JTextField ataque;
	private JTextField vida;
	private SistemaRobotsImpl sistema;

	/**
	 * Create the frame.
	 */
	public AnadirPiezas() {
		
		sistema = new SistemaRobotsImpl();
		
		setTitle("A\u00F1adir pieza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		JTextPane txtpnNombreDePieza = new JTextPane();
		txtpnNombreDePieza.setText("Nombre de pieza:");
		txtpnNombreDePieza.setEditable(false);
		txtpnNombreDePieza.setBounds(10, 21, 118, 19);
		panel.add(txtpnNombreDePieza);
		
		JTextField nombre = new JTextField();
		nombre.setBounds(120, 21, 229, 19);
		panel.add(nombre);
		nombre.setColumns(10);
		
		JTextPane txtpnTipoDePieza = new JTextPane();
		txtpnTipoDePieza.setEditable(false);
		txtpnTipoDePieza.setText("Rareza de pieza:");
		txtpnTipoDePieza.setBounds(10, 61, 102, 19);
		panel.add(txtpnTipoDePieza);
		
		JComboBox rareza = new JComboBox();
		rareza.setModel(new DefaultComboBoxModel(new String[] {"Pieza Premium", "Pieza Estándar", "Pieza Común"}));
		
		rareza.setBounds(120, 59, 229, 21);
		panel.add(rareza);
		
		JTextPane txtpnTipoDePieza_1 = new JTextPane();
		txtpnTipoDePieza_1.setEditable(false);
		txtpnTipoDePieza_1.setText("Tipo de pieza:");
		txtpnTipoDePieza_1.setBounds(10, 105, 88, 19);
		panel.add(txtpnTipoDePieza_1);
		
		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"Piernas", "Brazos", "Tórax", "Cabeza"}));
		tipo.setBounds(120, 103, 229, 21);
		panel.add(tipo);
		
		JTextPane txtpnVelocidad = new JTextPane();
		txtpnVelocidad.setEditable(false);
		txtpnVelocidad.setEnabled(false);
		txtpnVelocidad.setText("Velocidad:");
		txtpnVelocidad.setBounds(10, 146, 71, 19);
		panel.add(txtpnVelocidad);
		
		velocidad = new JTextField();
		velocidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        e.consume();
			    }
			    if (velocidad.getText().trim().length() == 6) {
			        e.consume();
			    }

			}
		});
		velocidad.setToolTipText("");
		velocidad.setEditable(false);
		velocidad.setEnabled(false);
		velocidad.setBounds(91, 146, 96, 19);
		panel.add(velocidad);
		velocidad.setColumns(10);
		
		JTextPane txtpnAtaque = new JTextPane();
		txtpnAtaque.setEditable(false);
		txtpnAtaque.setEnabled(false);
		txtpnAtaque.setText("Ataque:");
		txtpnAtaque.setBounds(10, 182, 71, 19);
		panel.add(txtpnAtaque);
		
		ataque = new JTextField();
		ataque.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        e.consume();
			    }
			    if (ataque.getText().trim().length() == 6) {
			        e.consume();
			    }
			}
		});
		ataque.setEditable(false);
		ataque.setEnabled(false);
		ataque.setBounds(91, 182, 96, 19);
		panel.add(ataque);
		ataque.setColumns(10);
		
		JTextPane txtpnVida = new JTextPane();
		txtpnVida.setEditable(false);
		txtpnVida.setEnabled(false);
		txtpnVida.setText("Vida:");
		txtpnVida.setBounds(10, 221, 71, 19);
		panel.add(txtpnVida);
		
		vida = new JTextField();
		vida.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        e.consume();
			    }
			    if (vida.getText().trim().length() == 6) {
			        e.consume();
			    }
			}
		});
		vida.setEditable(false);
		vida.setEnabled(false);
		vida.setBounds(91, 221, 96, 19);
		panel.add(vida);
		vida.setColumns(10);
		
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		atras.setBounds(13, 267, 85, 21);
		panel.add(atras);
		
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nombre.getText();
				String r = rareza.getSelectedItem().toString();
				String rare;
				int vida0 = 0;
				int velocidad0 = 0;
				int ataque0 = 0;
				if(r.equals("Pieza Premium")) {
					rare = "PP";
					vida0 = 3000;
					ataque0 = 200;
				}else if(r.equals("Pieza Estándar")) {
					rare = "PE";
					vida0 = 2000;
					ataque0 = 100;
				}else {
					rare = "PC";
					vida0 = 1000;
				}
				String item = tipo.getSelectedItem().toString();
				if(vida.getText().isEmpty()) {
					vida0 += 0;
				}else {
					vida0 += Integer.parseInt(vida.getText());
				}
				if(velocidad.getText().isEmpty()) {
					velocidad0 += 0;
				}else {
					velocidad0 += Integer.parseInt(velocidad.getText());
				}
				if(ataque.getText().isEmpty()) {
					ataque0 += 0;
				}else {
					ataque0 += Integer.parseInt(ataque.getText());
				}
				if(vida.getText().isEmpty()&&velocidad.getText().isEmpty()&&ataque.getText().isEmpty()||nombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Rellene todos los campos solicitados.");
				}else {
					sistema.anadirPieza(name, rare, item, velocidad0, vida0, ataque0);
					JOptionPane.showMessageDialog(panel, "Pieza añadida correctamente.");
					Menu menu = new Menu();
					menu.setVisible(true);
					dispose();
				}
			}
		});
		guardar.setBounds(325, 267, 85, 21);
		panel.add(guardar);
		
		JButton confirmar = new JButton("Ok");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = tipo.getSelectedItem().toString();
				if(item.equals("Piernas")) {
					txtpnVelocidad.setEnabled(true);
					velocidad.setEnabled(true);
					velocidad.setEditable(true);
					txtpnAtaque.setEnabled(false);
					ataque.setEnabled(false);
					ataque.setEditable(false);
					ataque.setText(null);
					txtpnVida.setEnabled(false);
					vida.setEnabled(false);
					vida.setEditable(false);
					vida.setText(null);
				} else if(item.equals("Brazos")) {
					txtpnAtaque.setEnabled(true);
					ataque.setEnabled(true);
					ataque.setEditable(true);
					txtpnVelocidad.setEnabled(false);
					velocidad.setEnabled(false);
					velocidad.setEditable(false);
					velocidad.setText(null);
					txtpnVida.setEnabled(false);
					vida.setEnabled(false);
					vida.setEditable(false);
					vida.setText(null);
				} else if(item.equals("Tórax")) {
					txtpnVida.setEnabled(true);
					vida.setEnabled(true);
					vida.setEditable(true);
					txtpnVelocidad.setEnabled(false);
					velocidad.setEnabled(false);
					velocidad.setEditable(false);
					velocidad.setText(null);
					txtpnAtaque.setEnabled(false);
					ataque.setEnabled(false);
					ataque.setEditable(false);
					ataque.setText(null);
				} else {
					txtpnVida.setEnabled(true);
					vida.setEnabled(true);
					vida.setEditable(true);
					txtpnVelocidad.setEnabled(true);
					velocidad.setEnabled(true);
					velocidad.setEditable(true);
					velocidad.setText(null);
					txtpnAtaque.setEnabled(false);
					ataque.setEnabled(false);
					ataque.setEditable(false);
					ataque.setText(null);
				}
			}
		});
		confirmar.setBounds(359, 103, 50, 21);
		panel.add(confirmar);
		this.setLocationRelativeTo(null);
	}
}
