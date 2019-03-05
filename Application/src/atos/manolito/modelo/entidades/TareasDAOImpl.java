package proyectoAtos.Modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Entidades.Tareas;

public class TareasDAOImpl implements TareasDAO {

	private EntityManagerFactory emf = null;

	public TareasDAOImpl() {

		emf = Persistence.createEntityManagerFactory("PU-ML");

	}

	@Override
	public void create(Tareas tarea) {

		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(tarea);

			em.getTransaction().commit();

		} finally {

			if (em != null)
				em.close();
		}

	}

	@Override
	public Tareas read(String nombreTarea) {
		EntityManager em = emf.createEntityManager();

		try {

			return em.find(Tareas.class, nombreTarea);

		} finally {

			if (em != null)
				em.close();

		}
	}

	@Override
	public void update(Tareas tarea) {
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			em.merge(tarea);

			em.getTransaction().commit();

		} finally {

			if (em != null)
				em.close();

		}

	}

	@Override
	public void delete(String nombreTarea) {

		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			Tareas emp = em.getReference(Tareas.class, nombreTarea);

			em.remove(emp);

		} finally {

			if (em != null)
				em.close();

		}

	}

}
