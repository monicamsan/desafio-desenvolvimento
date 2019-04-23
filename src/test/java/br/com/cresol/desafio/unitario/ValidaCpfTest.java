package br.com.cresol.desafio.unitario;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import br.com.cresol.desafio.util.DesafioCresolUtils;

public class ValidaCpfTest {
	
	private static final String CPF_VALIDOS = "80900534087,64951629011,51206352027";
	private static final String CPF_INVALIDOS = "00000000000,11111111111,12345678998";
	@Test
	public void testEmailValido() {
		  Arrays.stream(CPF_VALIDOS.split(",")).collect(Collectors.toList()).stream().forEach(cpf -> Assert.assertTrue(DesafioCresolUtils.isValidCPF(cpf)));	
	}
	
	@Test
	public void testEmailInvalido() {
		  Arrays.stream(CPF_INVALIDOS.split(",")).collect(Collectors.toList()).stream().forEach (cpf -> Assert.assertTrue(!DesafioCresolUtils.isValidCPF(cpf)));
	}

}
