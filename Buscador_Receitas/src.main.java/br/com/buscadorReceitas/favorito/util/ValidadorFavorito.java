package br.com.buscadorReceitas.favorito.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.ValidationException;

import br.com.buscadorReceitas.cardapio.util.ConstanteCardapio;
import br.com.buscadorReceitas.exception.IntegrationException;
import br.com.buscadorReceitas.exception.ValidatorException;
import br.com.buscadorReceitas.model.Favorito;
import br.com.buscadorReceitas.propriedades.Propriedade;
import br.com.buscadorReceitas.propriedades.TipoArquivoProperties;
import br.com.buscadorReceitas.usuario.util.ConstanteUsuario;
import br.com.buscadorReceitas.util.Constante;
import br.com.buscadorReceitas.validator.Regra;
import br.com.buscadorReceitas.validator.Validador;

public class ValidadorFavorito {
	
	private Properties propertiesCampos;
	private Properties propertiesMensagens;
	
	private List<Regra> listaRegras;
	
	public void validar(Favorito favorito, String acao) throws ValidatorException, IOException, ValidationException {
		listaRegras = new ArrayList<Regra>();
		try {
			propertiesCampos = Propriedade.getArquivoProperties(TipoArquivoProperties.NOME_CAMPOS, getClass());
			propertiesMensagens = Propriedade.getArquivoProperties(TipoArquivoProperties.MENSAGENS,getClass());
			Regra regra = new Regra();
			
				regra.setCampo(favorito.getUsuarioCardapioPK().getClass().getDeclaredField("idCardapio"));
				regra.setCampoNulo(false);
				regra.setNomeCampo(Propriedade.getMessageProperties(propertiesCampos, ConstanteCardapio.NOME_CAMPO_ID_CARDAPIO));
				regra.setTamanhoMaximo(null);
				regra.setTamanhoMinimo(1);
				regra.setMensagemCampoNulo(Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_CAMPO_NULO, regra.getNomeCampo()));
				regra.setMensagemTamanhoMaximo(Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_TAMANHO_MAXIMO, regra.getNomeCampo(),regra.getTamanhoMaximo()));
				regra.setMensagemTamanhoMinimo(Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_TAMANHO_MINIMO,regra.getNomeCampo(),regra.getTamanhoMinimo() ));
				listaRegras.add(regra);
				
				regra = new Regra();
				regra.setCampo(favorito.getUsuarioCardapioPK().getClass().getDeclaredField("idUsuario"));
				regra.setCampoNulo(false);
				regra.setNomeCampo(Propriedade.getMessageProperties(propertiesCampos, ConstanteUsuario.NOME_CAMPO_ID_USUARIO));
				regra.setTamanhoMaximo(null);
				regra.setTamanhoMinimo(1);
				regra.setMensagemCampoNulo(Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_CAMPO_NULO, regra.getNomeCampo()));
				regra.setMensagemTamanhoMaximo(Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_TAMANHO_MAXIMO, regra.getNomeCampo(),regra.getTamanhoMaximo()));
				regra.setMensagemTamanhoMinimo(Propriedade.getMessageProperties(propertiesMensagens, Constante.MENSAGEM_TAMANHO_MINIMO,regra.getNomeCampo(),regra.getTamanhoMinimo() ));
				listaRegras.add(regra);
			
			Validador valida = new Validador();
			valida.validarCampos(favorito.getUsuarioCardapioPK(), listaRegras);
			
		} catch (NoSuchFieldException | SecurityException | IntegrationException e) {
			e.printStackTrace();
		}
		
	}

	

}
