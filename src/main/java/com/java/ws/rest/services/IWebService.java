package com.java.ws.rest.services;

import com.java.ws.rest.Model.Usuario;
import com.java.ws.rest.responses.ResponsesUsers;

/***
 * Interfaz para la comunicacion con la capa de negocio
 * @author juanaga
 *
 */
public interface IWebService {
	/***
	 * metodo para crear usuarios
	 * @param user
	 * @return
	 */
	public ResponsesUsers newUser(Usuario user);
	
	/***
	 * metodo para consultar usuarios
	 * @param idUser
	 * @return
	 */
	public ResponsesUsers getUser(String idUser);
}
