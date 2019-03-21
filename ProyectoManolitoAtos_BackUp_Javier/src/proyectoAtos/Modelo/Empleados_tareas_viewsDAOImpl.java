package proyectoAtos.Modelo;

//import jav.util.List

import proyectoAtos.Entidades.Empleados_tareas_view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proyectoAtos.Entidades.EmpTareasId;

public class Empleados_tareas_viewsDAOImpl implements Empleados_tareas_viewsDAO{
	
	private EntityManagerFactory emf = null;
	
	public Empleados_tareas_viewsDAOImpl(){
		emf = Persistence.createEntityManagerFactory("PU-ML");
	}
	
	@Override
	public Empleados_tareas_view read(EmpTareasId id){
		EntityManager em = null;
		try{
			em = emf.createEntityManager();
			
			return em.find(Empleados_tareas_view.class, id);
		} finally{
			if(em!=null)
				em.close();
		}
	}
}