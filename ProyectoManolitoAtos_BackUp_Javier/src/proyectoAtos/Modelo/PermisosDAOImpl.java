package proyectoAtos.Modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proyectoAtos.Entidades.Permisos;

public class PermisosDAOImpl implements PermisosDAO{
	
	private EntityManagerFactory emf = null;
	
	public PermisosDAOImpl() {

		emf = Persistence.createEntityManagerFactory("PU-ML");

	}
	
	@Override
	public void create(Permisos per) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(per);
			
			em.getTransaction().commit();
			
		}finally {
			em.close();
		}
	}

	@Override
	public Permisos read(String nombre) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=emf.createEntityManager();
			
			return em.find(Permisos.class, nombre);
					
		}finally {
			em.close();
		}
	}

	@Override
	public void update(Permisos per) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.merge(per);
			
			em.getTransaction().commit();
			
		}finally {
			em.close();
		}
	}

	@Override
	public void delete(String nombre) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=emf.createEntityManager();
			
			em.getTransaction().begin();
			
			Permisos per=em.getReference(Permisos.class, nombre);
			
			em.remove(per);
			
			em.getTransaction().commit();
			
		}finally {
			em.close();
		}
	}
	
	@Override
	public List<Permisos> seleccionaTodos() {
		
		EntityManager em = emf.createEntityManager();
		
		try {

			Query query = em.createNamedQuery("Permisos.seleccionaTodos");
			
			return query.getResultList();

		} finally {
			
			if (em != null) {

				em.close();
			}
		}
		
	}
	
}
