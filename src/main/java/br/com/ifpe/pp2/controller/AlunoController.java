package br.com.ifpe.pp2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifpe.pp2.classe.Aluno;
import br.com.ifpe.pp2.classe.AulaPratica;
import br.com.ifpe.pp2.dao.AlunoDAO;

@Controller
public class AlunoController {
	@Autowired
	private AlunoDAO alunoDAO;
	
	@GetMapping("/paginaInicial")
	private String exibirPgInicial() {
		return "index";
	}
	
	@GetMapping("/sobre")
	private String exibirSobre() {
		return "sobre";
	}
	
	@GetMapping("/loginAluno")
	private String exibirLogin() {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nomeUsuario = auth.getName();

		Aluno ususarioASerAlterado = repositorioUsuario.findByUsername(nomeUsuario);
		model.addAttribute("usuario", ususarioASerAlterado);*/
		return "login";
	}
	
	@GetMapping("/alunoPage")
	private String exibirPageAluno(HttpSession session,Model model) {
		Aluno aluno =(Aluno)session.getAttribute("usuarioLogado");
		model.addAttribute("aluno", aluno);
		return "aluno/alunoPage";
	}
	
	@PostMapping("/efetuarLoginAluno")
	public String efetuarLogin(Aluno aluno, RedirectAttributes ra, HttpSession session) {
		aluno = this.alunoDAO.findByCpfAndSenha(aluno.getCpf(), aluno.getSenha());
		System.out.println("---------------------------------");
		if (aluno != null) {
			session.setAttribute("usuarioLogado", aluno);
			return "redirect:/alunoPage";
		}else {
			ra.addFlashAttribute("mensagemErro", "Usuário/senha inválidos");
			return "redirect:/login";
		}	
		//return "redirect:/";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//------------inicio pre matricula-------------
	
	@GetMapping("/exibirPreCadastroAluno")
	private String exibirPreCadastroAluno(Aluno aluno) {
		return "aluno/prematricula";
	}
	@PostMapping("/precadastroAluno")
	private String precadastroAluno(@Valid Aluno aluno, BindingResult result, Model model, RedirectAttributes ra) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "exibirPreCadastroAluno";
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
	
	//-------------fim pre matricula-------------
	
	//-------------inicio cadastro aluno-------------
	@GetMapping("/exibirCadastroAluno")
	private String exibirCadastroAluno(Aluno aluno) {
		return "prematricula";
	}
	@PostMapping("/cadastroAluno")
	private String cadastroAluno(@Valid Aluno aluno, BindingResult result, Model model, RedirectAttributes ra) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "aluno/prematricula";
		}
	    if(aluno == null) {         // check if user object is empty
	    	aluno = new Aluno();    // if user is empty, then instantiate a new user object
	    	model.addAttribute("aluno", aluno);
	    }
		try {
			//transf em service
			aluno.setIsAtivo(1);
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
	//-------------fim cadastro aluno-------------
	
	@GetMapping("/editarAluno")
	public String editarAluno(Integer codigo, Model model) {
		model.addAttribute("aluno", this.alunoDAO.findById(codigo));
		return "cliente/cliente-form";
	}
	
	@GetMapping("/listarAluno")
	public String exibirLista(Model model) {
		model.addAttribute("listaAluno", alunoDAO.findAll(Sort.by("nome")));
		return "aluno/aluno-list";
	}
	
	@GetMapping("/removerAluno")
	public String removerCliente(Integer codigo) {
		this.alunoDAO.findById(codigo);
		return "redirect:/listarAlunos";
	}
	
	}
