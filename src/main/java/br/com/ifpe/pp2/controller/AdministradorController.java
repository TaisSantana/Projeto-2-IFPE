package br.com.ifpe.pp2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.pp2.classe.Administrador;
import br.com.ifpe.pp2.dao.AdministradorDAO;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorDAO adminDAO;

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
		this.adminDAO.save(admin);
		return "redirect:/";
	}
}
