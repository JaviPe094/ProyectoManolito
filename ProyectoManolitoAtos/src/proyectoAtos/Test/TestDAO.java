package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoDAO edao=new EmpleadoDAOImpl();
		TareasDAO tdao=new TareasDAOImpl();
		PermisosDAO pdao=new PermisosDAOImpl();
		EstadoDAO esdao = new EstadoDAOImpl();
		
		Permisos per=pdao.read("b");
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
	}

}
