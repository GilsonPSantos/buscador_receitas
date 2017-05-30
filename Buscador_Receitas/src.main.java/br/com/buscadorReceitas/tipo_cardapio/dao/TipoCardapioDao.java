package br.com.buscadorReceitas.tipo_cardapio.dao;

import java.util.List;

import br.com.buscadorReceitas.model.Grupo;
import br.com.buscadorReceitas.model.TipoCardapio;

public interface TipoCardapioDao {
	
	public void inserir(TipoCardapio tipoCardapio) throws Exception;
	
	public void alterar(TipoCardapio tipoCardapio) throws Exception;
	
	public void excluir(TipoCardapio tipoCardapio) throws Exception;
	
	public List<TipoCardapio> listar() throws Exception;
	
	public TipoCardapio buscarPeloCodigo(TipoCardapio tipoCardapio) throws Exception;

}
