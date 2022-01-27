package daw.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daw.project.model.beans.UserBean;
import daw.project.model.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			UserBean user = new UserBean();
			user.setUsername(request.getParameter("un"));
			user.setPassword(request.getParameter("pw"));
			user = UserDao.login(user);
				if (user.isValid()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", user);
					response.sendRedirect("ProductListServlet"); // logged-in page
				}
				else
					response.sendRedirect("InvalidLogin.jsp"); // error page

				}
			catch (Throwable theException) {
			System.out.println(theException);
			}
	}
}

