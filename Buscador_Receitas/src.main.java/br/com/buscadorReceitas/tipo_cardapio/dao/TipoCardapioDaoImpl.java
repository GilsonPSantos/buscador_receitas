package br.com.buscadorReceitas.tipo_cardapio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.TipoCardapio;

public class TipoCardapioDaoImpl implements TipoCardapioDao {
	
	private EntityManager entityManager = JPAUtil.getEntityManager();

	@Override
	public void inserir(TipoCardapio tipoCardapio) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(tipoCardapio);
		entityManager.getTransaction().commit();
	}

	@Override
	public void alterar(TipoCardapio tipoCardapio) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.merge(tipoCardapio);
		entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(TipoCardapio tipoCardapio) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(tipoCardapio);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCardapio> listar() throws Exception {
		return entityManager.createQuery("FROM " + TipoCardapio.class.getName()).getResultList();
	}

	@Override
	public TipoCardapio buscarPeloCodigo(TipoCardapio tipoCardapio) throws Exception {
		return entityManager.find(TipoCardapio.class, tipoCardapio.getIdTipoCardapio());
	}

}
