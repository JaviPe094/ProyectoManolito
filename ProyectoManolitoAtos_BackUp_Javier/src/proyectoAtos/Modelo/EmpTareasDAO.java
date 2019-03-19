package proyectoAtos.Modelo;

import java.util.List;

import proyectoAtos.Entidades.EmpTareas;

public interface EmpTareasDAO{
	
	public void create(EmpTareas emt);
	public void createByGroup(String tarea_id,String group_id);
	
	public EmpTareas read(EmpTareasId id);
	/*
	public List<EmpTareas> readByEmp(String emp_id);
	public List<EmpTareas> readByTar(String tar_id);
	No estoy seguro de que sean necesarios estos métodos, no tengo 
	precedentes que copiar y no puedo comprobar si funcionaría su 
	implementación.
	Necesitarían sus propias NamedQuery,creo,no debería ser demasiado
	complejo de implementar,aunque sería muy específico.
	*/
	public List<EmpTareas> readAll();
	
	public void update(EmpTareas emt);
	
	public void delete(EmpTareasId id);
}