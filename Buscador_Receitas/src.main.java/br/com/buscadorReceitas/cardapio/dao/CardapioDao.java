package br.com.buscadorReceitas.cardapio.dao;

import br.com.buscadorReceitas.model.Cardapio;

public interface CardapioDao {
	
	public void inserir(Cardapio cardapio) throws Exception;
	
	public void alterar(Cardapio cardapio) throws Exception;
	
	public void excluir(Cardapio cardapio) throws Exception;
	
	public void listar(Cardapio cardapio) throws Exception;
	
	public void buscarPeloCodigo(Cardapio cardapio) throws Exception;

}
