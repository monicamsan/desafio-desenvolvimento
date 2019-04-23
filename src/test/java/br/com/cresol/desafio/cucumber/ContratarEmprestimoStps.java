package br.com.cresol.desafio.cucumber;

import java.util.List;

import br.com.cresol.desafio.dto.ClienteDTO;
import br.com.cresol.desafio.dto.ContratarEmprestimoDTO;
import br.com.cresol.desafio.dto.SimulacaoEmprestimoDTO;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
/**
 * @author Fernando Estrela
 *
 */

public class ContratarEmprestimoStps extends SpringStep{
	
	@Dado("^que tenha um cliente com seguintes dados ContratarEmprestimo\\.$")
	public void queTenhaUmClienteComSeguintesDadosContratarEmprestimo(List<ClienteDTO> clientes){
		super.saveClientes(clientes);
		super.findCliente(1L);
		super.validaClienteExistente();
	}

	@Dado("^que tenha simulacao com seguintes dados ContratarEmprestimo$")
	public void queTenhaSimulacaoComSeguintesDadosContratarEmprestimo(List<SimulacaoEmprestimoDTO> simulacaoEmprestimoDTOs){
		super.saveSimularEmprestimo(simulacaoEmprestimoDTOs);
		super.findSimularEmprestimo(3L);
	}

	@Dado("^que tenha contrato emprestimo com seguintes dados$")
	public void queTenhaContratoEmprestimoComSeguintesDados(List<ContratarEmprestimoDTO> contratarEmprestimoDTOs){
		super.saveContratarEmprestimo(contratarEmprestimoDTOs);
	}

	@Quando("^quando consultar o ContratarEmprestimo com id (\\d+)\\.$")
	public void quandoConsultarOContratarEmprestimoComId(int arg1){
		super.findContratarEmprestimo(Long.valueOf(arg1));
	}

	@Entao("^retornará o ContratarEmprestimo cadastrado anteriomente\\.$")
	public void retornaraOContratarEmprestimoCadastradoAnteriomente(){
		super.validaContratarEmprestimo();
	}

}
