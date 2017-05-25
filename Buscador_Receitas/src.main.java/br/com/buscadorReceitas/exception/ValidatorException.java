package br.com.buscadorReceitas.exception;

public class ValidatorException extends Exception {

	private static final long serialVersionUID = -8167492082305125686L;
	
	private String message;
	
	public ValidatorException(String mensagem) {
		super(mensagem);
		this.message = mensagem;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
