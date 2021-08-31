package br.com.ifpe.pp2.controller;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifpe.pp2.classe.Aluno;
import br.com.ifpe.pp2.classe.AulaPratica;
import br.com.ifpe.pp2.dao.ProfessorDAO;
import br.com.ifpe.pp2.dao.AlunoDAO;

//alteta tds rotas da classe, antes tem q ter /aulaPratica
@Controller
@RequestMapping("/aulaPratica")
public class AulaPraticaController {
	@Autowired
	private ProfessorDAO professorDAO;
	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/agendarAula")
	private String agendarAulaP(Integer codigo, AulaPratica aula,Model model, @RequestParam(value="perfil",defaultValue="3") String perfil) {
		//identifica pelo query paramn se é adm =1, prof=2 ou aluno =3, p gerenciar o front.
		model.addAttribute("perfil", perfil);
		model.addAttribute("listaProf", professorDAO.findAll(Sort.by("nome")));
		model.addAttribute("listaAluno", alunoDAO.findAll(Sort.by("nome")));
		if (perfil =="2") {
			model.addAttribute("usu", this.professorDAO.findById(codigo));
		}else if(perfil =="3") {
			model.addAttribute("usu", this.alunoDAO.findById(codigo));
		}
		return "agendamentoAulaPratica";
	}

	@GetMapping("/agendarAulaTeorica")
	private String agendarAulaT() {
		return "agendamentoAulaTeorica";
	}
	
	@PostMapping("/cadastroAulaPratica")
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
