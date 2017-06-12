package br.com.buscadorReceitas.cardapio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.Cardapio;
import br.com.buscadorReceitas.model.TipoCardapio;
import br.com.buscadorReceitas.model.Usuario;

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

	@Override
	public List<Cardapio> listarCardapioPeloUsuario(Usuario usuario) throws Exception {
		TypedQuery<Cardapio> query = entityManager.createQuery(
				"SELECT c FROM Cardapio c WHERE c.id_Usuario = :id_Usuario and c.ativo = :ativo", Cardapio.class);
		query.setParameter("id_Usuario", usuario.getIdUsuario());
		query.setParameter("ativo", 1);
		return query.getResultList();
	}

	@Override
	public Cardapio buscarPeloCodigo(Cardapio cardapio) throws Exception {
		return entityManager.find(Cardapio.class, cardapio.getIdCardapio());
	}

	@Override
	public List<Cardapio> listarCardapioPeloNome(Cardapio cardapio) throws Exception {
		TypedQuery<Cardapio> query = entityManager.createQuery(
				"SELECT c FROM Cardapio c WHERE LOWER(C.nome) LIKE %:nome% and c.ativo = :ativo", Cardapio.class);
		query.setParameter("nome", cardapio.getNome());
		query.setParameter("ativo", 1);
		return query.getResultList();
	}

	@Override
	public List<Cardapio> listarCardapioPeloTipo(TipoCardapio tipoCardapio) throws Exception {
		TypedQuery<Cardapio> query = entityManager.createQuery(
				"SELECT c FROM Cardapio c WHERE c.ID_TIPO_CARDAPIO = :ID_TIPO_CARDAPIO and c.ativo = :ativo", Cardapio.class);
		query.setParameter("ID_TIPO_CARDAPIO", tipoCardapio.getIdTipoCardapio());
		query.setParameter("ativo", 1);
		return query.getResultList();
	}
	
	

}
