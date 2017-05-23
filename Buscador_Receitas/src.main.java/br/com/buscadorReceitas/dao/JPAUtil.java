package br.com.buscadorReceitas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("buscadorReceitas");
	

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
