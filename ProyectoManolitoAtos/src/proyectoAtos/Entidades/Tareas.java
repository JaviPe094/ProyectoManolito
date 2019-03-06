package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas")

@NamedQueries({
	
	@NamedQuery(name="Tareas.seleccionaTodo", query="SELECT t FROM Tareas t")

})


public class Tareas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private char estado;

	public Tareas() {
		
	}
	public Tareas(String nombre, String descripcion, char estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tareas [nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

	
	
	
}
