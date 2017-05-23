package br.com.buscadorReceitas.cardapio.facade;

import br.com.buscadorReceitas.model.Cardapio;

public interface CardapioFacade {
	
	public void inserir(Cardapio cardapio) throws Exception;
	
	public void alterar(Cardapio cardapio) throws Exception;
	
	public void excluir(Cardapio cardapio) throws Exception;
	
	public void listar(Cardapio cardapio) throws Exception;
	
	public void buscarPeloCodigo(Cardapio cardapio) throws Exception;

}
