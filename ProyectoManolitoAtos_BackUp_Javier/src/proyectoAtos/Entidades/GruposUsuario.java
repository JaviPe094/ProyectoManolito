package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *Cosas necesarias para completar la tarea 4:
 *Cambios en base de datos:registrados en manolito_db.sql.Actualizados los "CREATE TABLE" y
 * añadidos "ALTER TABLE".
 *Nuevas entidades java de JPA:Hecho,pendiente de testeo.
 *DAO de cada entidad nueva:Hecho,pendiente de testeo.
 *Vista jsp de asignación de tareas(insercion en EmpTareas):Hecho,pendiente de testeo con bbdd
 *Cambiar vista de Tareas de los empleados normales para que solo muestre las Tareas que NO estén asignadas a un empleado
 * y las que estén asignadas a un empleado en concreto:Pendiente.
 */
@Entity
@Table(name="GRUPOS_USUARIO")
public class GruposUsuario implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToMany(mappedBy="GruposUsuario")
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public GruposUsuario(){
		
	}
	
	public GruposUsuario(String nombre,String descripcion){
		this.nombre=nombre;
		this.descripcion=descripcion;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
}