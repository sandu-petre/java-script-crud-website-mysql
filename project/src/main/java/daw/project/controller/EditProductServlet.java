package daw.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daw.project.model.beans.ProductBean;
import daw.project.model.dao.ProductDAO;

/**
 * Servlet implementation class EditProductServlet
 */
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId =request.getParameter("id");
		
		ProductBean productToEdit = ProductDAO.findById(productId);
		if (productToEdit==null) {
			response.sendRedirect("ProductListServlet?error=init-edit");
		}else {
			 
			// store product to edit  on request, so the View could use it
			 request.setAttribute("productToEdit", productToEdit);
			 
			 
			RequestDispatcher rd = request.getRequestDispatcher("private/edit-product.jsp");
			 rd.forward(request, response);			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("private/edit-product.jsp");
		 rd.forward(request, response);
		
	
	}

}
