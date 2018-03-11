package br.usjt.arqsw.entity;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Chamado {
		
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDt_abertura() {
		return dt_abertura;
	}
	public void setDt_abertura(Date dt_abertura) {
		this.dt_abertura = dt_abertura;
	}
	public Date getDt_fechamento() {
		return dt_fechamento;
	}
	public void setDt_fechamento(Date dt_fechamento) {
		this.dt_fechamento = dt_fechamento;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	

}
