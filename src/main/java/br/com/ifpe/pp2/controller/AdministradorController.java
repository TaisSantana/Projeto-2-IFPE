package br.com.ifpe.pp2.controller;

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
import br.com.ifpe.pp2.dao.AdministradorDAO;
import br.com.ifpe.pp2.dao.AlunoDAO;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorDAO administradorDAO;

	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/formCadastrarAdm")
	public String formCadastrarAdmin(Administrador admin, Model model) {
		return "cadastrar-admin";
	}
	
	@PostMapping("/salvarAdm")
	public String salvarAdm(@Valid Administrador admin,BindingResult result, Model model) {
		System.out.println("ADMIIIIIIIIN SALVAAAAAR");
		if (result.hasErrors()) {
			return formCadastrarAdmin(admin, model);
		}
		this.administradorDAO.save(admin);
		return "redirect:/";
	}
		
	
	@GetMapping("/editarAdm")
	public String editarAdm(Integer id, Model model) {
		model.addAttribute("adm", this.administradorDAO.findById(id));
		return "associados/cadastro-associado";
	}

	@GetMapping("/removerAdm")
	public String removerAdm(Integer id, RedirectAttributes ra) {
		this.administradorDAO.deleteById(id);	
		return "/";
	}
}
