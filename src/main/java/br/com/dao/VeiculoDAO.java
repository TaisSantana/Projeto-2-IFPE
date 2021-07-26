package br.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.classes.Veiculo;

public interface VeiculoDAO extends JpaRepository<Veiculo, Integer> {

}
