package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;

public class TestDAO {
	
	public static void main(String[] args) {
		
		EmpleadoDAO edao=new EmpleadoDAOImpl();
		PermisosDAO pdao=new PermisosDAOImpl();
		EstadoDAO estdao=new EstadoDAOImpl();
		
		Empleados emp=edao.read("00a00b00c");
		Permisos per=pdao.read("Administrador");
		Estado est=new Estado();
		
		est=estdao.read('n');
		
		System.out.println(per);
		
//		per.setNombre("Empleado");

//		pdao.create(per);
//		
//		System.out.println(pdao.read("Empleado"));
		
//		per.setNombre("Usuario");
//		
//		pdao.update(per);
		
//		System.out.println(pdao.read("Usuario"));
//		
//		pdao.delete("Usuario");
		
		emp=new Empleados("001002003", "prueba2", "prueba2", "prueba23", "prueba2@pr.pr", est , per);
		
		edao.create(emp);
		
		System.out.println(edao.read("001002003"));
		
		emp.setNombre("Javier");
		emp.setEstado(estdao.read('a'));
		
		edao.update(emp);
		
		System.out.println(edao.read("001002003"));
		
		edao.delete("001002003");
	}
	
	
}
