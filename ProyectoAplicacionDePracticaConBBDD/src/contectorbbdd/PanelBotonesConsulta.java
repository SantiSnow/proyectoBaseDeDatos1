package contectorbbdd;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesConsulta extends JPanel{

	public JButton consultar, salir;
	
	public PanelBotonesConsulta() {
		iniciarComponentes();
		agregarComponentes();
	}
	
	private void iniciarComponentes() {
		consultar = new JButton("Consultar");
		consultar.setMnemonic('c');
		salir = new JButton("Salir");
		salir.setMnemonic('s');
	}
	
	private void agregarComponentes() {
		add(consultar);
		add(salir);
	}
}
