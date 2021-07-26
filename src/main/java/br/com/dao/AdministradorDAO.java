package br.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.classes.Administrador;

public interface AdministradorDAO extends JpaRepository<Administrador, Integer>{
	
}
