package br.com.buscadorReceitas.usuario.util;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.buscadorReceitas.exception.IntegrationException;
import br.com.buscadorReceitas.model.RetornoServico;
import br.com.buscadorReceitas.propriedades.Propriedade;
import br.com.buscadorReceitas.propriedades.TipoArquivoProperties;
import br.com.buscadorReceitas.util.Constante;

public class TratarRetornoServico {

	private static final Logger LOGGER = Logger.getLogger(TratarRetornoServico.class);

	private Properties propertiesMensagens;

	public void tratarRetornoError(Exception ex, RetornoServico retornoServico) {

		try {
			propertiesMensagens = Propriedade.getArquivoProperties(TipoArquivoProperties.MENSAGENS, getClass());
			retornoServico.setCodigo(500);
			retornoServico.setMensagem(new ArrayList<String>());
			retornoServico.getMensagem().add(ex.getMessage());
		} catch (IntegrationException integrationException) {
			LOGGER.error(integrationException.getMessage());
		}

		
	}

	public void tratarRetornoSucesso(RetornoServico retornoServico) {
		try {
			propertiesMensagens = Propriedade.getArquivoProperties(TipoArquivoProperties.MENSAGENS, getClass());
			retornoServico.setCodigo(201);
			retornoServico.setMensagem(new ArrayList<String>());
			retornoServico.getMensagem().add(
					Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_ALTERADO_SUCESSO, null));
		} catch (IntegrationException integrationException) {
			LOGGER.error(integrationException.getMessage());
		}
	}

}
