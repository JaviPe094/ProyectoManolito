package proyectoAtos.Modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Entidades.Estado;

public class EstadoDAOImpl implements EstadoDAO {

	private EntityManagerFactory emf = null;
	
	public EstadoDAOImpl() {
		
		emf = Persistence.createEntityManagerFactory("PU-ML");
		
	}

	@Override
	public Estado read(char est) {
		// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
		
		try {
			
			return em.find(Estado.class, est);
			
		} finally {
			
			if (em != null)
				em.close();
			
		}
	}

}
