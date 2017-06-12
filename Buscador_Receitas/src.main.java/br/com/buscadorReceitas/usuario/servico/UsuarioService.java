package br.com.buscadorReceitas.usuario.servico;


import java.io.Serializable;
import java.util.Properties;

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
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.usuario.facade.UsuarioFacade;
import br.com.buscadorReceitas.usuario.util.ValidadorUsuario;
import br.com.buscadorReceitas.util.Constante;
import br.com.buscadorReceitas.util.TratarRetornoServico;

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
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico inserir(Usuario usuario){
		try {
			ValidadorUsuario validacao = new ValidadorUsuario();
			validacao.validar(usuario, "inserir");
			usuarioFacade.inserir(usuario);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "inserir", usuario.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
		
	}
	
	@Path("/alterarUsuario")
	@PUT
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico alterar(Usuario usuario){
		try {
			ValidadorUsuario validacao = new ValidadorUsuario();
			validacao.validar(usuario, "alterar");
			usuarioFacade.alterar(usuario);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico,"alterar", usuario.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/buscarUsuarioPeloId/{id}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object consultarUsuarioPeloId(@PathParam(value="id") Integer idUsuario){
		try {
			if(null != idUsuario || !"".equals(idUsuario)) {
				usuario.setIdUsuario(idUsuario);
				usuario = usuarioFacade.buscarPeloCodigo(usuario);
				return usuario;
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O id do usuario é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	@Path("/buscarUsuarioPeloLogin/{email}/{senha}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object consultarUsuarioPeloLogin(@PathParam(value="email") String email, @PathParam(value="senha") String senha){
		try {
			this.usuario.setEmail(email);
			this.usuario.setSenha(senha);
			ValidadorUsuario validacao = new ValidadorUsuario();
			validacao.validar(usuario, "login");
			this.usuario = usuarioFacade.buscarPeloLogin(usuario);
			return usuario;
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
			return retornoServico;
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	
	@Path("/listarUsuarios")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object listar(){
		try {
				return usuarioFacade.listar();
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	

}
