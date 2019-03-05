package proyectoAtos.Modelo;

import proyectoAtos.Entidades.Empleados;

public interface EmpleadoDAO {
	
	public void create(Empleados empleado);
	
	public Empleados read(String dasEmpleado);
	
	public void update(Empleados empleado);
	
	public void delete(String dasEmpleado);

}