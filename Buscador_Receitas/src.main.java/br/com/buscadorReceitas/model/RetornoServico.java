package br.com.buscadorReceitas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RetornoServico implements Serializable{

	private static final long serialVersionUID = -7897562148551422254L;
	
	private Integer codigo;
	
	private List<String> mensagem;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<String> getMensagem() {
		return mensagem;
	}

	public void setMensagem(List<String> mensagem) {
		this.mensagem = mensagem;
	}
	
	public void adicionarMensagem(String mensagem) {
		if(this.mensagem == null) {
			this.mensagem = new ArrayList<String>();
		}
		this.mensagem.add(mensagem);
	}
	
	

}
