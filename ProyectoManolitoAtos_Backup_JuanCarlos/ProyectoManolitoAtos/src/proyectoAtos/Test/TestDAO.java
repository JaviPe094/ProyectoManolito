package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;
import proyectoAtos.Recursos.EmpleadoUtil;

public class TestDAO {
	
	static EmpleadoDAO edao=new EmpleadoDAOImpl();
	static PermisosDAO pdao=new PermisosDAOImpl();
	static EstadoDAO estdao=new EstadoDAOImpl();
	static Estado estado = new Estado();
	static TareasDAO taredao = new TareasDAOImpl();
	
	public static void main(String[] args) {
		
		
		//datosPruebaEmpleadosInsert(5, "prueba_", edao, pdao.read("admin"), estdao.read('n'));
		
		//datosPruebaInsertTareas(5, "tarea_1", taredao, estado);
		
		pruebasEncriptacion();
		
	}
	
	public static void datosPruebaEmpleadosInsert(int cantidad,String cadena,
			EmpleadoDAO edao,Permisos per,Estado est) {
		Empleados emp=new Empleados();
		for(int i=1;i<=cantidad;i++) {
			emp.setDas(cadena+i);
			emp.setPassword(cadena+i);
			emp.setNombre(cadena+i);
			emp.setApellido(cadena+i);
			emp.setEmail(cadena+i);
			emp.setEstado(est);
			emp.setPermiso(per);
			edao.create(emp);
		}
	}
	
	public static void datosPruebaInsertTareas(int cantidad,String cadena,
			TareasDAO tdao,Estado est) {
		Tareas tar=new Tareas();
		for(int i=1;i<=cantidad;i++) {
			tar.setNombre(cadena+i);
			tar.setDescripcion(cadena+i);
			tar.setEstado(estado.getEstado());
			tdao.create(tar);
			System.out.println("Insertada tarea: "+tar);
		}
	}
	
	
	public static void pruebasEncriptacion() {
		
		
		/*
		System.out.println(EmpleadoUtil.generatePass(10));
		System.out.println(EmpleadoUtil.generatePass(20));
		System.out.println(EmpleadoUtil.generatePass(15));
		System.out.println(EmpleadoUtil.generatePass(5));
		*/
		
		String enClaro = "contrasenagg";
		
		String encriptado = EmpleadoUtil.encriptaString(enClaro);
		
		System.out.println(encriptado);
		String desencriptado = EmpleadoUtil.desencriptaString(encriptado);
		
		System.out.println(desencriptado);
		
		
		//datosPruebaInsertTareas(10, "tarea_", tdao, esdao.read('a'));

	}
	
	
}
