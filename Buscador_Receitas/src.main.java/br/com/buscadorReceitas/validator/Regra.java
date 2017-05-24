package br.com.buscadorReceitas.validator;

import java.lang.reflect.Field;

public class Regra {
	
	private Field campo;
	private Boolean campoNulo;
	private Integer tamanhoMaximo;
	private Integer tamanhoMinimo;
	private String nomeCampo;
	private String mensagemCampoNulo;
	private String mensagemTamanhoMaximo;
	private String mensagemTamanhoMinimo;
	
	public Regra() {
	}

	public Field getCampo() {
		return campo;
	}

	public void setCampo(Field campo) {
		this.campo = campo;
	}

	public Boolean getCampoNulo() {
		return campoNulo;
	}

	public void setCampoNulo(Boolean campoNulo) {
		this.campoNulo = campoNulo;
	}

	public Integer getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoMaximo(Integer tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
	}

	public Integer getTamanhoMinimo() {
		return tamanhoMinimo;
	}

	public void setTamanhoMinimo(Integer tamanhoMinimo) {
		this.tamanhoMinimo = tamanhoMinimo;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getMensagemCampoNulo() {
		return mensagemCampoNulo;
	}

	public void setMensagemCampoNulo(String mensagemCampoNulo) {
		this.mensagemCampoNulo = mensagemCampoNulo;
	}

	public String getMensagemTamanhoMaximo() {
		return mensagemTamanhoMaximo;
	}

	public void setMensagemTamanhoMaximo(String mensagemTamanhoMaximo) {
		this.mensagemTamanhoMaximo = mensagemTamanhoMaximo;
	}

	public String getMensagemTamanhoMinimo() {
		return mensagemTamanhoMinimo;
	}

	public void setMensagemTamanhoMinimo(String mensagemTamanhoMinimo) {
		this.mensagemTamanhoMinimo = mensagemTamanhoMinimo;
	}

	
}
