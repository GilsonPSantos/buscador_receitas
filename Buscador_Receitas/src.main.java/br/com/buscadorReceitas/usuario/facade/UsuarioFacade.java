package br.com.buscadorReceitas.usuario.facade;

import java.util.List;

import br.com.buscadorReceitas.model.Usuario;

public interface UsuarioFacade {
	
	public void inserir(Usuario usuario) throws Exception;
	
	public void alterar(Usuario usuario) throws Exception;
	
	public void excluir(Usuario usuario) throws Exception;
	
	public List<Usuario> listar() throws Exception;
	
	public Usuario buscarPeloCodigo(Usuario usuario) throws Exception;

}
