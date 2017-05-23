package br.com.buscadorReceitas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioProdutoPK implements Serializable {

	private static final long serialVersionUID = 411442772681080971L;
	
	@Column(name="ID_PRODUTO", nullable=false)
	private Integer idProduto;
	@Column(name="ID_USUARIO", nullable=false)
	private Integer idUsuario;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsuarioProdutoPK)) {
			return false;
		}
		UsuarioProdutoPK outro = (UsuarioProdutoPK) obj;
		
		if(!this.idUsuario.equals(outro.getIdUsuario())) {
			return false;
		}
		
		if(!this.idProduto.equals(outro.getIdProduto())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += this.idUsuario.toString().length();
		hash += this.idProduto.toString().length();
		return hash;
	}
	
	

}
