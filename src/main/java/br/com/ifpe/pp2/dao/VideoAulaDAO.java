package br.com.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.pp2.classe.VideoAula;

public interface VideoAulaDAO 
	extends JpaRepository<VideoAula, Integer> {

}
