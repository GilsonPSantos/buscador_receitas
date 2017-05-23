package br.com.buscadorReceitas.usuario.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.buscadorReceitas.dao.JPAUtil;
import br.com.buscadorReceitas.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	private EntityManager entityManager = JPAUtil.getEntityManager();

	@Override
	public void inserir(Usuario usuario) throws Exception {
		entityManager.getTransaction().begin();
			entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	}

	@Override
	public void alterar(Usuario usuario) throws Exception {
		entityManager.getTransaction().begin();
			entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void excluir(Usuario usuario) throws Exception {
		entityManager.getTransaction().begin();
			entityManager.merge(usuario);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() throws Exception {
		return entityManager.createQuery("FROM "+Usuario.class.getName()).getResultList();
	}

	@Override
	public Usuario buscarPeloCodigo(Usuario usuario) throws Exception {
		return entityManager.find(Usuario.class, usuario.getIdUsuario());
	}

}
