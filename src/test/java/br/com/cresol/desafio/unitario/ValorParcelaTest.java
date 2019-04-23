package br.com.cresol.desafio.unitario;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.cresol.desafio.entity.SimularEmprestimo;

public class ValorParcelaTest {
	
	private static final BigDecimal VL_12_PARCELAS =new BigDecimal("6301.41");
	private static final BigDecimal VL_24_PARCELAS =new BigDecimal("4262.72");
	
	
	@Test
	public void validaValorParcela12() {	
		this.validaValorParcelaa(12, VL_12_PARCELAS);		
	}
	
	@Test
	public void validaValorParcela24() {	
		this.validaValorParcelaa(24, VL_24_PARCELAS);		
	}
	
	private void validaValorParcelaa(Integer qtdeParcela ,BigDecimal vlParcela) {
		SimularEmprestimo simularEmprestimo =  new SimularEmprestimo(null, new BigDecimal("55600.66"), qtdeParcela, 1, 1);
		Assert.assertTrue(vlParcela.compareTo(simularEmprestimo.getValorParcela()) == 0);	
	}
}
