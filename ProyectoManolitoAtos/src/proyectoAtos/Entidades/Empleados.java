package proyectoAtos.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Empleados {
	
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
	
	@Column(name = "permisos")
	private char permisos;
	
	public Empleados() {
		
		
	}

	public Empleados(String das, String password, String nombre, String apellido, String email, char permisos) {
		super();
		this.das = das;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.permisos = permisos;
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

	public char getPermisos() {
		return permisos;
	}

	public void setPermisos(char permisos) {
		this.permisos = permisos;
	}

	// Debug
	
	@Override
	public String toString() {
		return "Empleado [das=" + das + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", permisos=" + permisos + "]";
	}
	
}
