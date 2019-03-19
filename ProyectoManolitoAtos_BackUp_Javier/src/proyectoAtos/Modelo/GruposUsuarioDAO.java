package proyectoAtos.Modelo;

import proyectoAtos.Entidades.GruposUsuario;

public interface GruposUsuarioDAO{
	
	public void create(GruposUsuario gu);
	
	public GruposUsuario(String nombre);
	
	public void update(GruposUsuario gu);
	
	public void delete(String nombre);
}