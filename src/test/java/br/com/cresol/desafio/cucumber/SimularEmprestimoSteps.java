package br.com.cresol.desafio.cucumber;

import java.util.List;

import br.com.cresol.desafio.dto.ClienteDTO;
import br.com.cresol.desafio.dto.SimulacaoEmprestimoDTO;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
/**
 * @author Fernando Estrela
 *
 */
public class SimularEmprestimoSteps extends SpringStep{
	
	@Dado("^que tenha um cliente com seguintes dados\\.$")
	public void queTenhaUmClienteComSeguintesDados(List<ClienteDTO> clientes) {
		super.saveClientes(clientes);
		super.findCliente(1L);
		super.validaClienteExistente();
	}

	@Dado("^que tenha simulacao com seguintes dados$")
	public void queTenhaSimulacaoComSeguintesDados(List<SimulacaoEmprestimoDTO> simulacaoEmprestimoDTOs) {
		super.saveSimularEmprestimo(simulacaoEmprestimoDTOs);
	}
	@Quando("^quando consultar a SimularEmprestimo com id (\\d+)\\.$")
	public void quandoConsultarASimularEmprestimoComId(int arg1) {
		super.findSimularEmprestimo(Long.valueOf(arg1));
	}

	@Entao("^retornará o SimularEmprestimo cadastrado anteriomente\\.$")
	public void retornaraOSimularEmprestimoCadastradoAnteriomente() {
		super.validaSimularEmprestimoExistente();
	}


}
