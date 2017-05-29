package br.com.buscadorReceitas.produto.facade;

import java.util.List;

import javax.inject.Inject;

import br.com.buscadorReceitas.model.Produto;
import br.com.buscadorReceitas.produto.dao.ProdutoDao;

public class ProdutoFacadeImpl implements ProdutoFacade{
	
	@Inject
	private ProdutoDao produtoDao;
	
	@Override
	public void inserir(Produto produto) throws Exception {
		produtoDao.inserir(produto);
	}

	@Override
	public void alterar(Produto produto) throws Exception {
		produtoDao.alterar(produto);
	}

	@Override
	public void excluir(Produto produto) throws Exception {
		produtoDao.excluir(produto);
	}

	@Override
	public List<Produto> listar() throws Exception {
		return produtoDao.listar();
	}

	@Override
	public Produto buscarPeloCodigo(Produto produto) throws Exception {
		return produtoDao.buscarPeloCodigo(produto);
	}

}
