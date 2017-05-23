package br.com.buscadorReceitas.geladeira.dao;

import br.com.buscadorReceitas.model.Geladeira;

public interface GeladeiraDao {
	
	public void inserir(Geladeira geladeira) throws Exception;
	
	public void alterar(Geladeira geladeira) throws Exception;
	
	public void excluir(Geladeira geladeira) throws Exception;
	
	public void listar(Geladeira geladeira) throws Exception;
	
	public void buscarPeloCodigo(Geladeira geladeira) throws Exception;

}
