package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;
import proyectoAtos.recursos.EmpleadoUtil;

public class TestDAO {

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
		
		//datosPruebaEmpleadosInsert(5,"prueba1_",edao,per,est);
		
		System.out.println(EmpleadoUtil.generatePass(10));
		System.out.println(EmpleadoUtil.generatePass(20));
		System.out.println(EmpleadoUtil.generatePass(15));
		System.out.println(EmpleadoUtil.generatePass(5));
	}

}
