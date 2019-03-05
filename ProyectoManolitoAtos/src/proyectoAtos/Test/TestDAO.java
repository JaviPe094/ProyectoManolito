package proyectoAtos.Test;

import proyectoAtos.Entidades.*;
import proyectoAtos.Modelo.*;

public class TestDAO {
	EmpleadoDAO edao=new EmpleadoDAOImpl();
	PermisosDAO pdao=new PermisosDAOImpl();
	
	Empleados emp=new Empleados();
	Permisos per=new Permisos();
	
	emp=edao.read("00a00b00c");
}
