package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERMISOS")

@NamedQueries({
	
	@NamedQuery(name="Permisos.seleccionaTodo", query="SELECT p FROM Permisos p")

})
public class Permisos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToMany(mappedBy="Permisos")
	@Column(name="NOMBRE")
	private String nombre;
	
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Permisos() {
		
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Permisos [nombre=" + nombre + "]";
	}
	
}
