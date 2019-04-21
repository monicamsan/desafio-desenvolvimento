package br.com.cresol.desafio.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Fernando Estrela
 *
 */
@Entity
@Table(name = "ECLIENTE")
public class Cliente implements Serializable{
	
	
	private static final long serialVersionUID = -8102087194987746162L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private String cpf;
	private String nome;
	private String email;
	
	public Cliente() {}

	public Cliente(String cpf, String nome, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
