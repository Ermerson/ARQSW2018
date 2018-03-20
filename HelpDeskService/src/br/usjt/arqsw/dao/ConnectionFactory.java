package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Classe para Conexão com o Banco de Dados
 * @author	Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** Metodo lista todos os Chamados de acordo com uma Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Nenhum
	 * @return 	Connection
	 */	
	public static Connection getConnection() throws IOException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/servicedesk?"
					+ "user=root&password=root&useSSL=false");
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return conn;
	}
}
