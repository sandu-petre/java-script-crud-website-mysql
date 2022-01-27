<%@page import="daw.project.model.beans.ProductBean"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product list</title>
</head>
<body style="background-color:powderblue;">
<div align="center">
	<div style="width:1000px">
	<div style="text-align: right"><a   href="private/userLogged.jsp">Return</a>|<a   href="LogoutServlet">Logout</a></div>
	<h1>Products in store</h1>
	<%
	String created= request.getParameter("created");
	if("1".equals(created)){
	%>
	<div style="text-align: center; color: #008800">New product created successfully</div>
	<%	
	}else if("0".equals(created)){
		%>
		<div style="text-align: center; color: #ff0000">New product failed to create</div>
		<%	
		
	}
	
	String deleted= request.getParameter("deleted");
	if("1".equals(deleted)){
	%>
	<div style="text-align: center; color: #008800">The product deleted successfully from data base</div>
	<%	
	}else if("0".equals(deleted)){
		%>
		<div style="text-align: center; color: #ff0000">Failed to delete product</div>
	<%		
	}
	
	String edited= request.getParameter("edited");
	if("1".equals(edited)){
	%>
	<div style="text-align: center; color: #008800">The product edited successfully from data base</div>
	<%	
	}else if("0".equals(edited)){
		%>
		<div style="text-align: center; color: #ff0000">Failed to edit product</div>
	<%		
	}
	
	String error= request.getParameter("error");
	if("init-edit".equals(error)){ 	
	%>
		<div style="text-align: center; color: #ff0000">Can't edit product</div>
	<%		
	}
	%>
	
	<div style="width:100%; text-align: left">
	<a href="CreateProductServlet">Create new product</a>
	</div>
	</br>
	
<%
List<ProductBean> products = (List<ProductBean>) request.getAttribute("products");

if(products== null || products.size()==0){
	%>
	<h3 style="color: #ff0000">No products in store</h3>
	<%
}else{
	%>
	<table style="width: 100%" border="1 px solid">
		
			<tr><th>Name</th><th>Description</th><th>Price</th><th >Quantity</th><th>Action</tr>
	<%
		for (ProductBean pb : products) {
	%>
			<tr>
				<td><%= pb.getProductName() %></td>
				<td><%= pb.getProductDescription() %></td>
				<td><%= pb.getProductPrice() %></td>
				<td><%= pb.getProductQuantity() %></td>
				<td>
				<a href="EditProductServlet?id=<%= pb.getIdProduct() %>">Edit</a>
				/
				<a  "whatever" onclick="return confirm('are you sure you want to delete the product?')" href="DeleteProductServlet?id=<%= pb.getIdProduct() %>">Delete</a>
			
				</td>
			</tr>
	<%
		}
	%>		
	</table>
	
	<%
}
%>


	</div>
</div>

</body>
</html>