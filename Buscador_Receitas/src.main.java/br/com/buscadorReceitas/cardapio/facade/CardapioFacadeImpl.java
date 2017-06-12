package br.com.buscadorReceitas.cardapio.facade;

import java.util.List;

import javax.inject.Inject;

import br.com.buscadorReceitas.model.Cardapio;
import br.com.buscadorReceitas.model.TipoCardapio;
import br.com.buscadorReceitas.model.Usuario;

public class CardapioFacadeImpl implements CardapioFacade {
	
	@Inject
	private CardapioFacade cardapioFacade;

	@Override
	public void inserir(Cardapio cardapio) throws Exception {
		cardapioFacade.inserir(cardapio);
	}

	@Override
	public void alterar(Cardapio cardapio) throws Exception {
		cardapioFacade.alterar(cardapio);
	}

	@Override
	public void excluir(Cardapio cardapio) throws Exception {
		cardapioFacade.excluir(cardapio);
	}

	@Override
	public List<Cardapio> listarCardapioPeloUsuario(Usuario usuario) throws Exception {
		return cardapioFacade.listarCardapioPeloUsuario(usuario);
	}

	@Override
	public Cardapio buscarPeloCodigo(Cardapio cardapio) throws Exception {
		return cardapioFacade.buscarPeloCodigo(cardapio);
	}

	@Override
	public List<Cardapio> listarCardapioPeloNome(Cardapio cardapio) throws Exception {
		return cardapioFacade.listarCardapioPeloNome(cardapio);
	}

	@Override
	public List<Cardapio> listarCardapioPeloTipo(TipoCardapio tipoCardapio) throws Exception {
		return cardapioFacade.listarCardapioPeloTipo(tipoCardapio);
	}

}
