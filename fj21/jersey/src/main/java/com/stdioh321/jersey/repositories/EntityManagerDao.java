package com.stdioh321.jersey.repositories;

import java.util.concurrent.Callable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stdioh321.jersey.entities.User;
import com.stdioh321.jersey.interfaces.ExecWithEntityManager;

import javassist.tools.Callback;

public class EntityManagerDao {

	private static EntityManagerDao instance;

	public static EntityManagerDao getIstance() {
		if (instance == null)
			instance = new EntityManagerDao();
		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething");
	}
	
	public void defaultAction(String puName, boolean doCommit, ExecWithEntityManager ewem){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(puName);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		ewem.exec(em);
		
		if (doCommit == true)
			em.getTransaction().commit();
		em.close();
		emf.close();
	}
}

