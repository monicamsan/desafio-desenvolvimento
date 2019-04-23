package br.com.cresol.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cresol.desafio.entity.Cliente;
import br.com.cresol.desafio.exception.DesafioCresolException;
import br.com.cresol.desafio.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public Cliente findById(Long id) throws DesafioCresolException {
		return this.clienteRepository.findById(id).orElseThrow(()-> new DesafioCresolException());
	}

	public Optional<Cliente> findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();	
	}

}
