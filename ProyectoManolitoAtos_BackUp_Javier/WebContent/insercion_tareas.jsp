<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
<script src="js/Timeout"></script>
<meta charset="utf-8">
<title>Inserccion Tareas</title>
	
	<style type="text/css">
		html{
		
		background-color: #648CE9;
	}
		body{
		position: relative;
		border: solid #223DBB 3px;
		margin:20px auto auto;
		background-color: white;
		width: 340px;	
		height: 290px;
		padding: 10px;
		
	}
		

		div{
			position: absolute;
			background-color: #167CDC;
			width: 300px;
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
			margin-top: 40px;
			margin-left: 90px;
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
<body onkeypress="reiniciarTimeout(60)" onmousemove="reiniciarTimeout(60)" onload="iniciarTimeout(60)">
	<div>
	<h2>Inserción tareas</h2>
	<form action="Controlador" method="post">
		<table width="50%">
  <tbody>
    <tr>
      <td>NOMBRE</td>
      <td><input type="text" name="nombre" id="nombre" required></td>
    </tr>
	  
    <tr>
      <td>DESCRIPCION</td>
      <td><input type="text" name="descripcion" id="descripcion" required></td>
    </tr>
	  
    <tr>
      <td>ESTADO</td>
      <td><label><input type="radio" name="estado" value="a" id="estado_1" required="required">Activo</label>
        <br>
        <label><input type="radio" name="estado" value="n" id="estado_2" checked="checked">Nuevo</label>
        <br>
        <label><input type="radio" name="estado" value="i" id="estado_2">Inactivo</label>
        </td>
    </tr>
  </tbody>
</table>
		
		<input id="botonEnviar" type="submit">
		<input type="hidden" name="instruccion" value="insertar_tarea">
		<p>
		<%
		String msg = (String) request.getSession().getAttribute("msg");
		if(msg != null && !msg.isEmpty()){%>
			<span style="color:#B40404">${msg}</span>
		<%}%>
		</p>
	</form>
	</div>
	
</body>
</html>
