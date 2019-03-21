<!doctype html>
<html>
<head>
<script src="js/Timeout"></script>
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
<body onkeypress="reiniciarTimeout(60)" onmousemove="reiniciarTimeout(60)" onload="iniciarTimeout(60)" bgcolor="#ADD5FF">
	<div>
	<h2>Actualizar usuario</h2>
	<form action="Controlador" method="post">
		<table width="100%">
  <tbody>
 	<tr>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>NOMBRE</td>
      <td><input type="text" name="nombre" id="nombre" value="${nombre}" required></td>
    </tr>
    <tr>
      <td>APELLIDOS</td>
      <td><input type="text" name="apellidos" id="apellidos" value="${apellido}" required></td>
    </tr>
    <tr>
      <td>EMAIL</td>
      <td><input type="email" name="email" id="email" value="${email}" required></td>
    </tr>
     <tr>
      <td>ESTADO</td>
      <td><input type="text" name="estado" id="estado" value="${estado}" required></td>
    </tr>
    <tr>
      <td>PERMISOS</td>
      
<%--       <td><input type="text" name="permisos" id="permisos" value="${permisos}" required></td> --%>

		<label><input type="radio" name="permisos" value="admin" id="permisos_1">Admin</label>
        <br>
        <label><input type="radio" name="permisos" value="basico" id="permisos_2" checked>Basic</label>
        <br>

    </tr>
  </tbody>
</table>
	<input id="botonEnviar" type="submit" value="Actualizar">
	<input type="hidden" name="das" id="das" value="${das}">
	<input type="hidden" name="instruccion" value="funcion_actualizar_emple">
	</form>
<!-- 	<form></form> -->
	</div>
</body>
</html>

