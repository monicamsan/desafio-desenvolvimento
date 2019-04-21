package br.com.cresol.desafio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cresol.desafio.exception.DesafioCresolException;
/**
 * @author Fernando Estrela
 *
 */
@Entity
@Table(name = "ESIMULAREMPRESTIMO")
public class SimularEmprestimo extends BaseEmpretimo implements Serializable{
	
	private static final long serialVersionUID = 4920976476876729634L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dataSimulacao;
	private LocalDateTime dataValidadeSimulacao;
	private BigDecimal valorParcela;
	private Long idCliente;
	
	public SimularEmprestimo() {}
	
	public SimularEmprestimo(Long idCliente,BigDecimal valorContrato, Integer quantidadeParcelas,Integer nuDiasValidadeSimulacao,Integer sequencialContrato) {
		super(valorContrato, quantidadeParcelas);
		this.idCliente = idCliente;
		this.inicializaSimulacaoImprestimo(nuDiasValidadeSimulacao, sequencialContrato);
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	
	public Long getId() {
		return id;
	}
	
	public LocalDateTime getDataSimulacao() {
		return dataSimulacao;
	}
	
	public LocalDateTime getDataValidadeSimulacao() {
		return dataValidadeSimulacao;
	}
	
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void inicializaSimulacaoImprestimo(Integer nuDiasValidadeSimulacao, Integer sequencialContrato) {
		this.gerarValorParcela();
		this.dataSimulacao =LocalDateTime.now();
		this.dataValidadeSimulacao = LocalDateTime.now().plusDays(nuDiasValidadeSimulacao);
		super.geraNumeroContrato(sequencialContrato);
	} 
	
	public void gerarValorParcela() {
		try {
			BigDecimal qtParcelas = new BigDecimal(super.getQuantidadeParcelas().toString());
			BigDecimal taxaJurosTotal = qtParcelas.multiply(super.getTaxaJurosParcela()).setScale(2,BigDecimal.ROUND_HALF_UP);
			BigDecimal vlTaxaJuros = super.getValorContrato().multiply(taxaJurosTotal).divide(new BigDecimal("100"));
			this.valorParcela = super.getValorContrato().add(vlTaxaJuros).divide(qtParcelas,BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP);
		}catch (Exception e) {
			throw new DesafioCresolException(e, "Erro ao calcular valor da parcela.");
		}
	}
	
	public void validaSimulacaoValida(Integer nuDias) {
		LocalDateTime.now().minusDays(nuDias);
		if(LocalDateTime.now().minusDays(nuDias).isAfter(getDataValidadeSimulacao())) throw new DesafioCresolException("Simulação de emprestimo está fora do período de validadae.");
	}
	
	
}
