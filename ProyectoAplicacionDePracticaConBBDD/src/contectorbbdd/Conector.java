package contectorbbdd;

import java.sql.*;

public class Conector {

	Connection conexion;
	String error;
	
	public Conector(String host, String usuario, String pw, String base) {
		try {
			/* esto crea una asociacion entre la aplicacion
			 * y la clase Driver dentro del paquete jar de conexion */
			Class.forName("com.mysql.jdbc.Driver");
			/* La conexion se crea con un string que usa los parametros del constructor */
			conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+base, usuario, pw);
		
		
		} catch (ClassNotFoundException e) { //si no encuentra el driver
			error=e.getMessage();
		} catch (SQLException e) { //si falla la conexion
			error=e.getMessage();
		}
	}

	public Connection getConexion() {
		return conexion;
	}
	
	public void cierraConexion() {
		try {
			conexion.close();
		}
		catch (Exception e) {
			
		}
	}
	
	public String getMensajeError() {
		return error;
	}
}
