package contectorbbdd;

import javax.swing.JDialog;

public class DialogoAutenticar extends JDialog{
	//atributos
	public PanelAutenticador panel;
	//constructor
	public DialogoAutenticar() {
		panel = new PanelAutenticador();
		add(panel);
		setSize(300,200);
	}
}
