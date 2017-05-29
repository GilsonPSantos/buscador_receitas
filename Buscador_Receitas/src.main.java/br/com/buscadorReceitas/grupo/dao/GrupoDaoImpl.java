package br.com.buscadorReceitas.grupo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.Grupo;

public class GrupoDaoImpl implements GrupoDao {

	private EntityManager entityManager = JPAUtil.getEntityManager();

	@Override
	public void inserir(Grupo grupo) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(grupo);
		entityManager.getTransaction().commit();
	}

	@Override
	public void alterar(Grupo grupo) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.merge(grupo);
		entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(Grupo grupo) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(grupo);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> listar() throws Exception {
		return entityManager.createQuery("FROM " + Grupo.class.getName()).getResultList();
	}

	@Override
	public Grupo buscarPeloCodigo(Grupo grupo) throws Exception {
		return entityManager.find(Grupo.class, grupo.getIdGrupo());
	}

}
