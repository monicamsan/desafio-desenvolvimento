package br.com.cresol.desafio.service;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import br.com.cresol.desafio.entity.Cliente;
import br.com.cresol.desafio.entity.ContratarEmprestimo;
import br.com.cresol.desafio.entity.SimularEmprestimo;
import br.com.cresol.desafio.exception.DesafioCresolException;
import br.com.cresol.desafio.repository.SimularEmprestimoRepository;
import br.com.cresol.desafio.util.DesafioCresolUtils;

@Service
public class SimularEmprestimoService  {
	
	@Value("${numero.dias.validade.simulacao:30}")
	private Integer nuDiasValidadeSimulacao;
	@Value("${iof.contrato:0.38}")
	private String iofContrato;
	
	@Autowired
	private SimularEmprestimoRepository simularEmprestimoRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContratarEmprestimoService contratarEmprestimoService;


	
	public SimularEmprestimo save(SimularEmprestimo simularEmprestimo) {
		return this.simularEmprestimoRepository.save(simularEmprestimo);
	}

	public SimularEmprestimo findById(Long id) throws DesafioCresolException {
		return this.simularEmprestimoRepository.findById(id).orElseThrow(()-> new DesafioCresolException("Simulação de emprestimo não Existe"));
	}

	public SimularEmprestimo simularEmprestimo(SimularEmprestimoPayload payload) {
		this.validacoesDadosCliente(payload);
		Cliente cliente = clienteService.findByCpf(payload.getCpf()).isPresent() ? clienteService.findByCpf(payload.getCpf()).get() :clienteService.save(new Cliente(payload.getCpf(), payload.getNome(), payload.getEmail()));
		SimularEmprestimo simularEmprestimo = new SimularEmprestimo(cliente.getId(), payload.getValorContrato(), payload.getQuantidadeParcelas(),nuDiasValidadeSimulacao,this.proximoSequencialContrato());
		return this.save(simularEmprestimo);
	}
	
	public SimularEmprestimo efetivarEmprestimo(String numeroContrato) {
		SimularEmprestimo simularEmprestimo = this.simularEmprestimoRepository.findByNumeroContrato(numeroContrato).orElseThrow(()->  new DesafioCresolException("Simulação de emprestimo não Existe"));
		simularEmprestimo.validaSimulacaoValida(nuDiasValidadeSimulacao);
		ContratarEmprestimo contratarEmprestimo = new ContratarEmprestimo(new BigDecimal(iofContrato), simularEmprestimo.getId(), simularEmprestimo.getValorContrato(), simularEmprestimo.getQuantidadeParcelas(),numeroContrato);
		this.contratarEmprestimoService.save(contratarEmprestimo);
		return  this.save(simularEmprestimo);
	}
	
	public SimularEmprestimo findByContrato(String numeroContrato) {
		return this.simularEmprestimoRepository.findByNumeroContrato(numeroContrato).orElseThrow(()->  new DesafioCresolException("Simulação de emprestimo não Existe"));
	}

	private void validacoesDadosCliente(SimularEmprestimoPayload payload) {
		this.validaCpf(payload.getCpf());
		this.validaEmail(payload.getEmail());
	}
	
	private Integer proximoSequencialContrato() {
		return DesafioCresolUtils.proximoSequencialContrato(this.simularEmprestimoRepository.findMaxNuContrato());	
	}

	private void validaEmail(String email) {
		if(DesafioCresolUtils.isValidEmailAddress(email)) return;
		throw new DesafioCresolException("E-mail Invalido.");
	}

	private void validaCpf(String cpf) {
		if(DesafioCresolUtils.isValidCPF(cpf.toString()))return ; 
		throw new DesafioCresolException("Cpf Invalido.");
	}

	public void deleteById(Long id) {
		this.simularEmprestimoRepository.deleteById(id);
	}
	
	
	
	
}
