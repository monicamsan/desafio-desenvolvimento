package br.com.cresol.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimulacaoEmprestimoDTO implements Serializable{
	
	private static final long serialVersionUID = -7085786783026536351L;
	private Long id;
	private String dataSimulacaoStr;
	private String dataValidadeSimulacaoStr;
	private BigDecimal valorParcela;
	private Long idCliente;
	private String numeroContrato;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	private BigDecimal taxaJurosParcela;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
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
	
	public LocalDateTime getDataSimulacao() {
		return LocalDate.parse(dataSimulacaoStr,DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
	}
	
	public LocalDateTime getDataValidadeSimulacao() {
		return LocalDate.parse(dataValidadeSimulacaoStr,DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
	}
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	

}
