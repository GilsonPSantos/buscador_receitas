package br.com.buscadorReceitas.usuario.facade;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.buscadorReceitas.exception.IntegrationException;
import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.propriedades.Propriedade;
import br.com.buscadorReceitas.propriedades.TipoArquivoProperties;
import br.com.buscadorReceitas.usuario.dao.UsuarioDao;
import br.com.buscadorReceitas.usuario.servico.UsuarioService;
import br.com.buscadorReceitas.util.Constante;
import br.com.buscadorReceitas.util.Criptografia;

public class UsuarioFacadeImpl implements UsuarioFacade{
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioFacadeImpl.class);
	
	@Inject
	private UsuarioDao usuarioDao;
	
	private Properties properties;

	@Override
	public void inserir(Usuario usuario) throws Exception {
		usuario.setAtivo(1);
		try {
			Criptografia.criptografarSenha(usuario);
		} catch (IntegrationException ex) {
			LOGGER.error(ex);
			properties = Propriedade.getArquivoProperties(TipoArquivoProperties.MENSAGENS, Usuario.class);
			throw new IntegrationException(Propriedade.getMessageProperties(properties, Constante.ERRO_INTERNO, null));
		}
		usuarioDao.inserir(usuario);
	}

	@Override
	public void alterar(Usuario usuario) throws Exception {
		usuarioDao.alterar(usuario);
	}

	@Override
	public void excluir(Usuario usuario) throws Exception {
		usuario.setAtivo(0);
		usuarioDao.excluir(usuario);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		return usuarioDao.listar();
	}

	@Override
	public Usuario buscarPeloCodigo(Usuario usuario) throws Exception {
		return usuarioDao.buscarPeloCodigo(usuario);
	}

	@Override
	public Usuario buscarPeloLogin(Usuario usuario) throws Exception {
		try {
			Criptografia.criptografarSenha(usuario);
		} catch (IntegrationException ex) {
			LOGGER.error(ex);
			properties = Propriedade.getArquivoProperties(TipoArquivoProperties.MENSAGENS, Usuario.class);
			throw new IntegrationException(Propriedade.getMessageProperties(properties, Constante.ERRO_INTERNO, null));
		}
		return usuarioDao.buscarPeloLogin(usuario);
	}

}
