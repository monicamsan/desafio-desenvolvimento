package br.com.cresol.desafio.unitario;

import org.junit.Assert;
import org.junit.Test;

import br.com.cresol.desafio.util.DesafioCresolUtils;

public class ValidaGeracaoNuContratoTest {
	
	@Test
	public void validaGeracaoNuContrato() {
		Assert.assertTrue(DesafioCresolUtils.proximoSequencialContrato("AAAAMMDD000001").equals(2));
	}

}
