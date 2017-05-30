package br.com.buscadorReceitas.cardapio.dao;

import javax.persistence.EntityManager;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.Cardapio;

public class CardapioDaoImpl implements CardapioDao {
	
	private EntityManager entityManager = JPAUtil.getEntityManager();

	@Override
	public void inserir(Cardapio cardapio) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(cardapio);
		entityManager.getTransaction().commit();
	}

	@Override
	public void alterar(Cardapio cardapio) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.merge(cardapio);
		entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(Cardapio cardapio) throws Exception {
		
	}

	@Override
	public void listar(Cardapio cardapio) throws Exception {
		
	}

	@Override
	public void buscarPeloCodigo(Cardapio cardapio) throws Exception {
		
	}
	
	

}
