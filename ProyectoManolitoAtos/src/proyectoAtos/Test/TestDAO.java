package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoDAO edao=new EmpleadoDAOImpl();
		TareasDAO tdao=new TareasDAOImpl();
		
		Empleados emp=edao.read("00a00b00c");
		
		System.out.println(emp);
	}

}
