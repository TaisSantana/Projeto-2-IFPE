package br.ifpe.pp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.pp2.classe.Aluno;
import br.ifpe.pp2.dao.AlunoDAO;

@Controller
public class AlunoController {
	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/")
	private String exibirPgPrincipal() {
		return "index";
	}
	
	@GetMapping("/pre")
	private String exibirPreMatricula() {
		return "prematricula";
	}
	
	@GetMapping("/login")
	private String exibirLogin() {
		return "login";
	}
	
	@GetMapping("/sobre")
	private String exibirSobre() {
		return "sobre";
	}

	@PostMapping("/precadastroAluno")
	private String precadastroAluno(Aluno aluno) {
		aluno.setPerfil(3);
		aluno.setIsAtivo(0);
		this.alunoDAO.save(aluno);
		return "index";
	}
}
