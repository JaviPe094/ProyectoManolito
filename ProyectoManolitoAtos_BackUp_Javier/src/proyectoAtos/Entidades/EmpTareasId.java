package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class EmpTareasId implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String empleado_id;
	private String tarea_id;
	
	public EmpTareasId(){
		
	}
	
	public EmpTareasId(String empleado_id,String tarea_id){
		this.empleado_id=empleado_id;
		this.tarea_id=tarea_id;
	}
	
	/*No estoy seguro de que sean necesarios estos getter
	y setter,los dejo aquí por si hiciesen falta en 
	el futuro.
	public String getEmpleado_id(){
		return this.empleado_id;
	}
	public String getTarea_id(){
		return this.tarea_id;
	}
	public void setEmpleado_id(String empleado){
		this.empleado_id=empleado;
	}
	public void setTarea_id(String tarea){
		this.tarea_id=tarea;
	}*/
	
}