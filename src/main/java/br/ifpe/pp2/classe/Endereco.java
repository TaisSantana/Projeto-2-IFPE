package br.ifpe.pp2.classe;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Endereco {
	@Enumerated(EnumType.STRING) //Guarda no banco enforma de String
	@Column(length = 5, nullable = false)// Varchar de 2 e deixa o campo obrigatorio
	private Estado estado;
	@Column(length = 30, nullable = false)// Varchar de 30 e deixa o campo obrigatorio
	private String complemento;
	@Column(length = 30, nullable = false)// Varchar de 30 e deixa o campo obrigatorio
	private String logradouro;
	@Column(length = 8, nullable = false)// Varchar de 8 e deixa o campo obrigatorio
	private String cep;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
