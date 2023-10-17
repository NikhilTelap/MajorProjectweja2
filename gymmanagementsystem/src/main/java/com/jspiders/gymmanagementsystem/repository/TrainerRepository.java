package com.jspiders.gymmanagementsystem.repository;

import org.springframework.stereotype.Repository;

import com.jspiders.gymmanagementsystem.pojo.TrainerPOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Repository
public class TrainerRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory =Persistence.createEntityManagerFactory("gym"); 
		manager= factory.createEntityManager();
		transaction = manager.getTransaction();
	
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
			
		}
		if(manager != null) {
			manager.close();
			
		}
		if(transaction != null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	
	public TrainerPOJO Trainer(String name, String email, long contact, int age, String address, String time) {
	
		openConnection();
		transaction.begin();
		
		TrainerPOJO trainer = new TrainerPOJO();
		trainer.setName(name);
		trainer.setAddress(address);
		trainer.setContact(contact);
		trainer.setEmail(email);
		trainer.setTime(time);
		trainer.setAge(age);
		
		manager.persist(trainer);
		
		transaction.commit();
		closeConnection();
		
		return trainer;
	}

}
