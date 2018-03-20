package br.usjt.arqsw.entity;

import javax.validation.constraints.NotNull;
/**
 * 
 * @author 81612389 - William Morone Varga
 *
 */
public class Usuario {
	
	private int id;
	@NotNull(message="Atenção: o campo usuario não pode ser nulo!")
	private String username;
	
	@NotNull(message="Atenção: o campo senha não pode ser nulo!")
	private String password;
	
	/** Metodo modificador getId retorna o valor do id de um usuario
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	int
	 */	
	public int getId() {
		return id;
	}
	
	/** Metodo modificador setId Altera o valor do id de um usuario
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	int
	 */	
	public void setId(int id) {
		this.id = id;
	}
	
	/** Metodo modificador getUsername retorna o nome do usuario
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	public String getUsername() {
		return username;
	}
	
	/** Metodo modificador setUsername altera a propriedade userName
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	String
	 */	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/** Metodo modificador getPassword retorna o valor da propriedade password
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	public String getPassword() {
		return password;
	}
	
	/** Metodo modificador setPassword Altera o valor da propriedade password
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	String
	 */	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** Metodo toString retorna as informações do objeto em String
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + "]";
	}

}
