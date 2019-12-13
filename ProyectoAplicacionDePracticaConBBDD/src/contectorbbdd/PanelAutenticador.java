package contectorbbdd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelAutenticador extends JPanel{

	//atributos
	public JTextField servidor, usuario, base;
	public JPasswordField password;
	public JButton aceptar, cancelar;
	
	public PanelAutenticador() {
		iniciarComponentes();
		agregaComponentes();
	}
	
	private void iniciarComponentes() {
		servidor = new JTextField();
		usuario = new JTextField();
		base = new JTextField();
		password = new JPasswordField();
		
		aceptar = new JButton("Aceptar");
		aceptar.setMnemonic('a');
		cancelar = new JButton("Cancelar");
		cancelar.setMnemonic('s');
	}
	
	private void agregaComponentes() {
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Servidor", JLabel.RIGHT));
		add(servidor);
		add(new JLabel("Usuario", JLabel.RIGHT));
		add(usuario);
		add(new JLabel("Contraseña", JLabel.RIGHT));
		add(password);
		add(new JLabel("Base de datos", JLabel.RIGHT));
		add(base);
		add(aceptar);
		add(cancelar);
	}
}
