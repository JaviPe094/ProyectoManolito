package proyectoAtos.Modelo;

import java.util.List;

import proyectoAtos.Entidades.Permisos;

public interface PermisosDAO {
	
	public void create(Permisos per);
	
	public Permisos read(String nombre);
	
	public void update(Permisos per);
	
	public void delete(String nombre);
	
	public List<Permisos> seleccionaTodos();

}
