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

import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.usuario.facade.UsuarioFacade;
import br.com.buscadorReceitas.usuario.util.ValidarUsuario;

@Path("/usuario/v1")
public class UsuarioService implements Serializable {
	
	private static final long serialVersionUID = -2146630286732250331L;
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);
	
	@Inject
	private UsuarioFacade usuarioFacade;
	@Inject
	private Usuario usuario;
	
	
	@Path("/inserirUsuario")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
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
	@Produces(MediaType.APPLICATION_JSON)
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(Usuario usuario){
		ResponseBuilder response = null;
		try {
			ValidarUsuario validacao = new ValidarUsuario();
			validacao.validar(usuario, "alterar");
			usuarioFacade.alterar(usuario);
			response = Response.ok("alterado com sucesso", MediaType.APPLICATION_JSON).status(201);
			
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			response = Response.serverError().status(500);
			return response.build();
		}
		return response.build();
		
	}

	
	

}
