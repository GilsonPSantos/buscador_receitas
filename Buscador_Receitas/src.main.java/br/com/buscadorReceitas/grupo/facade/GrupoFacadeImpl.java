package br.com.buscadorReceitas.grupo.facade;

import java.util.List;

import javax.inject.Inject;

import br.com.buscadorReceitas.grupo.dao.GrupoDao;
import br.com.buscadorReceitas.model.Grupo;

public class GrupoFacadeImpl implements GrupoFacade {
	
	@Inject
	private GrupoDao grupoDao;

	@Override
	public void inserir(Grupo grupo) throws Exception {
		grupoDao.inserir(grupo);
	}

	@Override
	public void alterar(Grupo grupo) throws Exception {
		grupoDao.alterar(grupo);
	}

	@Override
	public void excluir(Grupo grupo) throws Exception {
		grupoDao.excluir(grupo);
	}

	@Override
	public List<Grupo> listar() throws Exception {
		return grupoDao.listar();
	}

	@Override
	public Grupo buscarPeloCodigo(Grupo grupo) throws Exception {
		return grupoDao.buscarPeloCodigo(grupo);
	}

}
