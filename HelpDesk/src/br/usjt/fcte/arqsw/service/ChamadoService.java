package br.usjt.fcte.arqsw.service;

import java.util.ArrayList;

import br.usjt.fcte.arqsw.dao.ChamadoDAO;
import br.usjt.ftce.arqsw.model.Chamado;
import br.usjt.ftce.arqsw.model.Fila;


public class ChamadoService {
		
	ChamadoDAO dao = new ChamadoDAO();
	
	public int abrirChamado(Chamado ch, Fila fl) {
		ch = dao.inserir(ch, fl);
		return ch.getId();
	}
	
	public void fecharChamado(Chamado ch, Fila fl) {
			System.out.println("Chamado x foi fechado");
	}
	
	public Chamado consultarChamado(Chamado ch, Fila fl) {
		ch = dao.consultar(ch, fl);
		return ch;
	}
	
	public ArrayList<Chamado> listarChamado(Fila fl){
		ArrayList<Chamado> chamados = dao.ListarChamados(fl);
		return chamados;
	}

}
