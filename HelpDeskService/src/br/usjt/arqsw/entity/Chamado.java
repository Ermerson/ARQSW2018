package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Classe Bean Chamado
 * @author	Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */	
public class Chamado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="O id chamado não pode ser nulo")
	@Min(value=1, message="O id chamado não pode ser vazio")
	private int 	id;
	
	@NotNull(message="A descrição não pode ser nula.")
	@Size(min=5, max=45, message="a descrição do chamado deve estar entre 5 e 45 caracteres.")
	private String 	descricao;
	
	@NotNull(message="O status não pode ser nulo.")
	@Size(min=5, max=45, message="O status do chamado deve estar entre 5 e 45 caracteres.")
	private String 	status;
	
	@NotNull(message="A data de abertura não pode ser nula")
	@Min(value=1, message="A data de abertura não pode vazia")
	private Date	dt_abertura;
	private Date	dt_fechamento;
	
	@NotNull
	@Min(value=1, message="Deve conter um fila para esse chamado")
	private Fila fila;
	
	/** Metodo modificador getId retorna o valor do id de um chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	int
	 */	
	public int getId() {
		return id;
	}
	
	/** Metodo setId altera o valor do id de uma Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Int
	 */	
	public void setId(int id) {
		this.id = id;
	}
	
	/** Metodo getDescricao retorna a descricao de uma Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	public String getDescricao() {
		return descricao;
	}
	
	/** Metodo setDescricao altera a propriedade  descricao
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	String
	 */	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/** Metodo getStatus retorna o Status de chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	String
	 */	
	public String getStatus() {
		return status;
	}
	
	/** Metodo setStatus Altera o status de um chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	String
	 */	
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** Metodo getDt_abertura retorna a data de abertura de um Chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	Date
	 */	
	public Date getDt_abertura() {
		return dt_abertura;
	}
	
	/** Metodo  setDt_abertura altera a data de abertura de um Chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Date
	 */	
	public void setDt_abertura(Date dt_abertura) {
		this.dt_abertura = dt_abertura;
	}
	
	/** Metodo getDt_fechamento retorna a data de fechamento de um Chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	Date
	 */	
	public Date getDt_fechamento() {
		return dt_fechamento;
	}
	
	/** Metodo  setDt_fechamento Altera a data de fechamento de um Chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Date
	 */	
	public void setDt_fechamento(Date dt_fechamento) {
		this.dt_fechamento = dt_fechamento;
	}
	
	/** Metodo retorna o objeto Fila
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @return 	Fila
	 */	
	public Fila getFila() {
		return fila;
	}
	
	/** Metodo Altera o objeto Fila 
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila
	 */	
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	
}
