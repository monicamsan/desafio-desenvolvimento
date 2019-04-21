package br.com.cresol.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class SimulacaoEmprestimoResponse implements Serializable{
	
	private static final long serialVersionUID = 3961790993098773849L;
	
	private Long id;
	private BigDecimal valorParcela;
	private String numeroContrato;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	private BigDecimal taxaJurosParcela;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime dataSimulacao;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime dataValidadeSimulacao;
	
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
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
		return dataSimulacao;
	}
	public void setDataSimulacao(LocalDateTime dataSimulacao) {
		this.dataSimulacao = dataSimulacao;
	}
	public LocalDateTime getDataValidadeSimulacao() {
		return dataValidadeSimulacao;
	}
	public void setDataValidadeSimulacao(LocalDateTime dataValidadeSimulacao) {
		this.dataValidadeSimulacao = dataValidadeSimulacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
