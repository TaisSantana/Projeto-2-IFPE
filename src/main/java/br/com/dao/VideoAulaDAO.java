package br.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.classes.VideoAula;

public interface VideoAulaDAO extends JpaRepository<VideoAula, Integer> {

}
