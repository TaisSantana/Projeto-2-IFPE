package br.com.ifpe.pp2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifpe.pp2.classe.Administrador;
import br.com.ifpe.pp2.classe.Professor;
import br.com.ifpe.pp2.dao.ProfessorDAO;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorDAO professorDAO;
	
	
	@PostMapping("/efetuarLoginProfessor")
	public String efetuarLogin(Professor professor, RedirectAttributes ra, HttpSession session) {
		professor = this.professorDAO.findByCpfAndSenha(professor.getCpf(), professor.getSenha());
		System.out.println("---------------------------------");
		if (professor != null) {
			session.setAttribute("usuarioLogado", professor);
			return "redirect:/admPage";
		}else {
			ra.addFlashAttribute("mensagemErro", "Usuário/senha inválidos");
			return "redirect:/login";
		}	
		//return "redirect:/";
	}
	
	@GetMapping("/listarProfessor")
	public String exibirLista(Model model) {
		model.addAttribute("listaProfessor", professorDAO.findAll());
		return "/";
	}
	
	@GetMapping("/exibirFormCadastrarProf")
	public String exibirFormCadastrarProfessor(Professor professor, Model model) {
		return "professor/cad-prof";
	}
	
	@PostMapping("/salvarProf")
	public String salvarProfessor(@Valid Professor professor, 			
			BindingResult result, Model model) {
		System.out.println("------------------");
		if (result.hasErrors()) {
			return exibirFormCadastrarProfessor(professor, model);
		}
		this.professorDAO.save(professor);
		return "redirect:/paginaInicial";
	}

	
	
	@GetMapping("/editarprofessor")
	public String editarprofessor(Integer id, Model model) {
		model.addAttribute("professor", this.professorDAO.findById(id));
		
		return "redirect:/listarProfessor";
	}

	@GetMapping("/removerprofessor")
	public String removerprofessor(Integer id, RedirectAttributes ra) {
		this.professorDAO.deleteById(id);	
		return "redirect:/listarProfessor";
	}
}
