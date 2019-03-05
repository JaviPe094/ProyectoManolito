package atos.manolito.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Clase de utilidad para crear Session de Hibernate basada
 * en el fichero de configuracion
 * 
 * Patrón Singleton (Una sola instancia de la clase)
 */
public class HibernateUtils {

	private final static SessionFactory SESSION_FACTORY =
			buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Cargar fichero de configuracion predeterminado
			// de Hibernate (hibernate.cfg.xml) y devolver SessionFactory
			// que tiene configurado
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable t) {
			System.out.println("Error carga fichero configuracion Hibernate");
			
			throw new ExceptionInInitializerError(t);
		}
	}
	
	/*
	 * Método para devolucion de la instancia SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	/*
	 * Método para liberar cache y pool de conexiones de Hibernate
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}
}
