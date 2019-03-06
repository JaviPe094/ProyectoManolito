<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>formulario_login</title>
	<style type="text/css">
	html{
		
		background-color: #648CE9;
	}
		body{
		position: relative;
		border: solid #223DBB 3px;
		margin:20px auto auto;
		background-color: white;
		width: 300px;	
		height: 345px;
		padding: 10px;
		
	}
		

		div{
			position: absolute;
			background-color: #167CDC;
			width: 258px;
			padding: 20px;
			margin-top: 40px;
		}
		
		div h2{
			
			margin-top: -60px;
			border-bottom: dotted #0055AF;
		}
		
		form{
			
			padding-top: 20px;
			margin-left: 13px;
		}
		
		#botonEnviar{
			margin-top: 20px;
			margin-left: 80px;
			padding: 7px;
			padding-left: 20px;
			padding-right: 20px;
			font-size: 14px;
			background-color: #69B2FF;
		}
		
		p{
			
			font-family: Constantia, "Lucida Bright", "DejaVu Serif", Georgia, "serif";
			font-weight: 200;
			font-size: 18px;
			color: #FFFFFF;
		}
		
		input{
			
			font-size: 14px;
			padding: 5px;
			
		}		
	 
	</style>
</head>
<body bgcolor="#ADD5FF">
	<div>
	<h2>LOGIN</h2>
	<form name="form1" method="post" action="Controlador">
	<input type="hidden" name="instruccion" value="validar">
	<%
	String msg = (String) request.getSession().getAttribute("msg");
	if(msg != null && !msg.isEmpty()){%>
		<span style="color:#B40404">${msg}</span>
	<%}%>
		<p>Usuario</p>
		<input type="text" name="usuario" id="usuario" required="required"> 
		<br>
		<p>Contraseña</p>
		<input type="password" name="contra" id="contra" required="required">
		<br><br>
		<input id="botonEnviar" type="submit" value="Aceptar">
		
		
	</form>
	</div>
</body>
</html>
