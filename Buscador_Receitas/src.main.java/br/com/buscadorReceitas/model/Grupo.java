package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="GRUPO")
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 5019287903950988886L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGrupo;
	@Column(length=50, unique=true, nullable=false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="grupo", fetch=FetchType.LAZY)
	private List<Produto> listaProdutos;
	
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	

}
