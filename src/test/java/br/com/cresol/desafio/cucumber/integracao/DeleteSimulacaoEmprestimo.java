package br.com.cresol.desafio.cucumber.integracao;

import org.junit.Assert;

import java.util.List;

import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import br.com.cresol.desafio.exception.DesafioCresolException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class DeleteSimulacaoEmprestimo extends IntegracaoRest{
	
	@Dado("^que tenha os seguintes dados para simulacao de Emprrestimo para delete\\.$")
	public void queTenhaOsSeguintesDadosParaSimulacaoDeEmprrestimoParaDelete(List<SimularEmprestimoPayload> payloads) throws Throwable {
		super.payload = payloads.get(0);
		super.response = super.simularEmprestimo(payload);
	}

	@Quando("^chamar o seviço de delete de simulação de emprestimo$")
	public void chamarOSevicoDeDeleteDeSimulacaoDeEmprestimo() throws Throwable {
	   super.deletarSimulacaoEmprestimo(response.getId());
	}

	@Entao("^o mesmo deve ser deletado$")
	public void oMesmoDeveSerDeletado() throws Throwable {
		try {
			super.findSimularEmprestimo(response.getId());
			Assert.fail("Simulação de emprestimo não Existe");
		}catch (DesafioCresolException e) {	
		}
	}

}
