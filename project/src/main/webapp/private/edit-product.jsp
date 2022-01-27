<%@page import="daw.project.model.beans.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit  product</title>
</head>
<body style="background-color:powderblue;">
<div style="text-align: right"><a   href="ProductListServlet">Return</a>|<a   href="LogoutServlet">Logout</a></div>
<div align="center" >
<%
ProductBean productToEdit =(ProductBean) request.getAttribute("productToEdit");
%>
<div style="width: 350px;">
	<h1>Edit  product</h1>
	
	
	<div  style="width:100%; text-align: left">
	
		<form  action="UpdateProductServlet" method="post">
			<input type="hidden" name="prod_id" value="<%=productToEdit.getIdProduct() %>">
			<table >
				<tr>
					<td>Name</td>
					<td><input type="text" name="prod_name" maxlength="45" value="<%= productToEdit.getProductName() %>"></td>	
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="prod_desc" rows="5" cols="21" maxlength="255"><%= productToEdit.getProductDescription() %></textarea></td>		
				</tr>
				<tr>
					<td>Price</td>	
					<td><input type="text" name="prod_price" maxlength="10" value="<%= productToEdit.getProductPrice() %>"></td>	
				</tr>
				<tr>
					<td>Quantity</td>	
					<td><input type="text" name="prod_quant" maxlength="10" value="<%= productToEdit.getProductQuantity() %>"></td>		
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="SAVE">&nbsp;&nbsp;<input type="reset" value="RESET">&nbsp;&nbsp;<input type="button" value="CANCEL" onclick="location.href='ProductListServlet';"></td>
					
				</tr>
			</table>
		
		</form>
	</div>
	</br>
	</div>
</div>


</body>
</html>