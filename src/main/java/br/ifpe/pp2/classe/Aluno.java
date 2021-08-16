package br.ifpe.pp2.classe;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="O nome deve ser informado!")
	private String nome;
	@NotBlank(message="O email deve ser informado!")
	@Email
	private String email;
	@NotBlank(message="A senha deve ser informada!")
	private String senha;
	@CPF
	@NotBlank(message="O cpf deve ser informado!")
	@Max(11)
	@Column(length=11, nullable=false)
	private String cpf;
	@NotBlank(message="O endereco deve ser informado!")
	private Endereco endereco;
	@NotBlank(message="O telefone deve ser informado!")
	//@Size(min="", max="", message="")
	@Column(length=16)
	//(081)99999-9999
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{5})[- ]?(\\d{4})$")
	private String telefone;
	@NotNull(message="A data de nascimento deve ser informada!")
	@Past(message="A data não pode ser futura!")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	@Column(name = "is_ativo",columnDefinition = "integer default 0")
	private Integer isAtivo;
	@Column(name = "categoria_carteira",length=10)
	private String categoriaCarteira;
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
