package br.com.buscadorReceitas.propriedades;

public enum TipoArquivoProperties {
	
	MENSAGENS("br/com/buscadorReceitas/propriedades/mensagem.properties"),
	NOME_CAMPOS("br/com/buscadorReceitas/propriedades/nome_campos.properties");
	
	private String caminhoArquivo;
	
	private TipoArquivoProperties(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

}
