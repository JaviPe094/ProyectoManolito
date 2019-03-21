package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="Empleados_tareas_view")
public class Empleados_tareas_view implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Column(name="DAS")
	private String das;
	
	@Column(name="TAREA")
	private String tarea;*/
	//Estas 2 variables se pueden traducir en la siguiente,la cual contaría 
	//como PK a la hora de leer esta vista con los métodos de JPA.
	@EmbeddedId
	EmpTareasId id;
	
	@Column(name="empleado")
	private String emp;
	
	@Column(name="permiso")
	private Permisos perm;
	
	@Column(name="empleado_estado")
	private Estado emp_estado;
	
	@Column(name="tarea_estado")
	private Estado tar_estado;
	
	public Empleados_tareas_view(){
		
	}
	
	public Empleados_tareas_view(String das,String tarea,String emp,
		Permisos perm,Estado emp_estado,Estado tar_estado){
		 this.id=new EmpTareasId(das,tarea);
		 this.emp=emp;
		 this.perm=perm;
		 this.emp_estado=emp_estado;
		 this.tar_estado=tar_estado;
	}
	
	

	public EmpTareasId getId() {
		return id;
	}

	public String getEmp(){
		return this.emp;
	}
	public Permisos getPerm(){
		return this.perm;
	}
	public Estado getEmp_estado(){
		return this.emp_estado;
	}
	public Estado getTar_estado(){
		return this.tar_estado;
	}
	
	public void setId(EmpTareasId id) {
		this.id = id;
	}
	
	public void setEmp(String emp){
		this.emp=emp;
	}
	public void setPerm(Permisos perm){
		this.perm=perm;
	}
	public void setEmp_estado(Estado emp_estado){
		this.emp_estado=emp_estado;
	}
	public void setTar_estado(Estado tar_estado){
		this.tar_estado=tar_estado;
	}
}