package br.com.buscadorReceitas.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {
	
	public static void main(String[] args) {
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("buscadorReceitas");
			entityManagerFactory.createEntityManager();
			
			
//			manager.getTransaction().begin();
//			Produto p = new Produto();
//			p.setCodigoBarras("123");
//			p.setNome("Teste");
//			Grupo g = new Grupo();
//			g.setNome("GrupoTeste");
//			p.setGrupo(g);
//			List<Produto> lista = new ArrayList<Produto>();
//			lista.add(p);
//			g.setListaProdutos(lista);
			
//			manager.persist(g);
//			manager.persist(p);
//			
//			manager.getTransaction().commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
