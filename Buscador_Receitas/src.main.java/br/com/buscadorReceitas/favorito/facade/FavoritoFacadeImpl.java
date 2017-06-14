package br.com.buscadorReceitas.favorito.facade;

import java.util.List;

import javax.inject.Inject;

import br.com.buscadorReceitas.favorito.dao.FavoritoDao;
import br.com.buscadorReceitas.model.Favorito;
import br.com.buscadorReceitas.model.Usuario;

public class FavoritoFacadeImpl implements FavoritoFacade{
	
	@Inject
	private FavoritoDao favoritoDao;

	@Override
	public void adicionar(Favorito favorito) throws Exception {
		favoritoDao.adicionar(favorito);
	}

	@Override
	public void remover(Favorito favorito) throws Exception {
		favoritoDao.remover(favorito);
	}

	@Override
	public List<Favorito> listarFavoritosPeloUsuario(Usuario usuario) throws Exception {
		return favoritoDao.listarFavoritosPeloUsuario(usuario);
	}

}
