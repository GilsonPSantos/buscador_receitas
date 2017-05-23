package br.com.buscadorReceitas.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GELADEIRA")
public class Geladeira implements Serializable {

	private static final long serialVersionUID = 4401118070871646825L;

	@EmbeddedId
	private UsuarioProdutoPK usuarioProdutoPK;

	public UsuarioProdutoPK getUsuarioProdutoPK() {
		return usuarioProdutoPK;
	}

	public void setUsuarioProdutoPK(UsuarioProdutoPK usuarioProdutoPK) {
		this.usuarioProdutoPK = usuarioProdutoPK;
	}
	
	
	
}
