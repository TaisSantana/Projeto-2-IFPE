package br.com.ifpe.pp2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifpe.pp2.classe.Aluno;
import br.com.ifpe.pp2.dao.AlunoDAO;

@Controller
public class AlunoController {
	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/paginaInicial")
	private String exibirPgPrincipal() {
		return "index";
	}
	
	@GetMapping("/pre")
	private String exibirPreMatricula(Aluno aluno) {
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

	@GetMapping("/alunoPage")
	private String exibirPageAluno() {
		return "alunoPage";
	}
	
	
	@PostMapping("/precadastroAluno")
	private String precadastroAluno(@Valid Aluno aluno, BindingResult result, Model model, RedirectAttributes ra) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "prematricula";
		}
	    if(aluno == null) {         // check if user object is empty
	    	aluno = new Aluno();    // if user is empty, then instantiate a new user object
	    	model.addAttribute("aluno", aluno);
	    }
		try {
			//transf em service
			aluno.setIsAtivo(0);
			this.alunoDAO.save(aluno);
			// fim transf em service, Controller agr n pode mais ter acesso direto ao DAO.
			
			ra.addFlashAttribute("mensagem","Aluno Cadastrado com Sucesso!");
			return "redirect:/login";
		}catch (ServiceException e){
			result.addError(new ObjectError("global",e.getMessage()));
			e.printStackTrace();
			return "index";
		}
	}
	
	}
