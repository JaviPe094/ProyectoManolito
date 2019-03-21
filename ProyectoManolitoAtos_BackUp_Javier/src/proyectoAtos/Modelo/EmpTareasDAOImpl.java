package proyectoAtos.Modelo;

import proyectoAtos.Entidades.EmpTareas;
import proyectoAtos.Entidades.EmpTareasId;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmpTareasDAOImpl implements EmpTareasDAO{
	
	private EntityManagerFactory emf = null;
	
	/*private int puntero;
	private int maxPaginas;*/
	
	public EmpTareasDAOImpl(){
		emf = Persistence.createEntityManagerFactory("PU-ML");
	}
	
	@Override
	public void create(EmpTareas emt){
		EntityManager em=null;
		
		try {
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(emt);
			
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public void createByGroup(String tarea_id,String group_id){
		EntityManager em=null;
		
		try {
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			/*
			*Como no estoy seguro de si se puede hacer una sentencia INSERT
			*con una NamedQuery de JPA,dejo por aquí esta solución alterna
			*que encontré. Utilizando una Native Query,deberíamos poder 
			*usar el dialecto propio de la bd,ya sea oracle,mysql,etc...
			*para formar cualquier consulta que queramos realizar,como
			*en este caso,que lo usaríamos para hacer un INSERT INTO SELECT
			*/em.createNativeQuery("INSERT INTO EMPLEADOS_TAREAS(et.empleado_id,et.tarea_id) et SELECT e.das,? FROM Empleados e WHERE e.grupo_id=?")
			.setParameter(1,new TareasDAOImpl().read(tarea_id))
			.setParameter(2,group_id)
			.executeUpdate();
			
			
			/*Query query = em.createNamedQuery("EmpTareas.registraGrupo");
			
			query.setParameter("tarea",tarea_id);
			query.setParameter("grupo",group_id);
			
			query.executeUpdate();*/
			
			em.getTransaction().commit();
		} finally{
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public EmpTareas read(EmpTareasId id){
		EntityManager em = null;
		
		try{
			em = emf.createEntityManager();
			
			return em.find(EmpTareas.class, id);
		} finally{
			if(em!=null)
				em.close();
		}
	}
	
	@Override
	public List<EmpTareas> readAll(){
		EntityManager em = null;
		
		try{
			em = emf.createEntityManager();
			
			Query query = em.createNamedQuery("EmpTareas.readAll");
			
			return query.getResultList();
		}finally{
			 if(em!=null)
				 em.close();
		}
	}
	
	@Override
	public void update(EmpTareas emt){
		EntityManager em = null;
		
		try{
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.merge(emt);
			
			em.getTransaction().commit();
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
	
	@Override
	public void delete(EmpTareasId id){
		EntityManager em = null;
		
		try{
			
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			EmpTareas emt = em.getReference(EmpTareas.class, id);
			
			em.remove(emt);
			
			em.getTransaction().commit();
		}finally{
			if(em!=null)
				em.close();
		}
	}
	
	
}