package daw.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daw.project.model.beans.ProductBean;
import daw.project.model.dao.ProductDAO;

/**
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get products from DB 
		List<ProductBean> productList= ProductDAO.findAll();
		 
		// store product list on request, so the View could use it
		 request.setAttribute("products", productList);
		 
		 //dispatch request to View area
		 RequestDispatcher rd = request.getRequestDispatcher("private/products.jsp");
		 rd.forward(request, response);
		 
		 
	}

}
