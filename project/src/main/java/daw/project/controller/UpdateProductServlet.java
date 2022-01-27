package daw.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daw.project.model.beans.ProductBean;
import daw.project.model.dao.ProductDAO;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("prod_id"); 
		String productName = request.getParameter("prod_name");
		String productDescription = request.getParameter("prod_desc");
		String productPrice = request.getParameter("prod_price");
		String productQuantity = request.getParameter("prod_quant");
		
		ProductBean productToEdit= new ProductBean();
		
		try {
			productToEdit.setIdProduct(Integer.parseInt(productId));
		} catch (NumberFormatException e) {
			response.sendRedirect("ProductListServlet?edited=0"); 
		}
		
		
		if(productName !=null && !"".equals(productName)) {
			productToEdit.setProductName(productName);
		}else {
			//TODO de tratat eraora prin retimitere spre formulat
		}
		if(productDescription !=null) {
			productToEdit.setProductDescription(productDescription);
		}
		
		
		try {
			productToEdit.setProductPrice(Float.parseFloat(productPrice));
		} catch (NumberFormatException e) {
			productToEdit.setProductPrice(0);
		}
		
		try {
			productToEdit.setProductQuantity(Integer.parseInt(productQuantity));
		} catch (NumberFormatException e) {
			productToEdit.setProductQuantity(0);
		}
		
		int edited = ProductDAO.save(productToEdit);
		
		response.sendRedirect("ProductListServlet?edited="+edited);

		
	}

}
