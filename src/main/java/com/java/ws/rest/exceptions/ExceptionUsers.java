package com.java.ws.rest.exceptions;

/***
 * Clase para excepciones personalizadas provenientes de todo lo que tenga que ver con la administracion de los usuarios en el sistema
 * @author juanaga
 *
 */
public class ExceptionUsers extends Exception {
	
	private String code;

	public ExceptionUsers(String message, Throwable cause, String code) {
        super(message, cause);
            this.code = code;
    }
}
