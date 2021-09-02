package br.com.ifpe.pp2.controller;

import java.util.Optional;

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
import br.com.ifpe.pp2.classe.Professor;
import br.com.ifpe.pp2.dao.ProfessorDAO;
import br.com.ifpe.pp2.dao.AlunoDAO;
import br.com.ifpe.pp2.dao.AulaPraticaDAO;

//alteta tds rotas da classe, antes tem q ter /aulaPratica
@Controller
@RequestMapping("/aulaPratica")
public class AulaPraticaController {
	@Autowired
	private ProfessorDAO professorDAO;
	@Autowired
	private AlunoDAO alunoDAO;
	@Autowired
	private AulaPraticaDAO aulaPraticaDAO;
	
	@GetMapping("/listarAulasPraticas")
	public String exibirLista(Model model) {
		model.addAttribute("listaAulas", this.aulaPraticaDAO.findAll(Sort.by("data")));
		return "aulaPratica/aulaPratica-list";
	}
	@GetMapping("/listarAulasPraticasPorAluno")
	public String exibirLista(Model model, Integer id) {
		//testar se funciona
		Optional<Aluno> aluno = this.alunoDAO.findById(id);
		model.addAttribute("listaAulas", this.aulaPraticaDAO.findByAluno(aluno));
		return "aulaPratica/aulaPratica-list-por-aluno";
	}
	
	@GetMapping("/exibirFormCadastrarAulaPraticaPorAluno")
	public String exibirFormCadastrarAulaPraticaPorAluno(Integer id, AulaPratica aulaPratica, Model model) {
		model.addAttribute("aluno",alunoDAO.findById(id));
		model.addAttribute("listaProf", professorDAO.findAll(Sort.by("nome")));
		return "aulaPratica/agendamentoAulaPraticaPorAluno";
	}
	
	@GetMapping("/exibirFormCadastrarAulaPratica")
	public String exibirFormCadastrarAulaPratica(Integer id, AulaPratica aula, Model model) {
		model.addAttribute("listaProf", professorDAO.findAll(Sort.by("nome")));
		model.addAttribute("listaAluno",alunoDAO.findAll(Sort.by("nome")));
		return "aulaPratica/agendamentoAulaPratica";
	}
	
	
	@PostMapping("/salvarAulaPratica")
	private String salvarAulaPratica(@Valid AulaPratica aula, Aluno aluno, Professor professor, Integer id, BindingResult result, Model model, RedirectAttributes ra) {
		if (result.hasErrors()) {
			//return exibirFormCadastrarAulaPratica(id, aula, model);
		}
		aula.setAluno(aluno);
		aula.setProfessor(professor);
		this.aulaPraticaDAO.save(aula);
		return "redirect:/listarAulasPraticasPorAluno";
	}	
	
	@GetMapping("/editarAulaPratica")
	public String editarAulaPratica(Integer id, Model model) {
		model.addAttribute("aula", this.aulaPraticaDAO.findById(id));
		model.addAttribute("listaProf", professorDAO.findAll(Sort.by("nome")));
		return "aulaPratica/agendamentoAulaPratica";
	}

	@GetMapping("/removerAulaPraticaPorAluno")
	public String removerAulaPraticaPorAluno(Integer id, RedirectAttributes ra) {
		this.aulaPraticaDAO.deleteById(id);	
		return "redirect:/listarAulasPraticasPorAluno";
	}
	
	@GetMapping("/removerAulaPratica")
	public String removerAulaPratica(Integer id, RedirectAttributes ra) {
		this.aulaPraticaDAO.deleteById(id);	
		return "redirect:/listarAulasPraticas";
	}
}
