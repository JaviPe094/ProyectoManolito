package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERMISOS")
public class Permisos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToMany(mappedBy="Permisos")
	@Column(name="NOMBRE")
	private String nombre;
	
	public Permisos() {
		
	}
	
}
