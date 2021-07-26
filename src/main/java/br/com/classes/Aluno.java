package br.com.classes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;


public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
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
	
	
}
