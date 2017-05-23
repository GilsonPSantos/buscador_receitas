package br.com.buscadorReceitas.testes;

import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.usuario.dao.UsuarioDaoImpl;

public class TesteUsuario {
	
	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setIdUsuario(1);
//		u.setNome("Gilson");
//		u.setEmail("g@gmail");
//		u.setSenha("123");
//		u.setAtivo(1);
		
		try {
//			new UsuarioDaoImpl().inserir(u);
			u = new UsuarioDaoImpl().buscarPeloCodigo(u);
			System.out.println(u);
//			System.out.println(new UsuarioDaoImpl().listar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
