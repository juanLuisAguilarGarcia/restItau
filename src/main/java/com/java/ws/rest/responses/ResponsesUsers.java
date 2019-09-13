package com.java.ws.rest.responses;

import javax.xml.bind.annotation.XmlRootElement;

/***
 * Clase para mapear las respuestas de los servicios, con el fin de estandarizar la respuesta
 * @author juanaga
 *
 */
public class ResponsesUsers {
	private String code;
	private String message;
	private String datos;
	
	public ResponsesUsers() {
		
	}
	public ResponsesUsers(String code, String message, String datos) {
		this.code = code;
		this.message = message;
		this.datos = datos;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}
	
	
}
