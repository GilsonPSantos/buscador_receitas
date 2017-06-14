package br.com.buscadorReceitas.favorito.servico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.buscadorReceitas.cardapio.servico.CardapioService;
import br.com.buscadorReceitas.cardapio.util.ValidadoCardapio;
import br.com.buscadorReceitas.exception.ValidatorException;
import br.com.buscadorReceitas.favorito.facade.FavoritoFacade;
import br.com.buscadorReceitas.favorito.util.ValidadorFavorito;
import br.com.buscadorReceitas.model.Cardapio;
import br.com.buscadorReceitas.model.Favorito;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.util.Constante;
import br.com.buscadorReceitas.util.TratarRetornoServico;

@Path("/favorito/v1")
public class FavoritoService implements Serializable{

	private static final long serialVersionUID = 4129863681568835894L;
	private static final Logger LOGGER = Logger.getLogger(FavoritoService.class);
	
	@Inject
	private FavoritoFacade favoritoFacade;
	@Inject
	private Favorito favorito;
	@Inject
	private Usuario usuario;
	@Inject
	private RetornoServico retornoServico;
	@Inject
	private TratarRetornoServico tratarRetornoServico;
	
	@Path("/adicionarFavorito")
	@POST
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico adicionar(Favorito favorito){
		try {
			ValidadorFavorito validacao = new ValidadorFavorito();
			validacao.validar(favorito, "adicionar");
			favoritoFacade.adicionar(favorito);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "adicionar", favorito.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/removerFavorito")
	@DELETE
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico remover(Favorito favorito){
		try {
			ValidadorFavorito validacao = new ValidadorFavorito();
			validacao.validar(favorito, "remover");
			favoritoFacade.remover(favorito);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "remover", favorito.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/listarFavoritosPeloUsuario/{idUsuario}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listarCardapiosPeloUsuario(@PathParam("idUsuario") Integer idUsuario){
		try {
			if(null != idUsuario || !"".equals(idUsuario)) {
				this.usuario.setIdUsuario(idUsuario);
				return favoritoFacade.listarFavoritosPeloUsuario(this.usuario);
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O id do usuário é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	

}
