package br.com.buscadorReceitas.tipo_cardapio.servico;

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

import br.com.buscadorReceitas.exception.ValidatorException;
import br.com.buscadorReceitas.grupo.servico.GrupoService;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.model.TipoCardapio;
import br.com.buscadorReceitas.tipo_cardapio.facade.TipoCardapioFacade;
import br.com.buscadorReceitas.tipo_cardapio.util.ValidadorTipoCardapio;
import br.com.buscadorReceitas.util.Constante;
import br.com.buscadorReceitas.util.TratarRetornoServico;

@Path("/tipo_cardapio/v1")
public class TipoCardapioService implements Serializable{

	private static final long serialVersionUID = 1964676733802188596L;
	private static final Logger LOGGER = Logger.getLogger(GrupoService.class);
	
	@Inject
	private TipoCardapioFacade tipoCardapioFacade;
	@Inject
	private TipoCardapio tipoCardapio;
	@Inject
	private RetornoServico retornoServico;
	@Inject
	private TratarRetornoServico tratarRetornoServico;
	
	@Path("/inserirTipoCardapio")
	@POST
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico inserir(TipoCardapio tipoCardapio){
		try {
			ValidadorTipoCardapio validacao = new ValidadorTipoCardapio();
			validacao.validar(tipoCardapio, "inserir");
			tipoCardapioFacade.inserir(tipoCardapio);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "inserir", tipoCardapio.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/alterarTipoCardapio")
	@PUT
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico alterar(TipoCardapio tipoCardapio){
		try {
			ValidadorTipoCardapio validacao = new ValidadorTipoCardapio();
			validacao.validar(tipoCardapio, "alterar");
			tipoCardapioFacade.alterar(tipoCardapio);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "alterar",tipoCardapio.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	

	@Path("/buscarTipoCardapioPeloId/{id}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object consultarTipoCardapioPeloId(@PathParam(value="id") Integer idTipoCardapio){
		try {
			if(null != idTipoCardapio || !"".equals(idTipoCardapio)) {
				tipoCardapio.setIdTipoCardapio(idTipoCardapio);
				tipoCardapio = tipoCardapioFacade.buscarPeloCodigo(tipoCardapio);
				return tipoCardapio;
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O id do Tipo do Cardápio é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	@Path("/listarTipoCardapio")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listar(){
		try {
				return tipoCardapioFacade.listar();
				
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	

}
