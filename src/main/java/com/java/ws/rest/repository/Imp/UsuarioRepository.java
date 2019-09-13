package com.java.ws.rest.repository.Imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.java.ws.rest.Model.Usuario;
import com.java.ws.rest.Utils.JPAEntityManager;
import com.java.ws.rest.constants.ConstantsWs;
import com.java.ws.rest.exceptions.ExceptionUsers;
import com.java.ws.rest.repository.IUsuarioRepository;
import com.java.ws.rest.services.Imp.WebService;

/***
 * implementacio de la interfaz del repositorio de la tabla usuario
 * @author juanaga
 *
 */
public class UsuarioRepository implements IUsuarioRepository {
	
	/***
	 * metodo para guardar usuarios en la base de datos
	 */
	public Integer saveUser(Usuario user) throws ExceptionUsers {
		//creamos el entityManager
		EntityManager entity = JPAEntityManager.getEntityManagerFactory().createEntityManager();
		try {
            // iniciamos la transaccion
			entity.getTransaction().begin();
			//asignamos el idUsuario een null para poder persistir el objeto
			user.setIdUsuario(null);
			entity.persist(user);
			//commit de la transaccion
			entity.getTransaction().commit();
        } catch (Exception ex) {
            // si es null hacemos el rollback
            if (entity.getTransaction() != null) {
            	entity.getTransaction().rollback();
            }
            ex.printStackTrace();
            //lanzamos exepcion personalizada
            throw new ExceptionUsers(ex.getMessage(),ex.getCause(),ConstantsWs.US01);
        } finally {
            // cerramos EntityManager
        	entity.close();
        }
		return user.getIdUsuario();
	}
	
	/***
	 * metodo para consultar usuario por id
	 */
	public Usuario getUser(String idUser) throws ExceptionUsers {
		EntityManager entity = JPAEntityManager.getEntityManagerFactory().createEntityManager();
		//query para consultar usuario por id
		String strQuery = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUser";
    	
    	// usamos el query,le mapeamos la clase Usuario y asignamos los parametros
    	TypedQuery<Usuario> tq = entity.createQuery(strQuery, Usuario.class);
    	tq.setParameter("idUser", Integer.parseInt(idUser));
    	List<Usuario> users;
    	try {
    		// obtenemos los resultados de la consulta
    		users = tq.getResultList();
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    		//lanzamos exepcion personalizada
    		throw new ExceptionUsers(ex.getMessage(),ex.getCause(),ConstantsWs.US01);
    	}
    	finally {
    		// cerramos EntityManager
        	entity.close();
    	}
    	//retornamos solo el primer resultado
    	if(users.size()>0) {
    		return users.get(0);
    	}else {
    		return null;
    	}
		
	}
}
