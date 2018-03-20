package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.UsuarioService;

/**
 * Classe LoginController atende todas as requisições  para acesso co login
 * @author	816122707 - Ermerson Rafael da Silva
 * @version 1.00
 */	
@Controller
public class LoginController {
	private UsuarioService usuarioService;

	/** Construtor da Classe
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	UsuarioService
	 */	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/** Metodo login atende a requição e retorna para o loginForm
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	String
	 */	
	@RequestMapping("loginForm")
	public String login() {
		return "loginForm";
	}
	
	/** efetuarLogin, atende a reuisição e direciona para o formulario de login
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	String
	 */	
	@RequestMapping("/efetuar_login")
	public String efetuarLogin(Usuario usuario, Model model, HttpServletRequest request) {
		try {
			if(usuarioService.validar(usuario)){
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuario);
				return "index";
			}
			return "loginForm";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	/** efetuarLogin, permite que o usuario de logout da pagina
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	Model, HttpServletRequest
	 * @return	String
	 */	
	@RequestMapping("/efetuar_logout")
	public String efetuarLogin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}

}
