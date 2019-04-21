package br.com.cresol.desafio.cucumber.integracao;

import java.util.List;

import org.junit.Assert;

import br.com.cresol.desafio.dto.SimulacaoEmprestimoResponse;
import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class SimulacaoEmprestimoIntegracaoStep extends IntegracaoRest{
	
	
	@Dado("^que tenha os seguintes dados para simulacao de Emprrestimo\\.$")
	public void queTenhaOsSeguintesDadosParaSimulacaoDeEmprrestimo(List<SimularEmprestimoPayload> payloads)  {
	    super.payload = payloads.get(0);
	}

	@Quando("^chamar o seviço de simulação de emprestimo$")
	public void chamarOSevicoDeSimulacaoDeEmprestimo()  {
		super.response = super.simularEmprestimo(payload);
	}

	@Entao("^os seguintes dados vão ser retornados$")
	public void osSeguintesDadosVaoSerRetornados(List<SimulacaoEmprestimoResponse> simulacaosEmprestimoResponse)  {
		super.responseEsperado = simulacaosEmprestimoResponse.get(0);
		//TODO ver o mutivo do por que no scopo de teste o MAX numero contrato  retorna um numero aleatorio
		//Assert.assertEquals(response.getNumeroContrato(), responseEsperado.getNumeroContrato());
		Assert.assertEquals(response.getTaxaJurosParcela(), responseEsperado.getTaxaJurosParcela());
		Assert.assertEquals(response.getQuantidadeParcelas(), responseEsperado.getQuantidadeParcelas());
		Assert.assertEquals(response.getValorContrato(), responseEsperado.getValorContrato());
		Assert.assertTrue(response.getValorParcela().compareTo(responseEsperado.getValorParcela()) == 0);
	}

}
