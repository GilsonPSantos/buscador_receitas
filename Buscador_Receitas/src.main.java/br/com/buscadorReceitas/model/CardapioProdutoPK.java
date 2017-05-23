package br.com.buscadorReceitas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CardapioProdutoPK implements Serializable{

	private static final long serialVersionUID = -1129182452541723883L;
	@Column(name="ID_CARDAPIO", nullable=false)
	private Integer idCardapio;
	@Column(name="ID_PRODUTO", nullable=false)
	private Integer idProduto;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CardapioProdutoPK)) {
			return false;
		}
		CardapioProdutoPK outro = (CardapioProdutoPK) obj;
		
		if(!this.idProduto.equals(outro.getIdProduto())) {
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
		hash += this.idProduto.toString().length();
		hash += this.idCardapio.toString().length();
		return hash;
	}

	public Integer getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Integer idCardapio) {
		this.idCardapio = idCardapio;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	

}
