package br.ifpe.pp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoController {
	
	@GetMapping("/")
	private String exibirPgPrincipal() {
		return "index";
	}
	
	@GetMapping("/pre")
	private String exibirPreMatricula() {
		return "page3";
	}
	
	@GetMapping("/login")
	private String exibirLogin() {
		return "page2";
	}
	
	@GetMapping("/sobre")
	private String exibirSobre() {
		return "sobre";
	}

}
