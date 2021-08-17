package br.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.classe.Aluno;


public interface AlunoDAO 
	extends JpaRepository<Aluno, Integer>  {
	
}
