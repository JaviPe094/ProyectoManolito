<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Nueva Contraseña</title>
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
		height: 260px;
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
	<%
	String msg = (String) request.getSession().getAttribute("msg");
	if(msg != null && !msg.isEmpty()){%>
		<span style="color:#B40404">${msg}</span>
	<%}%>
	
	<h2>Nueva contraseña</h2>
	<form action="Controlador" method="post">
	<input type="hidden" name="instruccion" value="usuarioAceptado">
		<p>Introduce la nueva contraseña</p>
		<input type="password" name="contrasena" id="contrasena">
		<br><br>
		<input id="botonEnviar" type="submit">
	</form>
	</div>
</body>
</html>