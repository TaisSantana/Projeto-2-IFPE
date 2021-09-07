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
import br.com.ifpe.pp2.classe.Aluno;
import br.com.ifpe.pp2.dao.AdministradorDAO;
import br.com.ifpe.pp2.dao.AlunoDAO;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorDAO administradorDAO;

	
	@GetMapping("/admPage")
	private String exibirPageAdministrador(HttpSession session,Model model) {
		Administrador admin =(Administrador)session.getAttribute("usuarioLogado");
		model.addAttribute("admin", admin);
		return "administador/admPage";
	}
	
	@PostMapping("/efetuarLoginAdm")
	public String efetuarLogin(Administrador admin, RedirectAttributes ra, HttpSession session) {
		admin = this.administradorDAO.findByCpfAndSenha(admin.getCpf(), admin.getSenha());
		System.out.println("---------------------------------");
		if (admin != null) {
			session.setAttribute("usuarioLogado", admin);
			return "redirect:/admPage";
		}else {
			ra.addFlashAttribute("mensagemErro", "Usuário/senha inválidos");
			return "redirect:/login";
		}	
		//return "redirect:/";
	}
	
	@GetMapping("/exibirFormCadastrarAdm")
	public String formCadastrarAdmin(Administrador admin, Model model) {
		model.addAttribute("admin", admin);
		return "administrador/cadastrar-admin";
	}
	
	@PostMapping("/salvarAdm")
	public String salvarAdm(@Valid Administrador admin,BindingResult result, Model model) {
		System.out.println("ADMIIIIIIIIN SALVAAAAAR");
		if (result.hasErrors()) {
			return formCadastrarAdmin(admin, model);
		}
		this.administradorDAO.save(admin);
		return "redirect:/login";
	}
		
	@GetMapping("/listarAdmin")
	public String exibirLista(Model model) {
		model.addAttribute("listaAdmin", administradorDAO.findAll());
		return "administrador/admin-list";
	}
	
	@GetMapping("/editarAdmin")
	public String editarAdm(Integer id, Model model) {
		model.addAttribute("adm", this.administradorDAO.findById(id));
		return "/";
	}

	@GetMapping("/removerAdmin")
	public String removerAdm(Integer id, RedirectAttributes ra) {
		this.administradorDAO.deleteById(id);	
		return "/";
	}
}
