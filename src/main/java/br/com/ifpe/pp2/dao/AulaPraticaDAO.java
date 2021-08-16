package br.com.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.pp2.classe.AulaPratica;

public interface AulaPraticaDAO 
extends JpaRepository<AulaPratica, Integer>  {

}
