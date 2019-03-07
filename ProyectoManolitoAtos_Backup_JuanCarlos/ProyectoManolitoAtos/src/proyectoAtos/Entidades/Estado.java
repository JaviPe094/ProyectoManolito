package proyectoAtos.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ESTADOS")
public class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToMany(mappedBy="Estado")
	@Column(name="ESTADO")
	private char est;
	
	@Column(name="descipcion")
	private String descripcion;

	public Estado() {
		
	}
	
	
	public Estado(char est) {
		
		this.est = est;
		
	}


	/**
	 * @return the estado
	 */
	public char getEstado() {
		return est;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(char estado) {
		this.est = estado;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Estado [est=" + est + ", descripcion=" + descripcion + "]";
	}
	
	
}
