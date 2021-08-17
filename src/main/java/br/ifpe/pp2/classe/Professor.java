package br.ifpe.pp2.classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 80, nullable = false)
	private String nome;
	@Column(length = 80, nullable = false)
	private String email;
	@Column(length = 30, nullable = false)
	private String senha;
	@Column(name = "categoria_aula",length=10, nullable = false)
	private String categoriaAula;
	@Column(length=11, nullable=false)
	private String cpf;
	private Endereco endereco;
	@Column(length=10)
	private String telefone;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCategoriaAula() {
		return categoriaAula;
	}
	public void setCategoriaAula(String categoriaAula) {
		this.categoriaAula = categoriaAula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
