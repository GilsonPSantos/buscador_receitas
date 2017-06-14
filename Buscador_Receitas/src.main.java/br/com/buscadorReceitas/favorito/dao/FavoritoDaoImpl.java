package br.com.buscadorReceitas.favorito.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.Favorito;
import br.com.buscadorReceitas.model.Usuario;

public class FavoritoDaoImpl implements FavoritoDao {
	
	private EntityManager entityManager = JPAUtil.getEntityManager();

	@Override
	public void adicionar(Favorito favorito) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(favorito);
		entityManager.getTransaction().commit();
	}

	@Override
	public void remover(Favorito favorito) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(favorito);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Favorito> listarFavoritosPeloUsuario(Usuario usuario) throws Exception {
		TypedQuery<Favorito> query = entityManager.createQuery(
				"SELECT f FROM Favorito f WHERE f.id_Usuario = :id_Usuario and f.ativo = :ativo", Favorito.class);
		query.setParameter("id_Usuario", usuario.getIdUsuario());
		query.setParameter("ativo", 1);
		return query.getResultList();
	}

}
