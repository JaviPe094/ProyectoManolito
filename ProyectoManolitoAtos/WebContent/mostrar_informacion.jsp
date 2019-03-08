<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Insercion Usuarios</title>
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
			width: 100%;
			padding-top: 20px;
			margin-left: -10px;
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
		
		#botonEnviar{
			
		
			margin-top: 50px;
			margin-left: 90px;
			padding: 7px;
			padding-left: 20px;
			padding-right: 20px;
			font-size: 14px;
			background-color: #69B2FF;
		}
		
	
	</style>
</head>
<body bgcolor="#ADD5FF">
	<div>
	<h2>Informacion usuario</h2>
	<form action="Controlador" method="post">
		<table width="100%">
  <tbody>
  	<%
	String msg = (String) request.getSession().getAttribute("msg");
	if(msg != null && !msg.isEmpty()){%>
		<span style="color:#B40404">${msg}</span>
	<%}%>
  
    <tr>
      <td>DAS</td>
      <td><input type="text" name="das" id="das" value="${das}" readonly></td>
    </tr>
    <tr>
      <td>CONTRASE�A PROVISIONAL</td>
      <td><input type="text" name="pass" id="pass" value="${pass}" readonly></td>
    </tr>
    <tr>
      <td>NOMBRE</td>
      <td><input type="text" name="nombre" id="nombre" value="${nombre }" readonly></td>
    </tr>
    <tr>
      <td>APELLIDOS</td>
      <td><input type="text" name="apellidos" id="apellidos" value="${apellido }" readonly></td>
    </tr>
    <tr>
      <td>EMAIL</td>
      <td><input type="email" name="email" id="email" value="${email }" readonly></td>
    </tr>
    <tr>
       <td>PERMISOS</td>
      <td><input type="text" name="permisos" id="permisos" value="${permisos }" readonly></td>
    </tr>
 
  </tbody>
</table>
		<input id="botonEnviar" type="submit" value="Aceptar">
		<input type="hidden" name="instruccion" value="listarEmpleados">
	</form>
	</div>
</body>
</html>

