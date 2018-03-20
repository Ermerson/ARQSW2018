package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;

/** Classe UsuarioService contem todos os servicos de um usuario
 * @author	816122707 - Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
@Service
public class UsuarioService {
	private UsuarioDAO dao;
	
	/** Metodo Construtor da classe
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	UsuarioDAO
	 */	
	@Autowired
	public UsuarioService(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	/** Metodo validar, valida a existencia de um usuario
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	Usuario
	 * @return 	Boolean
	 */	
	public Boolean validar(Usuario usuario) throws IOException {
		return dao.validar(usuario);
	}

}
