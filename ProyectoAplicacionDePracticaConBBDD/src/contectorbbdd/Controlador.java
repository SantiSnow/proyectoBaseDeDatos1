package contectorbbdd;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Controlador {

	Conector conMySQL;
	
	public Controlador() {}
	
	public void acciones(VentanaConsultas visor, ActionEvent evt) {
		Object clickeado = evt.getSource();
		
		if(clickeado==visor.autenticador.panel.aceptar) {
			String host = visor.autenticador.panel.servidor.getText();
			String usuario = visor.autenticador.panel.usuario.getText();
			String password = new String (visor.autenticador.panel.password.getPassword());
			String base = visor.autenticador.panel.base.getText();
			conMySQL = new Conector(host, usuario, password, base);
			if(conMySQL.getConexion() != null) {
				visor.autenticador.dispose();
			}
			else {
				muestraError("El error que envia SQL es: "+conMySQL.getMensajeError());
			}
		}
		
		if(clickeado==visor.botones.consultar) {
			ConsultaSQL consulta = new ConsultaSQL(conMySQL.getConexion(), visor.area.texto.getText());
			if(consulta.getMensajeError()==null) {
				visor.resultados.modelo.setDataVector(consulta.getDatosDevueltos(), consulta.getNombresColumnas());
			}
			else {
				muestraError("El error que envia SQL es: "+consulta.getMensajeError());
			}
		}
		
		if(clickeado==visor.autenticador.panel.cancelar || clickeado==visor.botones.salir) {
			System.exit(0);
		}
	}
	
	private void muestraError(String e) {
		JOptionPane.showMessageDialog(null, e);
	}
}
