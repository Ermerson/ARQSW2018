package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

/** Classe UsuarioDAO, contem as informações para acesso ao banco
 * @author	816122707 - Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
@Repository
public class UsuarioDAO {
	
	private Connection conn;
	
	/** Metodo Construtor da classe
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	DataSource
	 */	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}
	
	/** Metodo Retorna a informação se o usuario existe no sistema
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Usuario
	 * @return 	Boolean
	 */	
	public Boolean validar(Usuario usuario) throws IOException {
		String query = "SELECT username, password FROM usuario WHERE username = ? and password= ?";
		try(PreparedStatement pst = conn.prepareStatement(query);){
			pst.setString(1, usuario.getUsername());
			pst.setString(2, usuario.getPassword());
			
			try(ResultSet rs = pst.executeQuery();) {
				if(rs.next()) {
					return true;
				}				
			}			
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return false;		
	}
}
