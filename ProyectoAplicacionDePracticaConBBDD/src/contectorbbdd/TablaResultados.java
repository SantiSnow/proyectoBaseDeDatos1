package contectorbbdd;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaResultados extends JScrollPane{

	public ModeloTabla modelo;
	public JTable tabla;
	
	public TablaResultados() {
		modelo = new ModeloTabla();
		tabla = new JTable(modelo);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		setViewportView(tabla);
	}
	
}
