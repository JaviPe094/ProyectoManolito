package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class EmpTareasId implements Serializable{
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empleado_id == null) ? 0 : empleado_id.hashCode());
		result = prime * result + ((tarea_id == null) ? 0 : tarea_id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpTareasId other = (EmpTareasId) obj;
		if (empleado_id == null) {
			if (other.empleado_id != null)
				return false;
		} else if (!empleado_id.equals(other.empleado_id))
			return false;
		if (tarea_id == null) {
			if (other.tarea_id != null)
				return false;
		} else if (!tarea_id.equals(other.tarea_id))
			return false;
		return true;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	String empleado_id;
	String tarea_id;
	
	public EmpTareasId(){
		
	}

	public EmpTareasId(String empleado_id, String tarea_id) {
		this.empleado_id = empleado_id;
		this.tarea_id = tarea_id;
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