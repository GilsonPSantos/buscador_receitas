package br.com.buscadorReceitas.usuario.facade;

import java.util.List;

import javax.inject.Inject;

import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.usuario.dao.UsuarioDao;

public class UsuarioFacadeImpl implements UsuarioFacade{
	
	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public void inserir(Usuario usuario) throws Exception {
		usuario.setAtivo(1);
		usuarioDao.inserir(usuario);
	}

	@Override
	public void alterar(Usuario usuario) throws Exception {
		usuarioDao.alterar(usuario);
	}

	@Override
	public void excluir(Usuario usuario) throws Exception {
		usuario.setAtivo(0);
		usuarioDao.excluir(usuario);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		return usuarioDao.listar();
	}

	@Override
	public Usuario buscarPeloCodigo(Usuario usuario) throws Exception {
		return usuarioDao.buscarPeloCodigo(usuario);
	}

}
