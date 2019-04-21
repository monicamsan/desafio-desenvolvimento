package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.entity.ParcelaEmprestimo;

@Repository
public interface ParcelaEmprestimoRepository extends CrudRepository<ParcelaEmprestimo, Long>{

}
