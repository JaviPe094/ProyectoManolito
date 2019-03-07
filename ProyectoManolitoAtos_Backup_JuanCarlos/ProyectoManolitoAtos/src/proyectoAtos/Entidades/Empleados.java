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
@Table(name = "EMPLEADOS")

@NamedQueries({

	@NamedQuery(name="Empleados.seleccionaTodos", query="SELECT e FROM Empleados e")
	
})
public class Empleados implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "das")
	private String das;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "estado")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "permiso")
	private Permisos permiso;
	
	public Empleados() {
		
		
	}

	public Empleados(String das, String password, String nombre, String apellido, String email, Estado est,
			Permisos per) {
		super();
		this.das = das;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.estado = est;
		this.permiso = per;
	}

	public String getDas() {
		return das;
	}

	public void setDas(String das) {
		this.das = das;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado est) {
		this.estado = est;
	}

	public Permisos getPermiso() {
		return permiso;
	}

	public void setPermiso(Permisos per) {
		this.permiso = per;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Debug
	
	@Override
	public String toString() {
		return "Empleados [das=" + das + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", est=" + estado.getEstado() + ", per=" + permiso.getNombre() + "]";
	}
	
}
