package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaUno extends JFrame{
	//atributos
	JFrame ventana;
	JPanel panel;
	JLabel etiqueta;
	JButton boton1;
	JButton botonSalida;
	//constructor
	public VentanaUno() {
		//instanciamos los componentes
		ventana = new JFrame();
		panel = new JPanel();
		etiqueta = new JLabel();
		boton1 = new JButton();
		botonSalida = new JButton();
		//agregamos metodos basicos para la ventana
		panel.setLayout(null);
		setVisible(true);
		setSize(500, 500);
		setTitle("Programa con BB DD");
		setLocation(10, 10);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		panel.setBackground(Color.DARK_GRAY);
		//los agregamos
		add(panel);
		panel.add(etiqueta);
		panel.add(boton1);
		panel.add(botonSalida);
		//llamamos a los metodos
		etiquetas();
		botones();
		metodosVentana();
	}
	//metodos para darle formato a las etiquetas
	public void etiquetas() {
		etiqueta.setText("Hola, este es un programa con BBDD");
		etiqueta.setForeground(Color.WHITE);
		etiqueta.setBounds(20, 20, 350, 20);
		etiqueta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	}
	//metodos para darle formato a los botones
	public void botones() {
		boton1.setText("Entrar");
		boton1.setBounds(100, 150, 150, 30);
		
		botonSalida.setText("Salir");
		botonSalida.setBounds(100, 190, 150, 30);
		
		ActionListener accion1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Éxito!");
			}
		};
		
		ActionListener accion2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		
		boton1.addActionListener(accion1);
		botonSalida.addActionListener(accion2);
	}
	//metodos de la ventana
	public void metodosVentana() {
		WindowListener wl1 = new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Salir",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
				if(resp == 0) {
					System.exit(0);
				}
				else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		addWindowListener(wl1);
	}
	
	
}
