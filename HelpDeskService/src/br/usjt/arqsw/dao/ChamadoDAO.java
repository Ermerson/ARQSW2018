package br.usjt.arqsw.dao;



import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/** Classe Data Access Object  para comunicaçao com o banco de dados
 * @author	Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */
public class ChamadoDAO {
	
	/** Metodo lista todos os Chamados de acordo com uma Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 * @return 	ArrayList<Chamado>
	 */	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		String query = "SELECT CH.ID_CHAMADO, "
							+ "CH.DESCRICAO, "
							+ "CH.STATUS, "
							+ "CH.DT_ABERTURA, "
							+ "CH.DT_FECHAMENTO, "
							+ "FL.ID_FILA, "
							+ "FL.NM_FILA "
						+ "FROM CHAMADO AS CH INNER JOIN FILA AS FL ON CH.ID_FILA = FL.ID_FILA "
						+ "WHERE FL.ID_FILA = ? ";
		
		ArrayList<Chamado> chamados = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);){
			pst.setInt(1, fila.getId());
			try(ResultSet rs = pst.executeQuery();){				
				while(rs.next()) {
					Chamado chamado = new Chamado();
					chamado.setId(rs.getInt("ID_CHAMADO"));
					chamado.setDescricao(rs.getString("CH.DESCRICAO"));
					chamado.setStatus(rs.getString("CH.STATUS"));
					chamado.setDt_abertura(rs.getDate("CH.DT_ABERTURA"));
					chamado.setDt_fechamento(rs.getDate("CH.DT_FECHAMENTO"));
					fila.setId(rs.getInt("FL.ID_FILA"));
					fila.setNome(rs.getString("FL.NM_FILA"));
					chamado.setFila(fila);					
					chamados.add(chamado);
				}
			}catch (SQLException e1) {
				throw new IOException(e1);
			}			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return chamados;
	}
	
	public int incluir(Chamado ch) throws IOException {
		String string = "INSERT INTO CHAMADO(DESCRICAO, STATUS, DT_ABERTURA, ID_FILA) "
							+ "VALUES (?, Aberto, Now(), ? )";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(string);) {
				stm.setString(1, ch.getDescricao());
				//stm.setString(2, ch.getStatus());
				//stm.setDate(3, (Date)ch.getDt_abertura());
				stm.setInt(2, ch.getFila().getId());
				stm.execute();
				
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						ch.setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ch.getId();
		}

}
