package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_CARDAPIO")
public class TipoCardapio implements Serializable {

	private static final long serialVersionUID = -1012179081357677581L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoCardapio;
	@Column(length=50, unique=true, nullable=false)
	private String nomeTipoCardapio;
	@OneToMany(mappedBy="tipoCardapio", fetch=FetchType.EAGER)
	private List<Cardapio> listaCardapio;

	public Integer getIdTipoCardapio() {
		return idTipoCardapio;
	}

	public void setIdTipoCardapio(Integer idTipoCardapio) {
		this.idTipoCardapio = idTipoCardapio;
	}

	public String getNomeTipoCardapio() {
		return nomeTipoCardapio;
	}

	public void setNomeTipoCardapio(String nomeTipoCardapio) {
		this.nomeTipoCardapio = nomeTipoCardapio;
	}

	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}

	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}
	
	

}
