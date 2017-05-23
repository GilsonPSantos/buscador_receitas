package br.com.buscadorReceitas.testes;

import java.util.Calendar;

import br.com.buscadorReceitas.cardapio.dao.CardapioDaoImpl;
import br.com.buscadorReceitas.model.Cardapio;
import br.com.buscadorReceitas.model.TipoCardapio;
import br.com.buscadorReceitas.model.Usuario;
import br.com.buscadorReceitas.usuario.dao.UsuarioDaoImpl;

public class testeCardapio {
	
	public static void main(String[] args) {
		try {
			Cardapio c = new Cardapio();
			c.setAtivo(1);
			c.setDataAtualizacao(Calendar.getInstance());
			c.setNome("chocolate");
			
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			u = new UsuarioDaoImpl().buscarPeloCodigo(u);
			
			System.out.println(u);
			
			TipoCardapio tipo = new TipoCardapio();
			tipo.setIdTipoCardapio(1);
			c.setUsuarioResponsavel(u);
			
			new CardapioDaoImpl().inserir(c);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
