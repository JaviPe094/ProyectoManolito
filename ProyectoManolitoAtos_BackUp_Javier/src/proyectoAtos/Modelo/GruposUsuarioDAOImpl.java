package proyectoAtos.Modelo;

import proyectoAtos.Entidades.GruposUsuario;
//import java.util.List;//si hacemos un readAll se utilizará

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.NamedQuery;//si hacemos un readAll se utilizará
import javax.persistence.Persistence;
//import javax.persistence.Query;//si hacemos un readAll se utilizará

public class GruposUsuarioDAOImpl implements GruposUsuarioDAO{
	
	private EntityManagerFactory emf = null;
	
	public GruposUsuarioDAOImpl(){
		emf = Persistence.createEntityManagerFactory("PU-ML");
	}
	
	@Override
	public void create(GruposUsuario gu){
		EntityManager em=null;
		
		try{
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(gu);
			
			em.getTransaction().commit();
		}finally{
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public GruposUsuario read(String nombre){
		EntityManager em = null;
		
		try{
			em = emf.createEntityManager();
			
			return em.find(GruposUsuario.class, nombre);
		}finally{
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public void update(GruposUsuario gu){
		EntityManager em = null;
		
		try{
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.merge(gu);
			
			em.getTransaction().commit();
		}finally{
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public void delete(String nombre){
		EntityManager em = null;
		
		try{
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			GruposUsuario gu = em.getReference(GruposUsuario.class, nombre);
			
			em.remove(gu);
			
			em.getTransaction().commit();
		}finally {
			if(em!=null)
				em.close();
		}
	}
}