package br.com.ifpe.pp2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifpe.pp2.classe.Aluno;
import br.com.ifpe.pp2.dao.AlunoDAO;

@Controller
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/")
	private String exibirPgPrincipal() {
		return "index";
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Aluno aluno, RedirectAttributes ra, HttpSession session) {
		aluno = this.alunoDAO.findByCpfAndSenha(aluno.getCpf(), aluno.getSenha());
		System.out.println(aluno.getCpf());
		if (aluno != null) {
			session.setAttribute("usuarioLogado", aluno);
			return "redirect:/alunoPage";
		} else {
			ra.addFlashAttribute("mensagemErro", "Usuário/senha inválidos");
			return "redirect:/";
		}	
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
