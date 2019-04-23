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
/**
 * @author Fernando Estrela
 *
 */
@Entity
@Table(name = "EPARCELAEMPRESTIMO")
public class ParcelaEmprestimo implements Serializable{
	
	
	private static final long serialVersionUID = -772478141900045239L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private Integer numeroDaParcela;
	private LocalDateTime dataVencimento;
	private BigDecimal valorParcela;
	private Long idContratarEmprestimo;
	
	public ParcelaEmprestimo() {}
	
	public ParcelaEmprestimo(Integer numeroDaParcela, LocalDateTime dataVencimento, BigDecimal valorParcela,
			Long idContratarEmprestimo) {
		super();
		this.numeroDaParcela = numeroDaParcela;
		this.dataVencimento = dataVencimento;
		this.valorParcela = valorParcela;
		this.idContratarEmprestimo = idContratarEmprestimo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idContratarEmprestimo", insertable = false, updatable = false)
	private ContratarEmprestimo contratarEmprestimo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroDaParcela() {
		return numeroDaParcela;
	}

	public void setNumeroDaParcela(Integer numeroDaParcela) {
		this.numeroDaParcela = numeroDaParcela;
	}

	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Long getIdContratarEmprestimo() {
		return idContratarEmprestimo;
	}

	public void setIdContratarEmprestimo(Long idContratarEmprestimo) {
		this.idContratarEmprestimo = idContratarEmprestimo;
	}

	public ContratarEmprestimo getContratarEmprestimo() {
		return contratarEmprestimo;
	}

	public void setContratarEmprestimo(ContratarEmprestimo contratarEmprestimo) {
		this.contratarEmprestimo = contratarEmprestimo;
	}
	
	
	
	

}
