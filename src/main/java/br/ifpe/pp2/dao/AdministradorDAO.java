package br.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.classe.Administrador;

public interface AdministradorDAO 
	extends JpaRepository<Administrador, Integer>{
	
}
