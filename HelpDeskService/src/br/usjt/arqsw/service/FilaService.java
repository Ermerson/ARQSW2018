package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Fila;

/** Classe FilaService, contem os serviços  da Fila
 * @author	816122707 - Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
public class FilaService {
	private FilaDAO dao;
	
	/** Metodo Construtor 
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 */	
	@Autowired
	public FilaService(FilaDAO dao) {
		this.dao = dao;
	}
	
	/** Metodo listarFilas Retorna todas as filas do banco de dados
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	ArrayList<Fila>
	 */	
	public ArrayList<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	
	/** Carregar  retorna uma fila de acordo com o Id informado nos parametros
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	int
	 * @return 	Fila
	 */	
	public Fila carregar(int id) throws IOException{		
		return dao.carregar(id);
	}
}
