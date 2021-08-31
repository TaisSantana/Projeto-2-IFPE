package LoginAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AutorizadorInterceptor implements HandlerInterceptor{
	
	private static final String[] RECURSOS_LIVRES = {"/","/precadastroAluno","/assets","/login","/logout","/acesso-negado","/pre","/sobre","/paginaInicial"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		
		for (String recurso: RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				System.out.println(recurso +"- TERMINA COM RECURSO.");
				return true;
			}
		}
        
		if (request.getSession().getAttribute("usuarioLogado") == null) {	
			System.out.println("var USUARIOLOGADO == NULL");
			request.getRequestDispatcher("redirect:/paginaInicial").forward(request, response); // redirecionar para outra página	
			return false;
		} else {
			System.out.println("var USUARIOLOGADO DIF NULL");
			return true;
		}
	}
}
