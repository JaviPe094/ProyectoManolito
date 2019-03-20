package proyectoAtos.Modelo;

import java.util.List;

import proyectoAtos.Entidades.Empleados;

public interface EmpleadoDAO {
	
	public void create(Empleados empleado);
	
	public Empleados read(String dasEmpleado);
	
	public void update(Empleados empleado);
	
	public void delete(String dasEmpleado);
	
	public List<Empleados> readByGroup(String grupo);
	
	public List<Empleados> seleccionaTodos();
	
	public List<Empleados> filtrarNombre( String valor);
	
	public List<Empleados> filtrarApellido(String valor);
	
	public List<Empleados> filtrarEstado(String valor);
	
	public List<Empleados> filtrarPermisos(String valor);

}