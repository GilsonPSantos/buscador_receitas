package br.com.buscadorReceitas.receita.dao;

import br.com.buscadorReceitas.model.Receita;

public interface ReceitaDao {
	
	public void inserir(Receita receita) throws Exception;
	
	public void alterar(Receita receita) throws Exception;
	
	public void excluir(Receita receita) throws Exception;
	
	public void listar(Receita receita) throws Exception;
	
	public void buscarPeloCodigo(Receita receita) throws Exception;

}
