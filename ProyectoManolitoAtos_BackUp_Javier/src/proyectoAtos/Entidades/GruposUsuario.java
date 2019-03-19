package proyectoAtos.Entidades;

import java.io.Serializable;

@Entity
@Table(name="GRUPOS_USUARIO")
public class GruposUsuario implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
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