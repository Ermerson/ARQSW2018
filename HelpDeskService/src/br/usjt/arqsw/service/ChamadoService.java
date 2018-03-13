package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/** classe de serviço chamado
 * @author	Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
public class ChamadoService {
	
	private ChamadoDAO dao;
	
	/** Metodo construtor da classe
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 */	
	public ChamadoService() {
		dao = new ChamadoDAO();
	}
	
	
	/** Metodo retorna uma lista de Chamados cadastrados de acordo com uma Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 * @return 	ArrayList<Chamado>
	 */	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{		
		return dao.listarChamados(fila);
	}
	
	/** Metodo retorna uma lista de Chamados cadastrados de acordo com uma Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 * @return 	ArrayList<Chamado>
	 */	
	
	public int incluirChamado(Chamado chamado) throws IOException {
		return dao.incluir(chamado);
	}

}
