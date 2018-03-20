package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Classe Bean Fila
 * @author	Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
public class Fila implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull(message="A fila não pode ser vazia")
	@Min(value=1, message="A fila não pode ser vazia")
	private int id;
	
	@NotNull
	@Size(min=5, max=45, message="O nome da fila deve estar entre 5 e 45 caracteres.")
	private String nome;
	
	/** Metodo modificador getId retorna o valor do id de uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	int
	 */	
	public int getId() {
		return id;
	}
	
	/** Metodo Altera setId retorna o valor do id de uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param 	int
	 */	
	public void setId(int id) {
		this.id = id;
	}
	
	/** Metodo modificador getNome retorna do nome de uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	public String getNome() {
		return nome;
	}
	
	/** Metodo modificador setNome Altera o valor do nome de uma Fila
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	String
	 */	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/** Metodo modificador toString retorna todos os atributos em uma String
	 * @author	816122707 - Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}
	
}
