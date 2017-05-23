package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MENSAGEM")
public class Mensagem implements Serializable{

	private static final long serialVersionUID = -7168039879293202217L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMensagem;
	@Column(length=400, nullable=false)
	private String mensagem;
	@Column(length=1,nullable=false)
	private Integer ativo;
	@Column(length=1,nullable=false)
	private Integer aprovado;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInclusao;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_USUARIO", nullable=false, referencedColumnName="idUsuario")
	private Usuario usuario;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CARDAPIO", nullable=false, referencedColumnName="idCardapio")
	private Cardapio cardapio;

	
	public Integer getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Integer getAprovado() {
		return aprovado;
	}

	public void setAprovado(Integer aprovado) {
		this.aprovado = aprovado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
