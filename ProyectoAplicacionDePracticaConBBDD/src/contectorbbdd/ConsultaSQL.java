package contectorbbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaSQL {
	//atributos
	private Connection conexion;
	private ResultSet resultadoConsulta;
	private ResultSetMetaData metaDatos;
	private String consulta;
	private String [][] datosDevueltos;
	private String [] nombresColumnas;
	private String error;
	
	//constructor
	public ConsultaSQL(Connection conRecibida, String consultaRecibida) {
		conexion = conRecibida;
		consulta = consultaRecibida;
		
		try {
			//crea una instancia para mandar sentencias al mysql
			Statement sentencia = conexion.createStatement();
			//ejecuta la consulta y devuelve el resultset
			resultadoConsulta = sentencia.executeQuery(consulta);
			//obtiene los metadatos del resultset
			metaDatos = resultadoConsulta.getMetaData();
			
			error = null;
		}
		
		catch(SQLException e) {
			error = e.getMessage();
		}
	}
	
	public String [][] getDatosDevueltos(){
		if(error==null) {
			try {
				
				int columnas = metaDatos.getColumnCount();
				
				resultadoConsulta.last();
				
				int filas = resultadoConsulta.getRow();
				
				datosDevueltos = new String [filas][columnas];
				
				resultadoConsulta.beforeFirst();
				
				for(int i = 0; i<filas; i++) {
					resultadoConsulta.next();
					for(int j = 0; i <columnas; i++) {
						datosDevueltos[i][j] = resultadoConsulta.getString(j+i); 
					}
				}
			}
			
			catch(Exception e) {
				
			}
		}
		return datosDevueltos;
	}
	
	public String[] getNombresColumnas() {
		if(error == null) {
			try {
				
				int columnas = metaDatos.getColumnCount();
				
				nombresColumnas = new String [columnas];
				
				for(int i=0; i<columnas; i++) {
					nombresColumnas[i] = metaDatos.getColumnLabel(i+1);
				}
			}
			catch(SQLException ex) {
				
			}
		}
		return nombresColumnas;
	}
	
	public String getMensajeError() {
		return error;
	}
	
}
