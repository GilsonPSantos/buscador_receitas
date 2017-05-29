package br.com.buscadorReceitas.validator;

import java.io.Serializable;
import java.util.List;

import br.com.buscadorReceitas.exception.ValidatorException;


public class Validador {

	private List<Regra> listaRegras;

	private StringBuilder listaErros;

	public void validarCampos(Serializable classe, List<Regra> regrasValidacao) throws ValidatorException {
		String valor="";
		boolean numerico = false;
		listaErros = new StringBuilder();
		try {
			for (Regra regra : regrasValidacao) {
				
				regra.getCampo().setAccessible(true);
				
				if (String.class.equals(regra.getCampo().getType())) {
					valor = (String) regra.getCampo().get(classe);
				}else if(Integer.class.equals(regra.getCampo().getType())) {
					valor = String.valueOf((Integer) regra.getCampo().get(classe));
					numerico = true;
				}
				
				if(!regra.getCampoNulo()) {
					if(null == regra.getCampo().get(classe) || "".equals(valor)) {
						listaErros.append(regra.getMensagemCampoNulo());
					}
				}
				
				if(!numerico) {
					
					if(null != regra.getCampo().get(classe) && regra.getTamanhoMaximo() < valor.length()) {
						listaErros.append(regra.getMensagemTamanhoMaximo());
					}
					
					if(null != regra.getCampo().get(classe) && regra.getTamanhoMinimo() > valor.length()) {
						listaErros.append(regra.getMensagemTamanhoMinimo());
					}
				}
			}
			
			if(listaErros.length() > 0) {
				throw new ValidatorException(listaErros.toString());
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}
