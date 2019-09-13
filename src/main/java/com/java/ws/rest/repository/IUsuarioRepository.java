package com.java.ws.rest.repository;

import com.java.ws.rest.Model.Usuario;
import com.java.ws.rest.exceptions.ExceptionUsers;

/***
 *  Interfaz del repositorio de la tabla usuario
 * @author juanaga
 *
 */
public interface IUsuarioRepository {

    /***
     * metodo para persistir usuarios en la base de datos
     * @param user
     * @return
     * @throws ExceptionUsers
     */
	public Integer saveUser(Usuario user) throws ExceptionUsers;
	
	/***
	 * metodo para consultar usuarios por id en la base de datos
	 * @param idUser
	 * @return
	 * @throws ExceptionUsers
	 */
	public Usuario getUser(String idUser) throws ExceptionUsers;
}
