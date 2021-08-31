package LoginAPI;

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
public class LoginController {
	@Autowired
	private AlunoDAO alunoDAO;
	

	
	
}
