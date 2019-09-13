package com.java.ws.rest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/***
 * Clase para mapear la tabla usuario
 * @author juanaga
 *
 */
@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", unique = true)
	private Integer idUsuario;
	
	@Column(name = "nombres_usuario", nullable = false)
	private String nombresUsuario;
	
	@Column(name = "apellidos_usuario", nullable = false)
	private String apellidosUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipoDocumento")
	private TipoDocumento tipoDocumento;
	
	public Usuario() {
		
	}
	public Usuario(Integer idUsuario, String nombresUsuario, String apellidosUsuario, Rol rol,
			TipoDocumento tipoDocumento) {
		super();
		this.idUsuario = idUsuario;
		this.nombresUsuario = nombresUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.rol = rol;
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombresUsuario=" + nombresUsuario + ", apellidosUsuario="
				+ apellidosUsuario + ", rol=" + rol.getIdRol() + ", tipoDocumento=" + tipoDocumento.getIdTipoDocumento() + "]";
	}
	
	
	
}
