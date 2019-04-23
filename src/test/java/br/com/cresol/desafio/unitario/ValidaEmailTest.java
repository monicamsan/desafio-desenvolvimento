package br.com.cresol.desafio.unitario;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import br.com.cresol.desafio.util.DesafioCresolUtils;

public class ValidaEmailTest {
	
	private static final String EMAIL_VALIDOS = "fernando77@gmail.com,fernando77@hotmail.com,fernando77@yahoo.com";
	private static final String EMAIL_INVALIDOS = "fernando77@.com,fernado@gmail:lol,fernandogmail@";
	@Test
	public void testEmailValido() {
		Arrays.stream(EMAIL_VALIDOS.split(",")).collect(Collectors.toList()).stream().forEach(email -> Assert.assertTrue(DesafioCresolUtils.isValidEmailAddress(email)));	
	}
	
	@Test
	public void testEmailInvalido() {
		Arrays.stream(EMAIL_INVALIDOS.split(",")).collect(Collectors.toList()).stream().forEach(email -> Assert.assertTrue(!DesafioCresolUtils.isValidEmailAddress(email)));	
	}

}
