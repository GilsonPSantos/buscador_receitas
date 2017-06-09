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

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1607997577400010608L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(length=50, unique=true, nullable=false)
	private String email;
	@Column(length=100, nullable=false, unique=true)
	private String senha;
	@Column(length=50)
	private String foto;
	@Column(length=1, nullable=false)
	private Integer ativo;
	@OneToMany(mappedBy="usuarioResponsavel", fetch=FetchType.EAGER)
	private List<Cardapio> listaCardapio;
	@OneToMany(mappedBy="usuario", targetEntity= Mensagem.class, fetch=FetchType.LAZY)
	private List<Mensagem> listaMensagem;
	
	private transient Geladeira geladeira;
	private transient List<Favorito> listaFavorito;
	private transient List<Produto> listaProdutoGeladeira;
	
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", foto=" + foto + ", ativo=" + ativo + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public List<Favorito> getListaFavorito() {
		return listaFavorito;
	}

	public void setListaFavorito(List<Favorito> listaFavorito) {
		this.listaFavorito = listaFavorito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}

	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

	public List<Mensagem> getListaMensagem() {
		return listaMensagem;
	}

	public void setListaMensagem(List<Mensagem> listaMensagem) {
		this.listaMensagem = listaMensagem;
	}

	public Geladeira getGeladeira() {
		return geladeira;
	}

	public void setGeladeira(Geladeira geladeira) {
		this.geladeira = geladeira;
	}

	public List<Produto> getListaProdutoGeladeira() {
		return listaProdutoGeladeira;
	}

	public void setListaProdutoGeladeira(List<Produto> listaProdutoGeladeira) {
		this.listaProdutoGeladeira = listaProdutoGeladeira;
	}

}
