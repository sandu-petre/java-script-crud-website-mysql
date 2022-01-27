<%@page import="daw.project.model.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control","no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
if(session.getAttribute("currentSessionUser")!=null) {
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title> User Logged Successfully </title>
			<script type="text/javascript">
				function noBack() {
					window.history.forward();
				}
			</script>
	</head>
	<body onload="noBack();" style="background-color:powderblue;">
		<a href="../LogoutServlet">Logout</a>
		|
		<a href="../ProductListServlet">ProductList</a>
		<div align="center">
			<% UserBean currentUser = (UserBean)(session.getAttribute("currentSessionUser"));%>
				Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
				</br>
				
				
				CRUD operations
				
		</div>
	</body>
<%
} else {
	response.sendRedirect("LoginPage.jsp");
}
%>
</html>