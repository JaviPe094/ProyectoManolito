<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function FormCommand_Change(command){
		var form_submit=document.getElementById("botonEnviar");
		var form_command=document.getElementById("Command");
		form_command.value=command;
        form_submit.value=command;
		if(command.localeCompare("invalid")==0)
			form_submit.disabled=true;
		else
			form_submit.disabled=false;
	}
	function ToggleUserGroup(){
		//var form_submit=document.getElementById("botonEnviar");
		var selector=document.getElementById("seleccion");
		var cadena=selector.options[selector.selectedIndex].value;
		if(cadena.localeCompare("usuario")==0){
			document.getElementById("default").style.display="none";
			//document.getElementById("default").disabled=true;
			document.getElementById("usuarios").style.display="block";
			document.getElementById("usuarios").disabled=false;
			document.getElementById("grupos").style.display="none";
			document.getElementById("grupos").disabled=true;
			FormCommand_Change("asignar_tarea_usuario");
			myFunction();
		}else if(cadena.localeCompare("grupo")==0){
			document.getElementById("default").style.display="none";
			//document.getElementById("default").disabled=true;
			document.getElementById("usuarios").style.display="none";
			document.getElementById("usuarios").disabled=true;
			document.getElementById("grupos").style.display="block";
			document.getElementById("grupos").disabled=false;
			FormCommand_Change("asignar_tarea_grupo");
			myFunction();
		}else{
			document.getElementById("default").style.display="block";
			//document.getElementById("default").disabled=true;
			document.getElementById("usuarios").style.display="none";
			document.getElementById("usuarios").disabled=true;
			document.getElementById("grupos").style.display="none";
			document.getElementById("grupos").disabled=true;
			FormCommand_Change("invalid");
			myFunction();
		}
	}
	
	function myFunction() {
		  var x = document.getElementById("Command").value;
		  document.getElementById("demo").innerHTML = "Command: " + x;
		}
	</script>
<script type="text/javascript" src="js/Timeout.js"></script>
<style>
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
	<h2>Asignar tarea</h2>
	<form action="#">
		<table width="50%">
  <tbody>
    <tr>
      <td>Tarea</td>
      <td><input type="text" name="nombre" id="nombre" value="Tarea a asignar" readonly></td>
    </tr>
	  
    <tr>
      <td>Usuarios/Grupos</td>
      <td>
	   <select id="seleccion" onchange="ToggleUserGroup()"><!--esto deberÃ­a funcionar de alguna manera-->
		 <option value="null" selected>Elige una opción</option>
		 <option value="usuario">Usuarios</option>
		 <option value="grupo">Grupos</option>
	   </select>
	  </td>
    </tr>
	  
    <tr>
     <td>Selección</td>
	 <td>	 
 		<select id="default" name="default" style="display:block" disabled>
 			<option selected value="default">invalid</option>
 		</select>
 		<select id="usuarios" name="usuario" style="display:none" disabled>
	   		<option value="user1" selected>user1</option>
      		 <option value="user2">user2</option>
       	</select>
  		<select id="grupos" name="grupo" style="display:none" disabled>
	   		<option value="group1" selected>group1</option>
       		<option value="group2">group2</option>
       	</select>
       </td>
       </tr>
       </tbody>
       </table>

<input id="botonEnviar" type="submit" value="invalid" disabled>
<input type="hidden" id="Command" name="instruccion" value="funcion_asignar_tareas">
<input type="hidden" name="tarea_aux" value="blabla">
</form>


</body>
</html>