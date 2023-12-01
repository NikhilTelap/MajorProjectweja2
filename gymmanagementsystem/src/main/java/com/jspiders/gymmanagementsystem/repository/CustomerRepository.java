package com.jspiders.gymmanagementsystem.repository;

import org.springframework.stereotype.Repository;

import com.jspiders.gymmanagementsystem.pojo.CustomerPOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Repository
public class CustomerRepository {
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
	
	
	public CustomerPOJO Customer(String name, String email, long contact, int age, String address, String time) {

		openConnection();
		transaction.begin();
		CustomerPOJO customer = new CustomerPOJO();
		customer.setName(name);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setAge(age);
		customer.setContact(contact);
		customer.setTime(time);
		
		manager.persist(customer);
		transaction.commit();
		closeConnection();
		
		
		return customer;
	}

}
