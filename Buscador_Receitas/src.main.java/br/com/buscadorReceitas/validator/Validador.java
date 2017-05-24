package br.com.buscadorReceitas.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import antlr.StringUtils;

public class Validador {

	private List<Regra> listaRegras;

	private List<String> listaErros;

	public void validarCampos(Serializable classe, List<Regra> regrasValidacao) throws ValidationException {
		String valor="";
		boolean numerico;
		listaErros = new ArrayList<String>();
		try {
			for (Regra regra : regrasValidacao) {

				if (String.class.equals(regra.getCampo().getType())) {
					valor = (String) regra.getCampo().get(classe);
				}else if(Integer.class.equals(regra.getCampo().getType())) {
					valor = String.valueOf((Integer) regra.getCampo().get(classe));
				}
				
				if(!regra.getCampoNulo()) {
					if(null == regra.getCampo().get(classe) || "".equals(valor)) {
						listaErros.add(regra.getMensagemCampoNulo());
					}
				}
				
				if(null == regra.getCampo().get(classe) && regra.getTamanhoMaximo() > valor.length()) {
					listaErros.add(regra.getMensagemTamanhoMaximo());
				}
				
				if(null == regra.getCampo().get(classe) && regra.getTamanhoMinimo() < valor.length()) {
					listaErros.add(regra.getMensagemTamanhoMinimo());
				}
			}

		} catch (IllegalArgumentException e) {
			
		} catch (IllegalAccessException e) {
			
		}

	}
}
