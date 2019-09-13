package com.java.ws.rest.Utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/***
 * Clase para crear el EntityManagerFactory
 * @author juanaga
 *
 */
public class JPAEntityManager {
	private static final String PERSISTENCE_UNIT_NAME = "restPersistence";
	private static EntityManagerFactory factory;

	/***
	 * Metodo para crear el EntityManagerFactory
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		//si el EntityManagerFactory es null lo creamos
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;				
	}
	/***
	 * metodo para cerrar el EntityManagerFactory
	 */
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}
}