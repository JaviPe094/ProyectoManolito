package proyectoAtos.Test;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;
import proyectoAtos.Modelo.EstadoDAO;
import proyectoAtos.Modelo.EstadoDAOImpl;
import proyectoAtos.Modelo.PermisosDAO;
import proyectoAtos.Modelo.PermisosDAOImpl;
import proyectoAtos.recursos.EmpleadoUtil;
import proyectoAtos.recursos.Recursos;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String enclaro = EmpleadoUtil.generatePass(10);
		
		System.out.println(EmpleadoUtil.crearSHA1(enclaro));
		System.out.println(EmpleadoUtil.crearSHA1(enclaro));
		
		EmpleadoDAO edao = new EmpleadoDAOImpl();
		EstadoDAO esdao = new EstadoDAOImpl();
		PermisosDAO pdao = new PermisosDAOImpl();
		
		
		Empleados test = new Empleados("006", EmpleadoUtil.generatePass(3), 
				"test", "test", "a@a.a", esdao.read(Recursos.NUEVO), pdao.read("admin"));
		
		edao.create(test);
		

	}

}
