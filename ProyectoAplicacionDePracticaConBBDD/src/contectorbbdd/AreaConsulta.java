package contectorbbdd;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AreaConsulta extends JScrollPane{
	
	public JTextArea texto;

	public AreaConsulta() {
		texto=new JTextArea(4, 30);
		//hace que las lineas corten en el limite del area
		texto.setLineWrap(true);
		//hace que corten solo en las palabras complejas
		texto.setWrapStyleWord(true);
		//dentro de las barras se vera el area de texto
		setViewportView(texto);
	}
}
