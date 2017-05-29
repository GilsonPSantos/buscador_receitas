package br.com.buscadorReceitas.grupo.facade;

import java.util.List;

import br.com.buscadorReceitas.model.Grupo;

public interface GrupoFacade {
	
	public void inserir(Grupo grupo) throws Exception;
	
	public void alterar(Grupo grupo) throws Exception;
	
	public void excluir(Grupo grupo) throws Exception;
	
	public List<Grupo> listar() throws Exception;
	
	public Grupo buscarPeloCodigo(Grupo grupo) throws Exception;

}
