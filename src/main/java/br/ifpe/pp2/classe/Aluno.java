package br.ifpe.pp2.classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	@Column(name = "is_ativo",columnDefinition = "integer default 0")
	private Integer isAtivo;
	@Column(name = "categoria_carteira",length=10)
	private String categoriaCarteira;
	@Column(length=11, nullable=false)
	private String cpf;
	private Endereco endereco;
	@Column(length=10)
	private String telefone;
	private Integer perfil;
	
	
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
	public Integer getIsAtivo() {
		return isAtivo;
	}
	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}
	public String getCategoriaCarteira() {
		return categoriaCarteira;
	}
	public void setCategoriaCarteira(String categoriaCarteira) {
		this.categoriaCarteira = categoriaCarteira;
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
	public Integer getPerfil() {
		return perfil;
	}
	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
	
	
	
}
