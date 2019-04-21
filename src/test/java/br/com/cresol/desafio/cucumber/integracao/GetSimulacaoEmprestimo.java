package br.com.cresol.desafio.cucumber.integracao;

import java.util.List;

import org.junit.Assert;

import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class GetSimulacaoEmprestimo extends IntegracaoRest{
	
	@Dado("^que tenha os seguintes dados para simulacao de Emprrestimo para get\\.$")
	public void queTenhaOsSeguintesDadosParaSimulacaoDeEmprrestimoParaGet(List<SimularEmprestimoPayload> payloads) throws Throwable {
		super.payload = payloads.get(0);
		super.response = super.simularEmprestimo(payload);
	}

	@Quando("^chamar o seviço de busca por id de simulação de emprestimo$")
	public void chamarOSevicoDeBuscaPorIdDeSimulacaoDeEmprestimo() throws Throwable {
		super.response = super.getSimulacaoEmprestimo(response.getId());
	}

	@Entao("^a simulação deve ser retornada$")
	public void aSimulacaoDeveSerRetornada() throws Throwable {
	   Assert.assertNotNull(response);
	}

}
