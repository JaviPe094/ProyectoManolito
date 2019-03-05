<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>



<style>
body {
	background-color: #FFC;
}

table {
	background: #FF6;
	padding: 30px;
	border: solid 2px #FF0000;
}

td {
	padding: 5px 0;
}

form {
	margin-left: 590px;
}
</style>
</head>

<body>
	<c:if test="#{msg != ''}">
		 	<%-- Mostrar valor atributo --%>
		 	<h3>${msg}</h3>
		 </c:if>
	<!--  <h1 style="text-align: center">Login</h1>-->
	<form action="LoginEmpleados" method="post">

		<table width="30%" border="0">
			<tr>
				<td><label for="usuario">Usuario: </label></td>
				<td><input type="text" name="usuario" id="usuario"></td>
			</tr>
			<tr>
				<td><label for="contra">Contrase�a: </label></td>
				<td><input type="password" name="contra" id="contra"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input
					style="margin-top: 20px; padding: 4px;" type="submit" name="button"
					id="button" value="Enviar"></td>
			</tr>

		</table>
		<p>
			<br>
		</p>
	</form>
</body>
</html>