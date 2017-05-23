package br.com.buscadorReceitas.validator;

import java.lang.reflect.Field;

public class Regra {
	
	private Field campo;
	private Boolean campoNulo;
	private Integer tamanhoMaximo;
	private Integer tamanhoMinimo;
	private String nomeCampo;
	
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
	
}
