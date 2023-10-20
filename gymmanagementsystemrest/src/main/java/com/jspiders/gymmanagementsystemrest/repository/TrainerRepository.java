package com.jspiders.gymmanagementsystemrest.repository;

import org.springframework.stereotype.Repository;

import com.jspiders.gymmanagementsystemrest.pojo.TrainerPOJO;
import com.jspiders.gymmanagementsystemrest.response.TrainerResponse;

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
		factory = Persistence.createEntityManagerFactory("gms");
		manager = factory.createEntityManager();
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

	public TrainerPOJO addTrainer(TrainerPOJO pojo) {

		openConnection();
		transaction.begin();
		
		TrainerPOJO trainer = new TrainerPOJO();
		trainer.setName(pojo.getName());
		trainer.setEmail(pojo.getEmail());
		trainer.setAddress(pojo.getAddress());
		trainer.setContact(pojo.getContact());
		trainer.setAge(pojo.getAge());
		trainer.setTime(pojo.getTime());
		
		manager.persist(trainer);
		transaction.commit();
		closeConnection();
		
		
		
		return trainer;
	}

	
}
