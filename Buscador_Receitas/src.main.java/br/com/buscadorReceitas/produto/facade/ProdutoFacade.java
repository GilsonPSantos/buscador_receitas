package br.com.buscadorReceitas.produto.facade;

import java.util.List;

import br.com.buscadorReceitas.model.Grupo;
import br.com.buscadorReceitas.model.Produto;

public interface ProdutoFacade {
	
	public void inserir(Produto produto) throws Exception;
	
	public void alterar(Produto produto) throws Exception;
	
	public void excluir(Produto produto) throws Exception;
	
	public List<Produto> listar() throws Exception;
	
	public Produto buscarPeloCodigo(Produto produto) throws Exception;
	
	public List<Produto> listarProdutosPeloGrupo(Grupo grupo) throws Exception;

}
