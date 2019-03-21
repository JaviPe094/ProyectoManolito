<%@page import="proyectoAtos.Entidades.Empleados" %>
<%@page import="proyectoAtos.Entidades.GruposUsuario" %>
<%@page import="proyectoAtos.Entidades.Estado" %>
<%@page import="proyectoAtos.Entidades.Permisos" %>
<%@page import="java.util.List"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Asignación de Tareas</title>
	<script type="text/javascript" src="js/Timeout.js"></script>
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
		}else if(cadena.localeCompare("grupo")==0){
			document.getElementById("default").style.display="none";
			//document.getElementById("default").disabled=true;
			document.getElementById("usuarios").style.display="none";
			document.getElementById("usuarios").disabled=true;
			document.getElementById("grupos").style.display="block";
			document.getElementById("grupos").disabled=false;
			FormCommand_Change("asignar_tarea_grupo");
		}else{
			document.getElementById("default").style.display="block";
			//document.getElementById("default").disabled=true;
			document.getElementById("usuarios").style.display="none";
			document.getElementById("usuarios").disabled=true;
			document.getElementById("grupos").style.display="none";
			document.getElementById("grupos").disabled=true;
			FormCommand_Change("invalid");
		}
	}
	</script>
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
<%
	//Obtenemos los usuarios y los grupos que se mostrarán en los selectores
	//del formulario de más abajo en la vista
	String cadena="prueba_";
	//List<Empleados> listaEmpleados = (List<Empleados>) request.getAttribute("LISTAREMPLEADOS");
	//Datos de prueba(para testeo pre-bbdd)
	Empleados em = new Empleados();
	List<Empleados> listaEmpleados=null;
	for(int i=0;i<10;i++){
		em.setDas(cadena+i);
		em.setPassword(cadena+i);
		em.setNombre(cadena+i);
		em.setApellido(cadena+i);
		em.setEmail(cadena+i);
		em.setEstado(new Estado('n',"nuevo usuario"));
		em.setPermiso(new Permisos());
		em.setGrupoId(new GruposUsuario());
		listaEmpleados.add(em);
		System.out.println("Insertado Empleado: "+em);
	}
	//Datos de prueba(para testeo pre-bbdd)
	//List<GruposUsuario> listaGrupos = (List<GruposUsuario>) request.getAttribute("LISTARGRUPOS");
%>
</head>
<body onkeypress="reiniciarTimeout(60)" onmousemove="reiniciarTimeout(60)" onload="iniciarTimeout(60)">
	<div>
	<h2>Asignar tarea</h2>
	<form action="Controlador" method="post">
		<table width="50%">
  <tbody>
    <tr>
      <td>Tarea</td>
      <td><input type="text" name="nombre" id="nombre" value="${nombre}" readonly></td>
    </tr>
	  
    <tr>
      <td>Usuario o Grupo</td>
      <td>
	   <select id="seleccion" onchange="ToggleUserGroup()"><!--esto debería funcionar de alguna manera-->
		<option value="usuario">Usuarios</option>
		<option value="grupo">Grupos</option>
	   </select>
	  </td>
    </tr>
	  
    <tr>
	 <td>
	 <select id="default" name="default" style="display:block" disabled>
 			<option selected value="default">invalid</option>
 		</select>
	   <select id="usuarios" name="usuario" style="display:none">
	   <option value="none" selected></option>
		<% for(Empleados emp : listaEmpleados){ %>
			<option value="<%=emp.getDas()%>"><%=emp.getDas()%></option>
		<%}%>
	   </select>
	   <select id="grupos" name="grupo" style="display:none">
		<% for(Empleados emp2 : listaEmpleados){  /*for(GruposUsuario gu : listaGrupos){*/%>
			<option value="<%=emp2.getNombre()%>"><%=emp2.getNombre()%>----2</option>
		<%}%>
	   </select>
	  </td>
	 <!--<select id="seleccion" onchange="ToggleOptions('seleccion')">
      <td>ESTADO</td>
      <td><input type="text" name="estado" id="estado" value="${estado}" required></td>
	 </select> -->
    </tr>
  </tbody>
</table>
		
		<input id="botonEnviar" type="submit" value="Actualizar" disabled="true">
<!-- 		<input type="hidden" name="das" id="das" value="${nombre}"> -->
		<input type="hidden" id="Command" name="instruccion" value="funcion_asignar_tareas">
		<input type="hidden" name="tarea_aux" value="${nombre}">
	</form>
	</div>
	
</body>
</html>