package com.java.ws.rest.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***
 * Clase para mapeo de tabla Rol
 * @author juanaga
 *
 */
@Entity
@Table(name="rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rol", unique = true)
	private Integer idRol;
	
	@Column(name = "desc_rol", nullable = false)
	private String descRol;
	
	@OneToMany(mappedBy = "rol",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Usuario> usuarios = new ArrayList();

	public Rol() {
	}
	
	public Rol(Integer idRol, String descRol) {
		this.idRol = idRol;
		this.descRol = descRol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescRol() {
		return descRol;
	}

	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	

}
