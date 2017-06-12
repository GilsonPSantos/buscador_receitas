package br.com.buscadorReceitas.cardapio.facade;

import java.util.List;

import br.com.buscadorReceitas.model.Cardapio;
import br.com.buscadorReceitas.model.TipoCardapio;
import br.com.buscadorReceitas.model.Usuario;

public interface CardapioFacade {
	
public void inserir(Cardapio cardapio) throws Exception;
	
	public void alterar(Cardapio cardapio) throws Exception;
	
	public void excluir(Cardapio cardapio) throws Exception;
	
	public List<Cardapio> listarCardapioPeloUsuario(Usuario usuario) throws Exception;
	
	public List<Cardapio> listarCardapioPeloNome(Cardapio cardapio) throws Exception;
	
	public List<Cardapio> listarCardapioPeloTipo(TipoCardapio tipoCardapio) throws Exception;
	
	public Cardapio buscarPeloCodigo(Cardapio cardapio) throws Exception;

}
