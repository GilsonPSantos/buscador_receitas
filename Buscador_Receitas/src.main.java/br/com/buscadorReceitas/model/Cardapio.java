package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="CARDAPIO")
public class Cardapio implements Serializable {

	private static final long serialVersionUID = -3241150211179460373L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCardapio;
	@Column(length=50, nullable=false)
	private String nome;
	@Column
	private Calendar dataInclusao;
	@Column
	private Calendar dataAtualizacao;
	@Column(length=1)
	private Integer ativo;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_TIPO_CARDAPIO", nullable=false, referencedColumnName="idTipoCardapio")
	private TipoCardapio tipoCardapio;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_USUARIO", nullable=false, referencedColumnName="idUsuario")
	private Usuario usuarioResponsavel;
	@OneToMany(mappedBy="cardapio", fetch=FetchType.EAGER)
	private List<Mensagem> listaMensagem;

	
	
	public Integer getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Integer idCardapio) {
		this.idCardapio = idCardapio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCardapio getTipoCardapio() {
		return tipoCardapio;
	}

	public void setTipoCardapio(TipoCardapio tipoCardapio) {
		this.tipoCardapio = tipoCardapio;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public List<Mensagem> getListaMensagem() {
		return listaMensagem;
	}

	public void setListaMensagem(List<Mensagem> listaMensagem) {
		this.listaMensagem = listaMensagem;
	}

}
