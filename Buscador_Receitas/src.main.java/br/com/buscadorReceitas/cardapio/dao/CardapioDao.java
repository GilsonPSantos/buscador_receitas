package br.com.buscadorReceitas.cardapio.dao;

import java.util.List;

import br.com.buscadorReceitas.model.Cardapio;

public interface CardapioDao {
	
	public void inserir(Cardapio cardapio) throws Exception;
	
	public void alterar(Cardapio cardapio) throws Exception;
	
	public void excluir(Cardapio cardapio) throws Exception;
	
	public List<Cardapio> listar(Cardapio cardapio) throws Exception;
	
	public Cardapio buscarPeloCodigo(Cardapio cardapio) throws Exception;

}
