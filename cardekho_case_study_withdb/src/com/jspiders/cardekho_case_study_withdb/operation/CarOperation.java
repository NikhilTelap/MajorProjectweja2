package com.jspiders.cardekho_case_study_withdb.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study_withdb.entity.Car;

public class CarOperation{
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static int result;
	private static Properties properties = new Properties();
	private static String filePath = "D:\\WEJA2\\jdbc\\resources\\db_info.properties";
	private static String query;
	private static  FileInputStream file;
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static 	Scanner scanner = new Scanner(System.in);
	private Car car = new Car();
	
	private static void openConnection() {
		try {
		file=new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty(driverPath));

			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			statement=connection.createStatement();
			
		}
		catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
	
	private static void closeConnection() {
		try {
			if(connection !=null) {
				connection.close();
				
			}
			if(statement !=null) {
				statement.close();
			}
			if(resultSet !=null) {
				resultSet.close();
			}
			if(file !=null) {
				file.close();
			}
			if(result !=0) {
				result=0;
			
		}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private static void createTable() {
		
		try {
			
			query="CREATE TABLE car_info(car_id INT,name VARCHAR(50) NOT NULL,brand VARCHAR(50),fuel_type VARCHAR(50),price INT NOT NULL ,PRIMARY KEY(car_id));";
			result=statement.executeUpdate(query);
			System.out.println(result+"rows affected");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
	
	public static void selectRecords() {
		try {
			openConnection();
				query="select * from car_info";
		resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		}
	
	public void addCarDetails() {
		try {
			
		
				createTable();
		
		System.out.println("How many cars you want to add");
		int choice=scanner.nextInt();
		
		for(int i=1;i<=choice;i++) {
			
			openConnection();

			System.out.println("Enter car id");
			car.setCar_id(scanner.nextInt());
			
			System.out.println("Enter car name:");
			car.setName(scanner.next());
			
			System.out.println("Enter car brand:");
				car.setBrand(scanner.next());

				System.out.println("Enter car fuel type");
				car.setFuel_type(scanner.next());
				
				System.out.println("Enter car price");
				car.setCar_id(scanner.nextInt());
				
				
				connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
				query="insert into car_info values("+car.getCar_id()+"','"+car.getName()+"','"+car.getBrand()+"','"+car.getFuel_type()+"',"+car.getPrice()+")";
				
				statement.executeUpdate(query);
				System.out.println("car added successfully!!");
		}
		selectRecords();
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
			
		}
	}
	
	public static void removeCarDetails() {
		try {
			selectRecords();
			openConnection();
	
			
			System.out.println("Enter id of record you want to delete");
			int id1=scanner.nextInt();
			query="DELETE FROM car_info WHERE car_id= "+id1;
				result=statement.executeUpdate(query);
				if(result >=0) {
					System.out.println("Record is deleted");
				}
					else {
						System.out.println("Entered car record is not present");
					}
				}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
	
	public static void searchByCarId() {
		try {
			openConnection();
			System.out.println("Enter car id you want to search");
			int car_id=scanner.nextInt();
				query="select * from car_info WHERE car_id is "+car_id;
		resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		}
		
	
	public static void searchByName() {
		try {
			openConnection();
			System.out.println("Enter car name you want to search");
			String name=scanner.next();
				query="select * from car_info WHERE name is "+name;
		resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		}

	public static void searchByBrand() {
		try {
			openConnection();
			System.out.println("Enter car brand you want to search");
			String brand=scanner.next();
				query="select * from car_info WHERE  brand is"+brand;
		resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		}

	public static void searchByPrice() {
		try {
			openConnection();
			System.out.println("Enter fuel type you want to search");
			int  price=scanner.nextInt();
				query="select * from car_info WHERE price is"+price;
		resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		}
	
	public static void searchByFuelType() {
		try {
			openConnection();
			System.out.println("Enter car brand you want to search");
			String fuelType=scanner.next();
				query="select * from car_info WHERE  fuel_type is"+fuelType;
		resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		}

	
public static void editCarDetails() {
	
	try {
		selectRecords();
		
		System.out.println("Enter car_id of caryou want to update ");
		int car_id=scanner.nextInt();
		
		System.out.println("Enter record(Field) you want to update");
		String record = scanner.next();
		
		System.out.println("Enter the updated value");
		String updatedValue= scanner.next();
		
		query="UPDATE car_info SET ("+record+","+updatedValue+")"+"WHERE "+record+"="+car_id;
		result=statement.executeUpdate(query);
		System.out.println(result+"rows affected");
		System.out.println("Record has been updated");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally {
		closeConnection();
	}
	}
}



	
	







