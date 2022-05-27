package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase es la que importa datos a la base de datos
 * letra.
 */
public class MySqlAcces {
	private Connection connect = null; 	
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost:3306/letra";
	final private String user = "root";
	final private String passwd = "root";

	public Connection readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);
		} catch (Exception e) {
			throw e;
		}	
		return connect;
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo inserta un registro en la base de datos
	 */
	public void insertRegistro(String letra, String palabra, int linea) throws Exception {
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("insert into registro"
					+ "(letra, palabra, linea) values (?, ?, ?)");
			preparedStatement.setString(1, letra);
			preparedStatement.setString(1, palabra);
			preparedStatement.setInt(2, linea);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: Este metodo selecciona los registros y los añade en un Array.
	 */
	protected ArrayList<Registro> writeRegistro() throws SQLException {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		try {
			connect = readDataBase();
			preparedStatement = connect.prepareStatement("SELECT * from registro");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Registro registro = new Registro(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getInt(4));
				registros.add(registro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}
}
