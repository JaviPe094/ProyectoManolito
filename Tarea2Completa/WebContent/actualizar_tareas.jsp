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
	<h2>Inserción tareas</h2>
	<form action="Controlador" method="post">
		<table width="50%">
  <tbody>
    <tr>
      <td>NOMBRE</td>
      <td><input type="text" name="nombre" id="nombre"></td>
    </tr>
	  
    <tr>
      <td>DESCRIPCION</td>
      <td><input type="text" name="descripcion" id="descripcion"></td>
    </tr>
	  
    <tr>
      <td>ESTADO</td>
      <td><label><input type="radio" name="estado" value="a" id="estado_1">Activo</label>
        <br>
        <label><input type="radio" name="estado" value="n" id="estado_2">Nuevo</label>
        <br>
        <label><input type="radio" name="estado" value="i" id="estado_2">Inactivo</label>
        </td>
    </tr>
  </tbody>
</table>
		
		<input id="botonEnviar" type="submit">
		<input type="hidden" name="instruccion" value="actualizar_tareas">
	</form>
	</div>
	
</body>
</html>
