package br.com.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.pp2.classe.Aluno;


public interface AlunoDAO 
extends JpaRepository<Aluno, Integer>  {

	public Aluno findByCpfAndSenha(String cpf, String senha);

}
