package br.com.cresol.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContratarEmprestimoDTO implements Serializable{

	
	private static final long serialVersionUID = -3058044340593287667L;
	private Long id;
	private String dataContratacaoStr;
	private BigDecimal iofContrato;
	private Long idSimularEmprestimo;
	private Integer numeroContrato;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	private BigDecimal taxaJurosParcela;
	
	public LocalDateTime getDataContratacao() {
		return  LocalDate.parse(dataContratacaoStr,DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDataContratacaoStr() {
		return dataContratacaoStr;
	}
	public void setDataContratacaoStr(String dataContratacaoStr) {
		this.dataContratacaoStr = dataContratacaoStr;
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
	public Integer getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public BigDecimal getValorContrato() {
		return valorContrato;
	}
	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public BigDecimal getTaxaJurosParcela() {
		return taxaJurosParcela;
	}
	public void setTaxaJurosParcela(BigDecimal taxaJurosParcela) {
		this.taxaJurosParcela = taxaJurosParcela;
	}
	
	
}
