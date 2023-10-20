package com.jspiders.gymmanagementsystemrest.repository;

import org.springframework.stereotype.Repository;

import com.jspiders.gymmanagementsystemrest.pojo.CustomerPOJO;

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
	public CustomerPOJO addCustomer(CustomerPOJO pojo) {

		openConnection();
		transaction.begin();
		
		CustomerPOJO customer = new CustomerPOJO();
		customer.setName(pojo.getName());
		customer.setEmail(pojo.getEmail());
		customer.setAddress(pojo.getAddress());
		customer.setContact(pojo.getContact());
		customer.setAge(pojo.getAge());
		customer.setTime(pojo.getTime());

		manager.persist(customer);
		transaction.commit();
		closeConnection();
		return customer;
	}

}
