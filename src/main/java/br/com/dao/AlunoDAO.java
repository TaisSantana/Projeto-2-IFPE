package br.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.classes.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Integer>  {
	
}
