<!doctype html>
<html>
<head>
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
<body>
	<div>
	<h2>Actualizar tarea</h2>
	<form action="Controlador" method="post">
		<table width="50%">
  <tbody>
    <tr>
      <td>NOMBRE</td>
      <td><input type="text" name="nombre" id="nombre" value="${nombre}" required></td>
    </tr>
	  
    <tr>
      <td>DESCRIPCION</td>
      <td><input type="text" name="descripcion" id="descripcion" value="${nombre}" required></td>
    </tr>
	  
    <tr>
      <td>ESTADO</td>
      <td><input type="text" name="estado" id="estado" value="${estado}" required></td>
    </tr>
  </tbody>
</table>
		
		<input id="botonEnviar" type="submit" value="Actualizar">
<%-- 		<input type="hidden" name="das" id="das" value="${nombre}"> --%>
		<input type="hidden" name="instruccion" value="funcion_actualizar_tareas">
	</form>
	</div>
	
</body>
</html>
