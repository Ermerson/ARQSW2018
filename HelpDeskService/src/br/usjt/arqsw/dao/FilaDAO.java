package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Fila;

public class FilaDAO {

	public ArrayList<Fila> listarFilas() throws IOException {
		String query = "select id_fila, nm_fila from fila";
		ArrayList<Fila> lista = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();){
			
			while(rs.next()) {
				Fila fila = new Fila();
				fila.setId(rs.getInt("id_fila"));
				fila.setNome(rs.getString("nm_fila"));
				lista.add(fila);
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}
	
	public Fila carregar(int id) throws IOException {
		Fila fila = new Fila();
		String query = "SELECT ID_FILA, NM_FILA FROM FILA WHERE FILA.ID_FILA = ?";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);){			
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next()) {
					fila.setId(rs.getInt("ID_FILA"));
					fila.setNome(rs.getString("NM_FILA"));
				}else {
					fila.setId(-1);
					fila.setNome(rs.getString(null));
				}				
			}catch(SQLException e1) {
				throw new IOException(e1);
			}			
		}catch(SQLException e) {
			throw new IOException(e);
		}	
		
		return fila;
	}

}
