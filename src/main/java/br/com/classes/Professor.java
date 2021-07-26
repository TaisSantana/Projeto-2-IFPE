package br.com.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String email;
	private String senha;
	@Column(name = "categoria_aula",length=10)
	private String categoriaAula;
	@Column(length=11, nullable=false)
	private String cpf;
	private Endereco endereco;
	@Column(length=10)
	private String telefone;
	private Integer perfil;
}
