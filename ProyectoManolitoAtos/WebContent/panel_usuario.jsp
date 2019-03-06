<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Panel Usuario</title>
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
			position: relative;
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
		}
		#marcoTareas{
			position: absolute;
			background-color: #167CDC;
			width: 950px;
			height: 400px;
			margin-top: 350px;
		}
		
		#fondoTabla{
			position: relative;
			background-color: #FFFFFF;
			margin: 40px;
			height: 320px;
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
			margin-top: 150px;
			width: 300px;
			margin-left: 100px;
			
		}
		
		#botonAccionUser input{
			
			width: 100%;
		}
		
		
	
	</style>
</head>
<body bgcolor="#ADD5FF">
	
	<div id="cabecera">
	
	<div id="marcoInfo">
		
		<h3>DATOS USUARIO</h3>
		<p>DAS:</p><input type="text" value="${das}">
		<p>NOMBRE:</p><input type="text" value="${nombre}">
		<p>APELLIDO:</p><input type="text" value="${apellido}">
		<p>E-MAIL:</p><input type="text" value="${email}">
		
		<div id="imagenUser">
			<div id="img"><img width="160px" src="img/User_icon_2.svg.png"></div>
		</div>
		
	
	</div>
	<div id="marcoOperaciones">
		
		<div id="titulo"><div id="operaciones">Operaciones</div></div>
		
		<div id="botonAccionUser">
			
			<input type="submit" value="Hacer algo">
		
		</div>
		
		<form name="form" method="post" action="Controlador">
			<input type="submit" value="cerrar sesion">
			<input type="hidden" name="instruccion" value="logout">
		</form>
	
	</div>
		
	</div>
	
	<div id="parteAbajo">
	<div id="marcoTareas">
		<div id="fondoTabla">
			
			<table width="100%" border="2">
  <tbody>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>

			
		</div>
	</div>
	</div>
		
		
</body>
</html>