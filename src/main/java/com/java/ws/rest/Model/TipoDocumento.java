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
 * Clase pra mapear la tabla tipo documento
 * @author juanaga
 *
 */
@Entity
@Table(name="tipo_documento")
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipoDocumento", unique = true)
	private Integer idTipoDocumento;
	
	@Column(name = "desc_tipoDocumento", nullable = false)
	private String descTipoDocumento;
	
	@OneToMany(mappedBy = "tipoDocumento",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Usuario> usuarios = new ArrayList();

	public TipoDocumento() {
		
	}
	public TipoDocumento(Integer idTipoDocumento, String descTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
		this.descTipoDocumento = descTipoDocumento;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}
	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
