package br.com.buscadorReceitas.cardapio.dao;

import java.util.List;

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
		entityManager.getTransaction().begin();
		entityManager.remove(cardapio);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cardapio> listar(Cardapio cardapio) throws Exception {
		return entityManager.createQuery("FROM " + Cardapio.class.getName()).getResultList();
	}

	@Override
	public Cardapio buscarPeloCodigo(Cardapio cardapio) throws Exception {
		return entityManager.find(Cardapio.class, cardapio.getIdCardapio());
	}
	
	

}
