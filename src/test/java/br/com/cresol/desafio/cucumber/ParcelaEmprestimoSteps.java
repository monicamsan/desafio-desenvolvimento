package br.com.cresol.desafio.cucumber;

import java.util.List;

import br.com.cresol.desafio.dto.ClienteDTO;
import br.com.cresol.desafio.dto.ContratarEmprestimoDTO;
import br.com.cresol.desafio.dto.ParcelaEmprestimoDTO;
import br.com.cresol.desafio.dto.SimulacaoEmprestimoDTO;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
/**
 * @author Fernando Estrela
 *
 */
public class ParcelaEmprestimoSteps extends SpringStep{
	
	@Dado("^que tenha um cliente com seguintes dados ParcelaEmprestimo\\.$")
	public void queTenhaUmClienteComSeguintesDadosParcelaEmprestimo(List<ClienteDTO> clientes)  {
		super.saveClientes(clientes);
		super.findCliente(1L);
		super.validaClienteExistente();
	}

	@Dado("^que tenha simulacao com seguintes dados ParcelaEmprestimo$")
	public void queTenhaSimulacaoComSeguintesDadosParcelaEmprestimo(List<SimulacaoEmprestimoDTO> simulacaoEmprestimoDTOs)  {
		super.saveSimularEmprestimo(simulacaoEmprestimoDTOs);
		super.findSimularEmprestimo(3L);
		super.validaSimularEmprestimoExistente();
	}

	@Dado("^que tenha contrato emprestimo com seguintes dados ParcelaEmprestimo$")
	public void queTenhaContratoEmprestimoComSeguintesDadosParcelaEmprestimo(List<ContratarEmprestimoDTO> contratarEmprestimoDTOs)  {
		super.saveContratarEmprestimo(contratarEmprestimoDTOs);
		super.findContratarEmprestimo(4L);
		super.validaContratarEmprestimo();
	}

	@Dado("^que tenha Parcela Emprestimo com seguintes dados$")
	public void queTenhaParcelaEmprestimoComSeguintesDados(List<ParcelaEmprestimoDTO> parcelaEmprestimoDTOs)  {
	    super.saveParcelaEmprestimo(parcelaEmprestimoDTOs);
	}
	
	@Quando("^quando consultar a ParcelaEmprestimo com id (\\d+)\\.$")
	public void quandoConsultarAParcelaEmprestimoComId(int arg1)  {
		super.findParcelaEmprestimo(Long.valueOf(arg1));
	}

	@Entao("^retornará a ParcelaEmprestimo cadastrado anteriomente\\.$")
	public void retornaraAParcelaEmprestimoCadastradoAnteriomente()  {
		super.validaParcelaEmprestimo();
	}

}
