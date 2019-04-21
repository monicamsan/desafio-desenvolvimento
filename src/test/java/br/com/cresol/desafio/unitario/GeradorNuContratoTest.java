package br.com.cresol.desafio.unitario;

import org.junit.Assert;
import org.junit.Test;

import br.com.cresol.desafio.entity.BaseEmpretimo;

public class GeradorNuContratoTest {
	private static final String[]  CONTRATOS_ESPERADOS = new String[] {"AAAAMMDD000001","AAAAMMDD000002","AAAAMMDD000010","AAAAMMDD000100"};
	
	@Test
	public void validaNuContrato() {
		BaseEmpretimo baseEmpretimo = new BaseEmpretimo();
		baseEmpretimo.geraNumeroContrato(1);
		Assert.assertEquals(CONTRATOS_ESPERADOS[0], baseEmpretimo.getNumeroContrato());
		baseEmpretimo.geraNumeroContrato(2);
		Assert.assertEquals(CONTRATOS_ESPERADOS[1], baseEmpretimo.getNumeroContrato());
		baseEmpretimo.geraNumeroContrato(10);
		Assert.assertEquals(CONTRATOS_ESPERADOS[2], baseEmpretimo.getNumeroContrato());
		baseEmpretimo.geraNumeroContrato(100);
		Assert.assertEquals(CONTRATOS_ESPERADOS[3], baseEmpretimo.getNumeroContrato());

	}
}
