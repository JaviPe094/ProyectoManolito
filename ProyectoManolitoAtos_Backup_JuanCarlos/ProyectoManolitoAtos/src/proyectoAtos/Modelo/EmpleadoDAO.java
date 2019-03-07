package proyectoAtos.Modelo;

import java.util.List;

import proyectoAtos.Entidades.Empleados;

public interface EmpleadoDAO {
	
	public void create(Empleados empleado);
	
	public Empleados read(String dasEmpleado);
	
	public void update(Empleados empleado);
	
	public void delete(String dasEmpleado);
	
	public List<Empleados> seleccionaTodos();

}