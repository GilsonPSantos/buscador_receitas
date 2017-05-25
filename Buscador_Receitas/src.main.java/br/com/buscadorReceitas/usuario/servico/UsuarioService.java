package br.com.buscadorReceitas.usuario.servico;


import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

import br.com.buscadorReceitas.exception.ValidatorException;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.usuario.facade.UsuarioFacade;
import br.com.buscadorReceitas.usuario.util.TratarRetornoServico;
import br.com.buscadorReceitas.usuario.util.ValidarUsuario;
import br.com.buscadorReceitas.util.Constante;

@Path("/usuario/v1")
public class UsuarioService implements Serializable {
	
	private static final long serialVersionUID = -2146630286732250331L;
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);
	
	@Inject
	private UsuarioFacade usuarioFacade;
	@Inject
	private Usuario usuario;
	@Inject
	private RetornoServico retornoServico;
	@Inject
	private TratarRetornoServico tratarRetornoServico;
	
	@Path("/inserirUsuario")
	@POST
	@Consumes(Constante.MEDIA_TYPE_JSON)
	public Response inserir(Usuario usuario){
		try {
			usuarioFacade.inserir(usuario);
			
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return Response.ok().build();
		
	}
	
	@Path("/getUsuarioById/{id}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Usuario consultarUsuarioPeloId(@PathParam(value="id") Integer idUsuario){
		try {
			usuario.setIdUsuario(idUsuario);
			usuario = usuarioFacade.buscarPeloCodigo(usuario);
			return usuario;
			
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return null;
	}
	
	@Path("/alterarUsuario")
	@PUT
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico alterar(Usuario usuario){
		try {
			ValidarUsuario validacao = new ValidarUsuario();
			validacao.validar(usuario, "alterar");
			usuarioFacade.alterar(usuario);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico);
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	

}
