package daw.project.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daw.project.model.beans.UserBean;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {     
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		//System.out.println("Requested: " + httpRequest.getRequestURL() + " - " + httpRequest.getServletPath());
		
		
		if("/LoginPage.jsp".equals(httpRequest.getServletPath()) || "/InvalidLogin.jsp".equals(httpRequest.getServletPath()) 
				|| "/LoginServlet".equals(httpRequest.getServletPath())) {
			// pass the request along the filter chain
			chain.doFilter(request, response);	
		}else {
			HttpSession session = httpRequest.getSession();
			UserBean currentUser = (UserBean)(session.getAttribute("currentSessionUser"));
			if(currentUser!=null) {
				System.out.println("Auth check for user"+ currentUser.getUsername());
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				System.out.println("Auth failed for reaching the resurce"+ httpRequest.getServletPath());
				((HttpServletResponse) response).sendRedirect("LoginPage.jsp");
			}
		}
		
	}

}
