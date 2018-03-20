package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/** Classe Data Access Object  para comunicaçao com o banco de dados
 * @author	816122707 - Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */
@Repository
public class ChamadoDAO {
	private Connection conn;
	
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}
	
	/** Metodo lista todos os Chamados de acordo com uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 * @return 	ArrayList<Chamado>
	 */		
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		String query = "SELECT ID_CHAMADO, "
							+ "DESCRICAO, "
							+ "STATUS, "
							+ "DT_ABERTURA, "
							+ "DT_FECHAMENTO, "
							+ "ID_FILA "
						+ "FROM CHAMADO WHERE ID_FILA = ?";
		ArrayList<Chamado> lista = new ArrayList<>();
		try(PreparedStatement pst = conn.prepareStatement(query);){
			pst.setInt(1, fila.getId());
			try(ResultSet rs = pst.executeQuery();){
				
				while(rs.next()) {
					Chamado chamado = new Chamado();
					chamado.setId(rs.getInt("ID_CHAMADO"));
					chamado.setDescricao(rs.getString("DESCRICAO"));
					chamado.setStatus(rs.getString("STATUS"));
					chamado.setDt_abertura(rs.getDate("DT_ABERTURA"));
					chamado.setDt_fechamento(rs.getDate("DT_FECHAMENTO"));
					lista.add(chamado);
				}
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}
	
	
	/** Metodo Cria um chamado no Banco de Dados 
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Chamado
	 * @return 	Int
	 */		
	public int criarChamado(Chamado chamado) throws IOException {
		Date dataAbertura = new Date(chamado.getDt_abertura().getTime());
		
		String sqlInsert = "INSERT INTO CHAMADO("
								+ "DESCRICAO, "
								+ "STATUS, "
								+ "DT_ABERTURA, "
								+ "ID_FILA) "
							+ "VALUES (?, ?, ?, ?)";
		try(PreparedStatement pst = conn.prepareStatement(sqlInsert);){
			pst.setString(1, chamado.getDescricao());
			pst.setString(2, chamado.getStatus());
			pst.setDate(3, dataAbertura);
			pst.setInt(4, chamado.getFila().getId());
			
			pst.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					chamado.setId(rs.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return chamado.getId();
	}
}
