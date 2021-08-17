package br.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.classe.AulaPratica;

public interface AulaPraticaDAO 
	extends JpaRepository<AulaPratica, Integer>  {

}
