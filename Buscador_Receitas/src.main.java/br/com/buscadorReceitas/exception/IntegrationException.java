package br.com.buscadorReceitas.exception;

public class IntegrationException extends Exception {

	private static final long serialVersionUID = 7552970845918099285L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IntegrationException(String message) {
		super(message);
	}
	
	public IntegrationException(Exception ex) {
		super(ex);
	}
	
}
