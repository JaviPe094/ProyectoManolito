package proyectoAtos.Modelo;

//import jav.util.List

import proyectoAtos.Entidades.Empleados_tareas_view;
import proyectoAtos.Entidades.EmpTareasId;

public class Empleados_tareas_viewDAOImpl implements Empleados_tareas_viewDAO{
	
	private EntityManagerFactory emf = null;
	
	public Empleados_tareas_viewDAOImpl(){
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