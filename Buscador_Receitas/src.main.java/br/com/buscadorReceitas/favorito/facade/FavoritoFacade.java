package br.com.buscadorReceitas.favorito.facade;

import java.util.List;

import br.com.buscadorReceitas.model.Favorito;
import br.com.buscadorReceitas.model.Usuario;

public interface FavoritoFacade {
	
public void adicionar(Favorito favorito) throws Exception;
	
	public void remover(Favorito favorito) throws Exception;
	
	public List<Favorito> listarFavoritosPeloUsuario(Usuario usuario) throws Exception;

}
