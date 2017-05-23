package br.com.buscadorReceitas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioCardapioPK implements Serializable{

	private static final long serialVersionUID = 7838312377094031317L;
	
	@Column(name="ID_USUARIO", nullable=false)
	private Integer idUsuario;
	@Column(name="ID_CARDAPIO", nullable=false)
	private Integer idCardapio;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsuarioCardapioPK)) {
			return false;
		}
		UsuarioCardapioPK outro = (UsuarioCardapioPK) obj;
		
		if(!this.idUsuario.equals(outro.getIdUsuario())) {
			return false;
		}
		
		if(!this.idCardapio.equals(outro.getIdCardapio())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += this.idUsuario.toString().length();
		hash += this.idCardapio.toString().length();
		return hash;
	}
	
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdCardapio() {
		return idCardapio;
	}
	public void setIdCardapio(Integer idCardapio) {
		this.idCardapio = idCardapio;
	}
	
	
}
