package br.com.buscadorReceitas.geladeira.facade;

import br.com.buscadorReceitas.model.Geladeira;

public interface GeladeiraFacade {
	
	public void inserir(Geladeira geladeira) throws Exception;
	
	public void alterar(Geladeira geladeira) throws Exception;
	
	public void excluir(Geladeira geladeira) throws Exception;
	
	public void listar(Geladeira geladeira) throws Exception;
	
	public void buscarPeloCodigo(Geladeira geladeira) throws Exception;

}
