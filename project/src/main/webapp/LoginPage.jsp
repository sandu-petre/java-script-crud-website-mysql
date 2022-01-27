<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", -1);
%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<script>
		function clearForms() {

		var i;
		for (i = 0; (i < document.forms.length); i++)

			document.forms[i].reset();
		}
		function validateForm() {
			var x = document.forms["myForm"]["un"].value;
			if (x == null || x == "") {
				alert("Username must be filled out");
				document.getElementById('un').focus();
				return false;
			}
			var y = document.forms["myForm"]["pw"].value;
			if (y == null || y == "") {
				alert("password must be filled out");
				document.getElementById('pw').focus();
				return false;
			}
		}
	</script>
</head>
<body style="background-color:powderblue;">
	<div align="center" ><br/><br/><br/><br/>
	<div style ="width:900px">
	<strong>Welcome to a demonstration site made in Java Script were we try to manipulate a database in mysql from this site </strong><br/><br/><br/><br/>
	<strong>Login to my app</strong><br/><br/>
	<form action="LoginServlet" onsubmit="return validateForm()" method="post"name="myForm">
		Please enter your user name<br/> <input type="text" name="un" id="un" /><br/>
		Please enter your password<br/> <input type="text" name="pw" id="pw" /><br/>
		<input type="submit" value="Login">
	</form>
	</div>
	</div>

</body>
</html>