package br.com.buscadorReceitas.tipo_cardapio.facade;

import java.util.List;

import javax.inject.Inject;

import br.com.buscadorReceitas.model.TipoCardapio;
import br.com.buscadorReceitas.tipo_cardapio.dao.TipoCardapioDao;

public class TipoCardapioFacadeImpl implements TipoCardapioFacade{
	
	@Inject
	private TipoCardapioDao tipoCardapioDao;

	@Override
	public void inserir(TipoCardapio tipoCardapio) throws Exception {
		tipoCardapioDao.inserir(tipoCardapio);
	}

	@Override
	public void alterar(TipoCardapio tipoCardapio) throws Exception {
		tipoCardapioDao.alterar(tipoCardapio);
	}

	@Override
	public void excluir(TipoCardapio tipoCardapio) throws Exception {
		tipoCardapioDao.excluir(tipoCardapio);
	}

	@Override
	public List<TipoCardapio> listar() throws Exception {
		return tipoCardapioDao.listar();
	}

	@Override
	public TipoCardapio buscarPeloCodigo(TipoCardapio tipoCardapio) throws Exception {
		return tipoCardapioDao.buscarPeloCodigo(tipoCardapio);
	}

}
