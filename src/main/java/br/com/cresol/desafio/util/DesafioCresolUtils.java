package br.com.cresol.desafio.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.cresol.desafio.exception.DesafioCresolException;

public final class DesafioCresolUtils {
	
	private DesafioCresolUtils() {};
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	  private static int calcularDigito(String str, int[] peso) {
	      int soma = 0;
	      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
	         digito = Integer.parseInt(str.substring(indice,indice+1));
	         soma += digito*peso[peso.length-str.length()+indice];
	      }
	      soma = 11 - soma % 11;
	      return soma > 9 ? 0 : soma;
	   }
	
	   public static boolean isValidCPF(String cpf) {

		      if ((cpf==null) || (cpf.length()!=11)) return false;
		      if(validaNumerosRepetidos(cpf))return false;

		      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
		      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
		      return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
	   }
	   
	   public static boolean isValidEmailAddress(String email) {
		    boolean result = true;
		    try {
		        InternetAddress emailAddr = new InternetAddress(email);
		        emailAddr.validate();
		    } catch (AddressException ex) {
		        result = false;
		    }
		    return result;
		}
	   
	   private static boolean validaNumerosRepetidos(String cpf) {
		   String regex = "(?!(\\d)\\1{10})\\d{11}";
	        Pattern pat = Pattern.compile (regex);
	        Matcher mat = pat.matcher (cpf);
	        return  !mat.matches();
	   }
	   
		public static Integer proximoSequencialContrato(String maxNuContrato) {
			if(maxNuContrato == null) return 1;		
			String regex = "(\\d{6})";
	        Pattern pat = Pattern.compile (regex);
	        Matcher mat = pat.matcher (maxNuContrato);
	        if(mat.find()) {
	        	return Integer.parseInt(mat.group().replace("0", ""))+1;
	        }
			throw new DesafioCresolException("Erro ao pegar proximo sequencial do contrato.");
		}

}
