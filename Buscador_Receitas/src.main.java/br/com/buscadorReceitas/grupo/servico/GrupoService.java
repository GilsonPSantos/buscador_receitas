package br.com.buscadorReceitas.grupo.servico;

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
import br.com.buscadorReceitas.grupo.facade.GrupoFacade;
import br.com.buscadorReceitas.grupo.util.ValidadorGrupo;
import br.com.buscadorReceitas.model.Grupo;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.usuario.util.TratarRetornoServico;
import br.com.buscadorReceitas.util.Constante;

@Path("/grupo/v1")
public class GrupoService implements Serializable {

	private static final long serialVersionUID = 6146645344301255121L;
	private static final Logger LOGGER = Logger.getLogger(GrupoService.class);
	
	@Inject
	private GrupoFacade grupoFacade;
	@Inject
	private Grupo grupo;
	@Inject
	private RetornoServico retornoServico;
	@Inject
	private TratarRetornoServico tratarRetornoServico;
	
	@Path("/inserirGrupo")
	@POST
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico inserir(Grupo grupo){
		try {
			ValidadorGrupo validacao = new ValidadorGrupo();
			validacao.validar(grupo, "inserir");
			grupoFacade.inserir(grupo);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "inserir", grupo.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/alterarGrupo")
	@PUT
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico alterar(Grupo grupo){
		try {
			ValidadorGrupo validacao = new ValidadorGrupo();
			validacao.validar(grupo, "alterar");
			grupoFacade.alterar(grupo);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "alterar",grupo.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/buscarGrupoPeloId/{id}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object consultarUsuarioPeloId(@PathParam(value="id") Integer idGrupo){
		try {
			if(null != idGrupo || !"".equals(idGrupo)) {
				grupo.setIdGrupo(idGrupo);
				grupo = grupoFacade.buscarPeloCodigo(grupo);
				return grupo;
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O id do grupo é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	@Path("/listarGrupos")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listar(){
		try {
				return grupoFacade.listar();
				
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	
	

}
