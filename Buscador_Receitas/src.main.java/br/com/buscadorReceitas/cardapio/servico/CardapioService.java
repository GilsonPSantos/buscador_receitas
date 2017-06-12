package br.com.buscadorReceitas.cardapio.servico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.buscadorReceitas.cardapio.facade.CardapioFacade;
import br.com.buscadorReceitas.cardapio.util.ValidadoCardapio;
import br.com.buscadorReceitas.exception.ValidatorException;
import br.com.buscadorReceitas.model.Cardapio;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.util.Constante;
import br.com.buscadorReceitas.util.TratarRetornoServico;

@Path("/cardapio/v1")
public class CardapioService implements Serializable {
	
	private static final long serialVersionUID = -7144189223135204506L;
	private static final Logger LOGGER = Logger.getLogger(CardapioService.class);
	
	@Inject
	private CardapioFacade cardapioFacade;
	@Inject
	private Cardapio cardapio;
	@Inject
	private Usuario usuario;
	@Inject
	private RetornoServico retornoServico;
	@Inject
	private TratarRetornoServico tratarRetornoServico;
	
	
	@Path("/inserirCardapio")
	@POST
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico inserir(Cardapio cardapio){
		try {
			ValidadoCardapio validacao = new ValidadoCardapio();
			validacao.validar(cardapio, "inserir");
			cardapioFacade.inserir(cardapio);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "inserir", cardapio.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/alterarCardapio")
	@PUT
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico alterar(Cardapio cardapio){
		try {
			ValidadoCardapio validacao = new ValidadoCardapio();
			validacao.validar(cardapio, "alterar");
			cardapioFacade.alterar(cardapio);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico,"alterar", cardapio.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/buscarCardapioPeloId/{id}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object consultarUsuarioPeloId(@PathParam(value="id") Integer idCardapio){
		try {
			if(null != idCardapio || !"".equals(idCardapio)) {
				this.cardapio.setIdCardapio(idCardapio);
				this.cardapio = cardapioFacade.buscarPeloCodigo(cardapio);
				return this.cardapio;
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O id do cardápio é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	@Path("/listarCardapiosPeloUsuario/{idUsuario}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listarCardapiosPeloUsuario(@PathParam("idUsuario") Integer idUsuario){
		try {
			if(null != idUsuario || !"".equals(idUsuario)) {
				this.usuario.setIdUsuario(idUsuario);
				return cardapioFacade.listarCardapioPeloUsuario(this.usuario);
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
	
	@Path("/listarCardapiosPeloNome/{nomeCardapio}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listarCardapiosPeloNome(@PathParam("nomeCardapio") String nomeCardapio){
		try {
			if(null != nomeCardapio || !"".equals(nomeCardapio)) {
				this.cardapio.setNome(nomeCardapio);
				return cardapioFacade.listarCardapioPeloNome(this.cardapio);
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O Nome do cardápio é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	@Path("/listarCardapiosPeloTipo/{idTipoCardapio}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listarCardapiosPeloNome(@PathParam("idTipoCardapio") Integer idTipoCardapio){
		try {
			if(null != idTipoCardapio || !"".equals(idTipoCardapio)) {
				this.cardapio.getTipoCardapio().setIdTipoCardapio(idTipoCardapio);
				return cardapioFacade.listarCardapioPeloTipo(this.cardapio.getTipoCardapio());
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O Id do tipo do cardápio é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
}
