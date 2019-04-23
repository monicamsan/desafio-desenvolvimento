package br.com.cresol.desafio.unitario;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.cresol.desafio.entity.BaseEmpretimo;

public class TaxaJurosTest {
	
	private static final BigDecimal NU_VALOR_CONTRATO_TX_MENOR = BigDecimal.valueOf(1000);
	private static final BigDecimal NU_VALOR_CONTRATO_TX_MAIOR = BigDecimal.valueOf(2000);
	private static final BigDecimal TX_MENOR = BigDecimal.valueOf(1.8);
	private static final BigDecimal TX_MAIOR = BigDecimal.valueOf(3.0);
	private static final BigDecimal TX_MAIOR_QTDE_PARCELA_MAIOR = BigDecimal.valueOf(2.3);
	
	@Test
	public void validaTaxaJuros() {
		BaseEmpretimo baseEmpretimo = new BaseEmpretimo(NU_VALOR_CONTRATO_TX_MAIOR, 10);
		Assert.assertTrue(baseEmpretimo.getTaxaJurosParcela().compareTo(TX_MAIOR) == 0);
		baseEmpretimo = new BaseEmpretimo(NU_VALOR_CONTRATO_TX_MENOR, 10);
		Assert.assertTrue(baseEmpretimo.getTaxaJurosParcela().compareTo(TX_MENOR) == 0);
		baseEmpretimo = new BaseEmpretimo(NU_VALOR_CONTRATO_TX_MENOR, 13);
		Assert.assertTrue(baseEmpretimo.getTaxaJurosParcela().compareTo(TX_MAIOR_QTDE_PARCELA_MAIOR) == 0);
	}

}
