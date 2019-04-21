package br.com.cresol.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Email;

/**
 * @author Fernando Estrela
 *
 */
public class SimularEmprestimoPayload implements Serializable{
	
	private static final long serialVersionUID = 1696708020399704962L;
	private String nome;
	private String cpf;
	@Email(message="E-mail Invalido.")
	private String email;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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


}
