package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;
import proyectoAtos.recursos.EmpleadoUtil;

public class TestDAO {

	public static void datosPruebaInsertEmpleados(int cantidad,String cadena,
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
			System.out.println("Insertado Empleado: "+emp);
		}
	}
	
	public static void datosPruebaInsertTareas(int cantidad,String cadena,
			TareasDAO tdao,Estado est) {
		Tareas tar=new Tareas();
		for(int i=1;i<=cantidad;i++) {
			tar.setNombre(cadena+i);
			tar.setDescripcion(cadena+i);
			tar.setEstado(est);
			tdao.create(tar);
			System.out.println("Insertada tarea: "+tar);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoDAO edao=new EmpleadoDAOImpl();
		TareasDAO tdao=new TareasDAOImpl();
		PermisosDAO pdao=new PermisosDAOImpl();
		EstadoDAO esdao = new EstadoDAOImpl();
		
		Permisos per=pdao.read("admin");
		Estado est = esdao.read('i');
		
		Empleados emp=edao.read("00a00b00c");
		
		emp= new Empleados("001002003", "prueba2", "prueba2", "prueba23", "prueba2@pr.pr", est, per);
		
		edao.create(emp);
		
		System.out.println(edao.read("001002003"));
		
		emp.setNombre("Javier");
		
		edao.update(emp);
		
		System.out.println(edao.read("001002003"));
		
		edao.delete("001002003");
		
		System.out.println(emp);
		
		//datosPruebaInsertEmpleados(5,"prueba1_",edao,per,est);
		
//		System.out.println(EmpleadoUtil.generatePass(10));
//		System.out.println(EmpleadoUtil.generatePass(20));
//		System.out.println(EmpleadoUtil.generatePass(15));
//		System.out.println(EmpleadoUtil.generatePass(5));
		
<<<<<<< HEAD
		/*
		System.out.println(EmpleadoUtil.generatePass(10));
		System.out.println(EmpleadoUtil.generatePass(20));
		System.out.println(EmpleadoUtil.generatePass(15));
		System.out.println(EmpleadoUtil.generatePass(5));
		*/
		
		String enClaro = "contraseña";
		
		String encriptado = EmpleadoUtil.encriptaString(enClaro);
		
		System.out.println(encriptado);
		
		System.out.println(EmpleadoUtil.desencriptaString(encriptado));
		

=======
		datosPruebaInsertTareas(10, "tarea_", tdao, esdao.read('a'));
>>>>>>> d6d5d26d8c27dd9d5474d6d53b243aa7a9640ba0
	}

}
