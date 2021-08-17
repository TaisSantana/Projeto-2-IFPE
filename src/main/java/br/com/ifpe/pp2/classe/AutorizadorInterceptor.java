package br.com.ifpe.pp2.classe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AutorizadorInterceptor implements HandlerInterceptor{
	//indica se vai continuar com a requisição, ou não.
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
        if( uri.endsWith("AlunoPage") ||
            uri.endsWith("efetuarLogin") ||
            uri.contains("/assets") ||
            uri.endsWith("/paginaInicial")) {
            return true;
        }
        
		if (request.getSession().getAttribute("usuarioLogado") == null) {
			try {
			request.getRequestDispatcher("/paginaInicial").forward(request, response); // redirecionar para outra página
			return false;}catch(Exception e) {System.out.println(e.getMessage());}return false;
		} else {
			return true;
		}
	}
}
