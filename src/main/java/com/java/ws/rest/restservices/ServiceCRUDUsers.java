package com.java.ws.rest.restservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.java.ws.rest.Model.Usuario;
import com.java.ws.rest.constants.ConstantsWs;
import com.java.ws.rest.responses.ResponsesUsers;
import com.java.ws.rest.services.IWebService;
import com.java.ws.rest.services.Imp.WebService;

/***
 * Endpoint del servicio para el CRUD de la tabla usuario
 * @author juanaga
 *
 */
@Path("/Users")
public class ServiceCRUDUsers {
	
	private WebService webService = new WebService();

	/***
	 * servicio web para crear nuevos usuarios
	 * @param user
	 * @return
	 */
	@POST
	@Path("/NewUser")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResponsesUsers createUsers(Usuario user)  {
		return webService.newUser(user);
	}
	
	/***
	 * servicio web para consultar usuarios por id
	 * @param idUser
	 * @return
	 */
	@GET
	@Path("/GetUser")
	@Produces({MediaType.APPLICATION_JSON})
	public ResponsesUsers getUser(@QueryParam("idUser") String idUser) {
		return webService.getUser(idUser);
	}
}
