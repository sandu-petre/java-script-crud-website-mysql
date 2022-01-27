<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new product</title>
</head>
<body style="background-color:powderblue;">
<div style="text-align: right"><a   href="ProductListServlet">Return</a>|<a   href="LogoutServlet">Logout</a></div>
<div align="center" >
<div style="width: 350px;">
	<h1>Create new product</h1>
	
	
	<div  style="width:100%; text-align: left">
	
		<form  action="InsertProductServlet" method="post">
			<table >
				<tr>
					<td>Name</td>
					<td><input type="text" name="prod_name" maxlength="45"></td>	
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="prod_desc" rows="5" cols="21" maxlength="255"></textarea></td>		
				</tr>
				<tr>
					<td>Price</td>	
					<td><input type="text" name="prod_price" maxlength="10"></td>	
				</tr>
				<tr>
					<td>Quantity</td>	
					<td><input type="text" name="prod_quant" maxlength="10"></td>		
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