package proyectoAtos.Modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proyectoAtos.Entidades.Empleados;

public class EmpleadoDAOImpl implements EmpleadoDAO {

	private EntityManagerFactory emf = null;

	//private int puntero;
	//private int maxPaginas;
	
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
	
	/*
	@NamedQuery(name="Empleados.filtrarNombre", query="SELECT e FROM Empleados e WHERE e.nombre= :name"),
	@NamedQuery(name="Empleados.filtrarApellido", query="SELECT e FROM Empleados e WHERE e.apellido= :name"),
	//@NamedQuery(name="Empleados.filtrarEmail", query="SELECT e FROM Empleados e WHERE e.email= :name"),
	@NamedQuery(name="Empleados.filtrarEstado", query="SELECT e FROM Empleados e WHERE e.estado= :name"),
	@NamedQuery(name="Empleados.filtrarPermisos", query="SELECT e FROM Empleados e WHERE e.permiso= :name")
	*/
	
	@Override
	public List<Empleados> readByGroup(String nombre){
		EntityManager em = null;
		Query query = null;
		
		try{
			em = emf.createEntityManager();
			
			query = em.createNamedQuery("Empleados.seleccionaGrupo");
			query.setParameter("grupo",nombre);
			
			return query.getResultList();
		} finally{
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public List<Empleados> filtrarNombre(String valor) {
		
		EntityManager em = emf.createEntityManager();
		Query query = null;
		
		try {
			
			query = em.createNamedQuery("Empleados.filtrarNombre");
			query.setParameter("name", valor);
			
			return query.getResultList();
			
		} finally {
			
			if (em != null) {
				
				em.close();
			}
			
		}
		
	}
	
	@Override
	public List<Empleados> filtrarApellido(String valor) {
		
		EntityManager em = emf.createEntityManager();
		Query query = null;
		
		try {
			
			query = em.createNamedQuery("Empleados.filtrarApellido");
			query.setParameter("name", valor);
			
			return query.getResultList();
			
		} finally {
			
			if (em != null) {
				
				em.close();
			}
			
		}
		
	}
	
	@Override
	public List<Empleados> filtrarEstado(String valor) {
		
		EntityManager em = emf.createEntityManager();
		Query query = null;
		
		try {
			
			query = em.createNamedQuery("Empleados.filtrarEstado");
			query.setParameter("name", new EstadoDAOImpl().read((char) valor.charAt(0)));
			
			return query.getResultList();
			
		} finally {
			
			if (em != null) {
				
				em.close();
			}
			
		}
		
	}
	
	@Override
	public List<Empleados> filtrarPermisos(String valor) {
		
		EntityManager em = emf.createEntityManager();
		Query query = null;
		
		try {
			
			query = em.createNamedQuery("Empleados.filtrarPermisos");
			query.setParameter("name", new PermisosDAOImpl().read(valor));
			
			return query.getResultList();
			
		} finally {
			
			if (em != null) {
				
				em.close();
			}
			
		}
		
	}
	
}
