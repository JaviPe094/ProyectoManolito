<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body{
	background-color:#FFC;
}

table{
	background:#FF6;
	padding:30px;
	border:solid 2px #FF0000;
}

td{
	padding:5px 0;
}

form{
margin-left:500px;

}

</style>
</head>
<body>
<h1 style="text-align:center; color:red">Usuario Incorrecto</h1>
<form method="post">

  <table width="50%" border="0">  
    <tr>
      <td colspan="2" align="center">
      	<h3>¿No tienes cuenta? Registrate!</h3>
      	<input style="margin-top: 20px; padding: 4px;" formaction="formulario_registro.html" type="submit" name="button_si" id="button_si" value="Aceptar">
		<input style="margin-top: 20px; padding: 4px;" formaction="formulario_login.html" type="submit" name="button_no" id="button_no" value="Cancelar">
      </td>
    </tr>
    
  </table>
  <p><br>
  </p>
</form>
</body>
</html>