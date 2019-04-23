package br.com.cresol.desafio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.cresol.desafio.entity.ContratarEmprestimo;
import br.com.cresol.desafio.entity.ParcelaEmprestimo;
import br.com.cresol.desafio.entity.SimularEmprestimo;
import br.com.cresol.desafio.exception.DesafioCresolException;
import br.com.cresol.desafio.repository.ContratarEmprestimoRepository;
import br.com.cresol.desafio.repository.SimularEmprestimoRepository;

@Service
public class ContratarEmprestimoService  {
	
	@Autowired
	private ContratarEmprestimoRepository contratarEmprestimoRepository;
	@Autowired
	private ParcelaEmprestimoService parcelaEmprestimoService;
	@Autowired
	private SimularEmprestimoRepository simularEmprestimoRepository;
	@Value("${numero.dias.primeira.parcela:30}")
	private Integer nuDiasPrimeiraParcela;
	
	public ContratarEmprestimo save(ContratarEmprestimo contratarEmprestimo) {
		this.contratarEmprestimoRepository.save(contratarEmprestimo);
		SimularEmprestimo simularEmprestimo = this.simularEmprestimoRepository.findById(contratarEmprestimo.getIdSimularEmprestimo()).get();
		List<ParcelaEmprestimo> parcelaEmprestimos  = new ArrayList<>();
		LocalDateTime dtVencimento = contratarEmprestimo.getDataContratacao();
		for(int i = 0 ; i < contratarEmprestimo.getQuantidadeParcelas() ; i ++) {
			dtVencimento.plusDays(nuDiasPrimeiraParcela);
			parcelaEmprestimos.add(new ParcelaEmprestimo(i+1, dtVencimento,simularEmprestimo.getValorParcela(), contratarEmprestimo.getId()));
		}
		this.parcelaEmprestimoService.saveAll(parcelaEmprestimos);
		return contratarEmprestimo;			
	}

	public ContratarEmprestimo findById(Long id) {
		return this.contratarEmprestimoRepository.findById(id).orElseThrow(()-> new DesafioCresolException());
	}
	
	

}
