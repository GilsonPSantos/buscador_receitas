package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FAVORITO")
public class Favorito implements Serializable{

	private static final long serialVersionUID = -4701276101268124034L;
	
	@EmbeddedId
	private UsuarioCardapioPK usuarioCardapioPK;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInclusao;
	
	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
