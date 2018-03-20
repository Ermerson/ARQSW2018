package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

/** Classe para controlar as requisições do cliente com o servidor
 * @author	Ermerson Rafael da Silva
 * @version 1.00
 * @since   Release Inicial
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;
	
	/** Metodo construtor da Classe ManterChamados
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Nenhum
	 * @return 	Nenhum
	 */
	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService) {
		this.filaService = filaService;
		this.chamadoService = chamadoService;
	}

	/** Metodo mapeando a requisição para pagina Index
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Nenhum
	 * @return 	String
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	/** Metodo consulta e retorna as Filas de Serviço
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Nenhum
	 * @return 	List<Fila>
	 */
	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	/** Metodo mapeando a requisição para pagina de listar Filas
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Model
	 * @return 	String
	 */	
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	/** Metodo mapeando a requisição para pagina de listar os chamados
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila, BindingResult, Model
	 * @return 	String
	 */	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				System.out.println("Deu erro " + result.toString());
				return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			model.addAttribute("chamados", chamadoService.listarChamados(fila));
			
			return "ChamadoListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	/** Metodo mapeando a requisição para pagina de inclusão de chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila, BindingResult, Model
	 * @return 	String
	 */	
	@RequestMapping("/criar_novo_chamado")
	public String criarNovoChamado(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoCriar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	/** Metodo mapeando a requisição para pagina de inclusão de chamado
	 * @author	Ermerson Rafael da Silva
	 * @version 1.00
	 * @since   Release Inicial
	 * @param	Fila, BindingResult, Model
	 * @return 	String
	 */	
	@RequestMapping("/salvar_chamado")
	public String listarChamadosExibir(@Valid Chamado chamado, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				System.out.println("Deu erro " + result.toString());
				return "redirect:criar_novo_chamado";
			}
			
			int id = chamadoService.criarChamado(chamado);
			model.addAttribute("id_chamado", id);
			return "ChamadoSalvo";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
