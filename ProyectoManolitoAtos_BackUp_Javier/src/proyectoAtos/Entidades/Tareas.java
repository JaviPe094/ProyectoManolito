package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas")

@NamedQueries({
	
	@NamedQuery(name="Tareas.seleccionaTodos", query="SELECT t FROM Tareas t")
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
	
	@ManyToOne
	@JoinColumn(name = "estado")
	private Estado estado;

	public Tareas() {
		
	}
	public Tareas(String nombre, String descripcion, Estado estado) {
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tareas [nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

	
	
	
}
