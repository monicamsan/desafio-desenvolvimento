package br.com.cresol.desafio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.entity.SimularEmprestimo;

@Repository
public interface SimularEmprestimoRepository extends CrudRepository<SimularEmprestimo, Long>,SumularEmprestimoRepositotyCustom{


	Optional<SimularEmprestimo> findByNumeroContrato(String numeroContrato);
	
	
}
