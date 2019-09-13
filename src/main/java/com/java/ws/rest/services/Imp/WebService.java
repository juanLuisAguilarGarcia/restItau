package com.java.ws.rest.services.Imp;

import org.apache.log4j.Logger;

import com.java.ws.rest.Model.Usuario;
import com.java.ws.rest.constants.ConstantsWs;
import com.java.ws.rest.exceptions.ExceptionUsers;
import com.java.ws.rest.repository.Imp.UsuarioRepository;
import com.java.ws.rest.responses.ResponsesUsers;
import com.java.ws.rest.services.IWebService;

/***
 * implementacion de la interfaz IWebService. Servicio para comunicar la capa de negocio con la la capa de datos y la capa externa
 * @author juanaga
 *
 */
public class WebService implements IWebService {
	
	final static Logger LOG = Logger.getLogger(WebService.class);

	private UsuarioRepository usuarioRepository;
	
	public WebService() {
		usuarioRepository = new UsuarioRepository();
	}

	/***
	 * metodo para consultar usuarios. Registro de errores en el log
	 */
	public ResponsesUsers newUser(Usuario user) {
		ResponsesUsers responsesUsers = new ResponsesUsers();
		try {
			//asignamos los valores para la respuestas y consultamos el usuario
			responsesUsers.setCode(ConstantsWs.US01);
			responsesUsers.setMessage(ConstantsWs.CREATED_USER_OK);
			responsesUsers.setDatos(("{ id_usuario : "  + getUsuarioRepository().saveUser(user).toString() + " }"));
		}catch (ExceptionUsers ex) {
			//si hay error arrojamos la respuesta en el mismo formato pero con mensaje de error
			LOG.error(ex.getMessage());
			responsesUsers.setCode(ConstantsWs.US01);
			responsesUsers.setMessage(ex.getMessage());
			responsesUsers.setDatos("0");
		}
		return responsesUsers;
	}
	
	/***
	 * metodo para consultar usuarios por id
	 */
	public ResponsesUsers getUser(String idUser) {
		ResponsesUsers responsesUsers = new ResponsesUsers();
		try {
			//consultamos el usuario
			Usuario user = getUsuarioRepository().getUser(idUser);
			//asignamos los valores a la respuesta
			responsesUsers.setCode(ConstantsWs.US01);
			if(user != null && user.getIdUsuario() != null) {
				responsesUsers.setMessage(ConstantsWs.FOUND_USER_OK);
		        responsesUsers.setDatos(user.toString());
			}
			else {
				//si el usuario no existe. asignamos la respuesta correspondiente 
				responsesUsers.setMessage(ConstantsWs.NOTFOUND_USER);
				responsesUsers.setDatos("");
			}
		}catch (ExceptionUsers ex) {
			//enviamos respuesta de error
			LOG.error(ex.getMessage());
			responsesUsers.setCode(ConstantsWs.US01);
			responsesUsers.setMessage(ex.getMessage());
			responsesUsers.setDatos(ConstantsWs.NOT_DATA);
		}
		return responsesUsers;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
