package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.entity.ContratarEmprestimo;

@Repository
public interface ContratarEmprestimoRepository extends CrudRepository<ContratarEmprestimo, Long>{

}
