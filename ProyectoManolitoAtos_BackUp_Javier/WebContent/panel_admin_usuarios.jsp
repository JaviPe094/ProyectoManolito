<%@page import="proyectoAtos.Entidades.Empleados"%>
<%@page import="proyectoAtos.Entidades.Tareas"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>

<script src="js/Timeout.js"></script>


<meta charset="utf-8">
<title>Panel Administracion Usuarios</title>
	<style type="text/css">
		
			html{
		
		background-color: #648CE9;
	}
		body{
		position: relative;
		border: solid #223DBB 3px;
		margin:20px auto auto;
		background-color: white;
		width: 950px;	
		height: 750px;
		padding: 10px;
		
	}
	
		
		#marcoInfo{
			
			position: relative;
			background-color: #167CDC;
			width: 400px;
			height: 300px;
			padding: 20px;	
		}
		
		#imagenUser{
			border: solid #223DBB 3px;
			position: absolute;
			margin-top: -290px;
			margin-left: 250px;
			width: 150px;
			height: 170px;
			background-color: #FFFFFF;
		}
		
		#img{
			margin-top: 5px;
			margin-left: -4px;
		}
		
		div h2{
			
			margin-top: -60px;
			border-bottom: dotted #0055AF;
		}
			
		form{
			
			
			margin-left: 13px;
		}
		
		#botonEnviar{
			margin-top: 20px;
			margin-left: 60px;
			padding: 7px;
			font-size: 14px;
			background-color: #69B2FF;
			
		}
		
		p{
			margin-top: 8px;
			font-family: Constantia, "Lucida Bright", "DejaVu Serif", Georgia, "serif";
			font-weight: 200;
			font-size: 14px;
			color: #FFFFFF;
		}
		
		input{
			
			font-size: 14px;
			padding: 2px;
		}
		
		#marcoOperaciones{
			position: absolute;
			float: right;
			background-color: #167CDC;
			margin-top: -340px;
			width: 500px;
			height: 340px;
			margin-left: 450px;
		}
		#cabecera{
			
			position: absolute;
			
		}
		
		#parteAbajo{
			
			position: absolute;
			width: 950px;
			height: 40px;
			margin-top: 5px;
		}
		#marcoTareas{
			position: relative;
			background-color: #167CDC;
			width: 100%;
			height: 390px;
			margin-top: 10px;
		}
		
		#fondoTabla{
			position: absolute;
			background-color: #FFFFFF;
			margin-top:20px;
			margin-left:50px;
			height: 350px;
			width: 90%;
		}
		
		#titulo{
			position: absolute;
			height: 20px;
			background-color: #0646B5;
			margin-top: 20px;
			padding: 10px;
			margin-left: 30px;
			width: 400px;
			border: dashed #FFFFFF;
		}
		#operaciones{
			
			position: relative;
			color: #FFFFFF;
			margin-left: 150px;
			font-size: 25px;
			margin-top: -5px;
			
		}
		
		#botonAccionUser{
			
			position: relative;
			margin-top: 100px;
			width: 300px;
			margin-left: 60px;
			
		}
		
		#botonAccionUser input{
			
			width: 100%;
		}
		
		#botonesAccion{
			
			position: absolute;
			margin-top: 740px;
			margin-left: 50px;
		}
		
		#tabla{
			position: absolute;
			width: 100%;
			margin-top: 1px;
			
		}
		
		
	
	</style>
</head>

<%
	//obtener los registros de Empleados
	List<Empleados> listaEmpleados = (List<Empleados>) request.getAttribute("LISTAREMPLEADOS");
%>



<body onmousemove="reiniciarTimeout(60)" onkeypress="reiniciarTimeout(60)" onload="iniciarTimeout(60)" bgcolor="#ADD5FF">

<body bgcolor="#ADD5FF">

	
	<div id="cabecera">
	
	<div id="marcoInfo">
		
		<h3>DATOS ADMINISTRADOR</h3>
		<p>DAS:</p><input type="text" value="${das}">
		<p>NOMBRE:</p><input type="text" value="${nombre}">
		<p>APELLIDO:</p><input type="text" value="${apellido}">
		<p>E-MAIL:</p><input type="text" value="${email}">
		
		<div id="imagenUser">
			<div id="img"><img width="160px" src="img/User_icon_2.svg.png"></div>
		</div>
		
	
	</div>
	<div id="marcoOperaciones">
		
		<div id="titulo"><div id="operaciones">Operaciones</div>
		
		<div id="botonAccionUser">
			<form action="Controlador" method="post">
			<input type="submit" value="VISTA USUARIOS">
			<input type="hidden" name="instruccion" value="listarEmpleados">
			</form>
			<br><br>
			<form action="Controlador" method="post">
			<input type="submit" value="VISTA TAREAS">
			<input type="hidden" name="instruccion" value="listarTareas">
			</form>
		</div>
	
	</div>
		
	</div>
	
	<div id="parteAbajo">
	<div id="marcoTareas">
		<div id="fondoTabla">
			
			<table id="tabla" width="100%" border="2">
  <tbody>
   <tr>
      <th>DAS</th>
      <th>PASSWORD</th>
      <th>NOMBRE</th>
      <th>APELLIDO</th>
      <th>EMAIL</th>
      <th>ESTADO</th>
      <th>PERMISOS</th>
      
    </tr>
    
    <% for(Empleados emp : listaEmpleados){%>

		 <tr>
		 	<td><%=emp.getDas()%></td>
		 	<td><%=emp.getPassword()%></td>
		 	<td><%=emp.getNombre()%></td>
		 	<td><%=emp.getApellido()%></td>
		 	<td><%=emp.getEmail()%></td>
		 	<td><%=emp.getEstado().getEstado()%></td>
		 	<td><%=emp.getPermiso().getNombre()%></td>
		 	
		 
    </tr>
    <%} %>
  </tbody>
</table>

			
	</div>
	</div>
	<div id="botonesAccion"><input type="submit" value="Insertar Tarea">&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Borrar Tarea"></div>
	</div>
			
</body>
</html>