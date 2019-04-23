package br.com.cresol.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParcelaEmprestimoDTO implements Serializable{
	
	
	private static final long serialVersionUID = 6222754198001603559L;
	
	private Long id;
	private Integer numeroDaParcela;
	private String dataVencimentoStr;
	private BigDecimal valorParcela;
	private Long idContratarEmprestimo;
	
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
		 return LocalDate.parse(dataVencimentoStr,DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
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
	public String getDataVencimentoStr() {
		return dataVencimentoStr;
	}
	public void setDataVencimentoStr(String dataVencimentoStr) {
		this.dataVencimentoStr = dataVencimentoStr;
	}
	
	
	

}
