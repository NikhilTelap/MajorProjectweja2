package com.jspiders.springrest.repository;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest.pojo.AdminPOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory= Persistence.createEntityManagerFactory("REST");
		manager=factory.createEntityManager() ;
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction!= null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	public AdminPOJO createAccount(AdminPOJO pojo) {

		openConnection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		
		return pojo;
	}
	
	public AdminPOJO login(AdminPOJO pojo) {
		openConnection();
		transaction.begin();
		
		AdminPOJO admin = manager.find(AdminPOJO.class, pojo.getUsername());
		
		if(admin != null) {
			if(admin.getPassword().equals(pojo.getPassword())) {
				transaction.commit();
				closeConnection();
				return admin;
			}
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}
	
	

}
