package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="EMPLEADOS_TAREAS")

/**Importante, las NamedQueries NO pueden ser INSERT,de manera que habrá que utilizar una 
 * query nativa para poder hacer esta operación
 * @NamedQueries({
	
	@NamedQuery(name="EmpTareas.registraGrupo", query="INSERT INTO EMPLEADOS_TAREAS(et.empleado_id,et.tarea_id) et SELECT e.das,:tarea FROM Empleados e WHERE e.grupo_id=:grupo")
	
})*/
public class EmpTareas implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId 
	private EmpTareasId id;
	
	public EmpTareas(){
		
	}
	
	public EmpTareas(EmpTareasId id){
		this.id=id;
	}
	
	public EmpTareasId getId() {
		return this.id;
	}
	
	public void setId(EmpTareasId id){
		this.id=id;
	}
	
	/*public EmpTareas(String empleado_id,String tarea_id){
		this.id=new EmptTareasId(empleado_id,tarea_id);
	}*/
	
	/**@Id
	@Column(name="empleado_id")
	private String empleado_id;
	
	@Id
	@Column(name="tarea_id")
	private String tareaId;*/
}