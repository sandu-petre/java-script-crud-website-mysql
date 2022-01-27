package daw.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daw.project.model.beans.ProductBean;
import daw.project.model.dao.ProductDAO;

/**
 * Servlet implementation class InsertProductServlet
 */
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productName = request.getParameter("prod_name");
		String productDescription = request.getParameter("prod_desc");
		String productPrice = request.getParameter("prod_price");
		String productQuantity = request.getParameter("prod_quant");
		
		ProductBean newProduct= new ProductBean();
		
		
		if(productName !=null && !"".equals(productName)) {
			newProduct.setProductName(productName);
		}else {
			//TODO de tratat eraora prin retimitere spre formulat
		}
		if(productDescription !=null) {
			newProduct.setProductDescription(productDescription);
		}
		
		
		try {
			newProduct.setProductPrice(Float.parseFloat(productPrice));
		} catch (NumberFormatException e) {
			newProduct.setProductPrice(0);
		}
		
		try {
			newProduct.setProductQuantity(Integer.parseInt(productQuantity));
		} catch (NumberFormatException e) {
			newProduct.setProductQuantity(0);
		}
		
		int created = ProductDAO.create(newProduct);
		
		response.sendRedirect("ProductListServlet?created="+created);
		
	}

}
