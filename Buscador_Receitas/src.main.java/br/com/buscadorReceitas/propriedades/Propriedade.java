package br.com.buscadorReceitas.propriedades;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.buscadorReceitas.exception.IntegrationException;

public class Propriedade {
	
	private static Logger LOGGER = Logger.getLogger(Propriedade.class);
	
	public static Properties getArquivoProperties(TipoArquivoProperties tipoArquivoProperties, Class<?> classe) throws IntegrationException {
		Properties properties;
		try {
			InputStream input = classe.getClassLoader().getResourceAsStream(tipoArquivoProperties.getCaminhoArquivo());
			properties = new Properties();
			properties.load(input);
		} catch (IOException e) {
			LOGGER.error(e);
			throw new IntegrationException(e.getMessage());
		}
		return properties;
	}
	
	public static String getMessageProperties(Properties properties, String campoMensagem, Object ...parametro) {
		if(null != parametro) {
			return MessageFormat.format(properties.getProperty(campoMensagem), parametro);
		}else {
			return properties.getProperty(campoMensagem);
		}
	}
}
