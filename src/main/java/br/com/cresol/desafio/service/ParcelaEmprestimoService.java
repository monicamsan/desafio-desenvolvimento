package br.com.cresol.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cresol.desafio.entity.ParcelaEmprestimo;
import br.com.cresol.desafio.exception.DesafioCresolException;
import br.com.cresol.desafio.repository.ParcelaEmprestimoRepository;

@Service
public class ParcelaEmprestimoService {
	
	@Autowired
	private ParcelaEmprestimoRepository parcelaEmprestimoRepository;

	public ParcelaEmprestimo save(ParcelaEmprestimo parcelaEmprestimo) {
		return this.parcelaEmprestimoRepository.save(parcelaEmprestimo);
	}

	public ParcelaEmprestimo findById(Long id) {
		return this.parcelaEmprestimoRepository.findById(id).orElseThrow(()-> new DesafioCresolException());
	}

	public Iterable<ParcelaEmprestimo> saveAll(List<ParcelaEmprestimo> parcelaEmprestimos) {
		return this.parcelaEmprestimoRepository.saveAll(parcelaEmprestimos);	
	}

}
