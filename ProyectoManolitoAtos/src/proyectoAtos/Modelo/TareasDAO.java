package proyectoAtos.Modelo;

import java.util.List;

import proyectoAtos.Entidades.Tareas;

public interface TareasDAO {

	public void create(Tareas tarea);

	public Tareas read(String nombreTarea);

	public void update(Tareas tarea);

	public void delete(String nombreTarea);
	
	public List<Tareas> seleccionaTodos();

}
