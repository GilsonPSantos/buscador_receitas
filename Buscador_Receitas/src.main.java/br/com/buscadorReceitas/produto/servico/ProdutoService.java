package br.com.buscadorReceitas.produto.servico;

import java.io.Serializable;
import java.util.List;

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
import br.com.buscadorReceitas.model.Grupo;
import br.com.buscadorReceitas.model.Produto;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.produto.facade.ProdutoFacade;
import br.com.buscadorReceitas.produto.util.ValidadorProduto;
import br.com.buscadorReceitas.usuario.util.TratarRetornoServico;
import br.com.buscadorReceitas.util.Constante;

@Path("/produto/v1")
public class ProdutoService implements Serializable{

	private static final long serialVersionUID = 9185969910075146376L;
	private static final Logger LOGGER = Logger.getLogger(ProdutoService.class);
	
	@Inject
	private ProdutoFacade produtoFacade;
	@Inject
	private Produto produto;
	@Inject
	private RetornoServico retornoServico;
	@Inject
	private TratarRetornoServico tratarRetornoServico;
	@Inject
	private Grupo grupo;
	
	@Path("/inserirProduto")
	@POST
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico inserir(Produto produto){
		try {
			ValidadorProduto validacao = new ValidadorProduto();
			validacao.validar(produto, "inserir");
			produtoFacade.inserir(produto);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "inserir", produto.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			ex.printStackTrace();
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/alterarProduto")
	@PUT
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public RetornoServico alterar(Produto produto){
		try {
			ValidadorProduto validacao = new ValidadorProduto();
			validacao.validar(produto, "alterar");
			produtoFacade.alterar(produto);
			tratarRetornoServico.tratarRetornoSucesso(retornoServico, "alterar",produto.getClass());
		}catch (ValidatorException validatorException) {
			LOGGER.error(validatorException.getMessage());
			tratarRetornoServico.tratarRetornoError(validatorException, retornoServico);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
		}
		return retornoServico;
	}
	
	@Path("/buscarProdutoPeloId/{id}")
	@GET
	@Consumes(Constante.MEDIA_TYPE_JSON)
	@Produces(Constante.MEDIA_TYPE_JSON)
	public Object consultarProdutoPeloId(@PathParam(value="id") Integer idProduto){
		try {
			if(null != idProduto || !"".equals(idProduto)) {
				produto.setIdProduto(idProduto);
				produto = produtoFacade.buscarPeloCodigo(produto);
				return produto;
			}else {
				retornoServico.equals(500);
				retornoServico.adicionarMensagem("O id do produto é campo obrigatório.");
				return retornoServico;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return retornoServico;
		}
	}
	
	@Path("/listarProdutos")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public List<Produto> listar(){
		try {
				return produtoFacade.listar();
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return null;
		}
	}
	
	@Path("/listarProdutosPeloGrupo/{id}")
	@GET
	@Produces(Constante.MEDIA_TYPE_JSON)
	public List<Produto> listarProdutosPeloGrupo(@PathParam(value="id") Integer idGrupo){
		try {
				grupo.setIdGrupo(idGrupo);
				return produtoFacade.listarProdutosPeloGrupo(grupo);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			tratarRetornoServico.tratarRetornoError(ex, retornoServico);
			return null;
		}
	}
	
	

}
