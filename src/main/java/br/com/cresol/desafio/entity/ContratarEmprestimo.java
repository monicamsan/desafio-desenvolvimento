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
@Table(name = "ECONTRATAREMPRESTIMO")
public class ContratarEmprestimo extends BaseEmpretimo implements Serializable{

	private static final long serialVersionUID = -2403338249482855799L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dataContratacao;
	private BigDecimal iofContrato;
	private Long idSimularEmprestimo;
	
	public ContratarEmprestimo() {}
	
	public ContratarEmprestimo(BigDecimal iofContrato, Long idSimularEmprestimo,BigDecimal valorContrato, Integer quantidadeParcelas,String numeroContrato) {
		super(valorContrato, quantidadeParcelas,numeroContrato);
		this.iofContrato = iofContrato;
		this.idSimularEmprestimo = idSimularEmprestimo;
		this.setDataContratacao(LocalDateTime.now());
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSimularEmprestimo", insertable = false, updatable = false)
	private SimularEmprestimo simularEmprestimo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(LocalDateTime dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public BigDecimal getIofContrato() {
		return iofContrato;
	}
	public void setIofContrato(BigDecimal iofContrato) {
		this.iofContrato = iofContrato;
	}
	public Long getIdSimularEmprestimo() {
		return idSimularEmprestimo;
	}
	public void setIdSimularEmprestimo(Long idSimularEmprestimo) {
		this.idSimularEmprestimo = idSimularEmprestimo;
	}
	public SimularEmprestimo getSimularEmprestimo() {
		return simularEmprestimo;
	}
	public void setSimularEmprestimo(SimularEmprestimo simularEmprestimo) {
		this.simularEmprestimo = simularEmprestimo;
	}
	
	
}
