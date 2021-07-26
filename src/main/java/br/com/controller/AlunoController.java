package br.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.classes.Aluno;
import br.com.dao.AlunoDAO;

@Controller
public class AlunoController {
	private List<Aluno> lista = new ArrayList<Aluno>();
	
	@GetMapping("/")
	public String pagInicial() {
		return "index";
	}
	
	@GetMapping("/login")
	public String exibirPagLogin() {
		return "login";
	}
	
	@GetMapping("/prematricula")
	public String exibirPagCadastroAluno() {
		return "prematricula";
	}
	
	@GetMapping("/login")
	public String exibirOpcoesLogin() {
		return "login";
	}
	
	@GetMapping("/videoAula")
	public String exibirVideoAulas() {
		return "videoAulas";
	}
	
	@GetMapping("/agendamento")
	public String agendamento() {
		return "agendamento";
	}
	
}
