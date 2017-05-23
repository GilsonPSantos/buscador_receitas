package br.com.buscadorReceitas.validator;

import java.lang.reflect.Field;
import java.util.List;

import javax.xml.bind.ValidationException;

public class Validador {
	
	private List<Regra> listaRegras;
	
	public void validarCampos (Class classe, List<Regra> regrasValidacao) throws ValidationException {
		
		Field[] fields = classe.getFields();
		
		
		
		
		
		
		
	}

}
