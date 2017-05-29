package br.com.buscadorReceitas.produto.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.Produto;

public class ProdutoDaoImpl implements ProdutoDao{
	
	private EntityManager entityManager = JPAUtil.getEntityManager(); 

	@Override
	public void inserir(Produto produto) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();
	}

	@Override
	public void alterar(Produto produto) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(Produto produto) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() throws Exception {
		return entityManager.createQuery("FROM " + Produto.class.getName()).getResultList();
	}

	@Override
	public Produto buscarPeloCodigo(Produto produto) throws Exception {
		return entityManager.find(Produto.class, produto.getIdProduto());
	}

}
