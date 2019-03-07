package proyectoAtos.Modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proyectoAtos.Entidades.Empleados;

public class EmpleadoDAOImpl implements EmpleadoDAO {

private EntityManagerFactory emf = null;
	
	public EmpleadoDAOImpl() {
		
		emf = Persistence.createEntityManagerFactory("PU-ML");
		
	}
	
	@Override
	public void create(Empleados empleado) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
		
			em.persist(empleado);
		
			em.getTransaction().commit();
		
		} finally {
			
			if (em != null)
				em.close();
		}
		
	}

	@Override
	public Empleados read(String dasEmpleado) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			return em.find(Empleados.class, dasEmpleado);
			
		} finally {
			
			if (em != null)
				em.close();
			
		}
		
	}

	@Override
	public void update(Empleados empleado) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.merge(empleado);
			
			em.getTransaction().commit();
				
		} finally {
			
			if (em != null)
				em.close();
			
		}
		
	}

	@Override
	public void delete(String dasEmpleado) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			Empleados emp = em.getReference(Empleados.class, dasEmpleado);
			
			em.remove(emp);
			
			em.getTransaction().commit();
			
		} finally {
			
			if (em != null)
				em.close();
			
		}
		
	}
	
	@Override
	public List<Empleados> seleccionaTodos() {
			
		EntityManager em = emf.createEntityManager();
		
		try {

			Query query = em.createNamedQuery("Empleados.seleccionaTodos");
			
			// Devolver lista entidades 
			return query.getResultList();

		} 
		
		finally {

			if (em != null) {
				
				em.close();
			}
		}
	
	}


	
}
