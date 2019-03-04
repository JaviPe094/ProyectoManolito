package atos.manolito.modelo.entidades;

public interface EmpleadoDAO {
	
	public void create(Empleado empleado);
	
	public Empleado read(String dasEmpleado);
	
	public void update(Empleado empleado);
	
	public void delete(String dasEmpleado);

}
