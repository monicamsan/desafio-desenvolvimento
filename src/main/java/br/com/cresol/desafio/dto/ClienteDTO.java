package br.com.cresol.desafio.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 13256462427105688L;
	
	private Long id;
	private Integer cpf;
	private String nome;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
