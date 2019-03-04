package atos.manolito.modelo.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpleadoDAOImpl implements EmpleadoDAO {

	private EntityManagerFactory emf = null;
	
	public EmpleadoDAOImpl() {
		
		emf = Persistence.createEntityManagerFactory("PU-ML");
		
	}
	
	@Override
	public void create(Empleado empleado) {
		
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
	public Empleado read(String dasEmpleado) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			return em.find(Empleado.class, dasEmpleado);
			
		} finally {
			
			if (em != null)
				em.close();
			
		}
		
	}

	@Override
	public void update(Empleado empleado) {
		
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
			
			Empleado emp = em.getReference(Empleado.class, dasEmpleado);
			
			em.remove(emp);
			
		} finally {
			
			if (em != null)
				em.close();
			
		}
		
	}
	
}
