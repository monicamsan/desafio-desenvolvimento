package br.com.cresol.desafio.cucumber;

import java.util.List;

import br.com.cresol.desafio.dto.ClienteDTO;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ClienteSteps extends SpringStep{
	


	@Dado("^que um cliente con seguintes dados\\.$")
	public void queUmClienteConSeguintesDados(List<ClienteDTO> clientes)  {
		super.saveClientes(clientes);		
	}

	@Quando("^quando consultar o cliente com id (\\d+)\\.$")
	public void quandoConsultarOClienteComId(int arg1) {
		super.findCliente(Long.valueOf(arg1));
	}

	@Entao("^retornará o cliente cadastrado anteriomente\\.$")
	public void retornaraOClienteCadastradoAnteriomente()  {
		super.validaClienteExistente();
	}
}
