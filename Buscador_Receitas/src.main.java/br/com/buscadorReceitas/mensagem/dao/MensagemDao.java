package br.com.buscadorReceitas.mensagem.dao;

import br.com.buscadorReceitas.model.Mensagem;

public interface MensagemDao {
	
	public void inserir(Mensagem mensagem) throws Exception;
	
	public void alterar(Mensagem mensagem) throws Exception;
	
	public void excluir(Mensagem mensagem) throws Exception;
	
	public void listar(Mensagem mensagem) throws Exception;
	
	public void buscarPeloCodigo(Mensagem mensagem) throws Exception;

}
