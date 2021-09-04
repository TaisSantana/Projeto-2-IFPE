package br.com.ifpe.pp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.pp2.classe.Administrador;
import br.com.ifpe.pp2.classe.Aluno;

public interface AdministradorDAO 
	extends JpaRepository<Administrador, Integer>{
	
	public Administrador findByCpfAndSenha(String cpf, String senha);
}
