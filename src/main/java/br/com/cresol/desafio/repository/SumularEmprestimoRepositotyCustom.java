package br.com.cresol.desafio.repository;

import org.springframework.data.jpa.repository.Query;

public interface SumularEmprestimoRepositotyCustom {
	
	@Query(value="SELECT MAX(numeroContrato) FROM ESIMULAREMPRESTIMO ",nativeQuery=true)
	String findMaxNuContrato();
}
