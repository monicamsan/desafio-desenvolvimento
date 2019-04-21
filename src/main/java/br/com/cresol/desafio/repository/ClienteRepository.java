package br.com.cresol.desafio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(String cpf);

}
