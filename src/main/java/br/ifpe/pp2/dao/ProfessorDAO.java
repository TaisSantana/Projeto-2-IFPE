package br.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.classe.Professor;

public interface ProfessorDAO
extends JpaRepository<Professor, Integer> {

	
}
