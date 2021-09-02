package br.com.ifpe.pp2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.pp2.classe.Aluno;
import br.com.ifpe.pp2.classe.AulaPratica;

public interface AulaPraticaDAO 
	extends JpaRepository<AulaPratica, Integer>  {
	
	public AulaPratica findByAluno(Optional<Aluno> optional);
}
