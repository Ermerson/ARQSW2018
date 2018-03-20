package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/** classe de serviço chamado
 * @author	816122707 - Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 * 
 */	
@Service
public class ChamadoService {	
	private ChamadoDAO dao;
	
	/** Metodo construtor da classe
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 */		
	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}
	
	/** Metodo retorna uma lista de Chamados cadastrados de acordo com uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 * @return 	ArrayList<Chamado>
	 */	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		return dao.listarChamados(fila);		
	}
	
	/** Metodo retorna uma lista de Chamados cadastrados de acordo com uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 * @return 	ArrayList<Chamado>
	 */	
	public int criarChamado(Chamado chamado) throws IOException {
		chamado.setStatus(Chamado.OPEN);
		chamado.setDt_abertura(new Date());
		return dao.criarChamado(chamado);
	}

}
