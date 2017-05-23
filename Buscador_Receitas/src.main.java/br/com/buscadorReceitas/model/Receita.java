package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RECEITA")
public class Receita implements Serializable {

	private static final long serialVersionUID = -7125564517910107409L;
	
	@EmbeddedId
	private CardapioProdutoPK cardapioProdutoPK;
	@Column(length=5)
	private Integer grauRelevancia;
	@Column(length=10)
	private Integer quantidade;
	
	private transient Cardapio cardapio;
	
	private transient List<Produto> listaProdutos;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getGrauRelevancia() {
		return grauRelevancia;
	}

	public void setGrauRelevancia(Integer grauRelevancia) {
		this.grauRelevancia = grauRelevancia;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
