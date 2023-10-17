package com.jspiders.cardekho_case_study_withdb.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study_withdb.operation.CarOperation;

public class CarDekhoMenu {
	
	static CarOperation operation = new CarOperation();
	static boolean loop=true;
	
	public static void main(String[] args) {
		
	
	while(loop) {
		carDekhoMenu();
		
	}
	}
	private static void carDekhoMenu() {
		
		System.out.println("=====MENU====\n"+
							"1.Add Car Details\n"+
							"2.Remove Car Details\n"+
							"3.Search Car Details\n"+
							"4.Edit Car Details\n"+
							"5.Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Enter your choice:");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1: 
				operation.addCarDetails();
				break;
		case 2:
				operation.removeCarDetails();
				break;
		case 3:
			System.out.println("===========MENU==========\n"
					+ "1. Search Car By car_id \n"
					+ "2. Search Car By car name \n"
					+ "3. Search Car By car brand \n"
					+"4. Search Car by fuelType"
					+"5.search Car by price"
					+ "6. Search All Cars \n");
						int choice2 = scanner.nextInt();
							switch(choice2) {
									case 1:
											operation.searchByCarId();
											break;
									case 2:
											operation.searchByName();
											break;
									case 3:
											operation.searchByBrand();
											break;
											
									case 4:	operation.searchByFuelType();
											break;
									case 5:operation.searchByPrice();
											break;
									case 6:
										operation.selectRecords();
										break;
								
									default:
										System.out.println("\nInvalid choice. Try again..!!");
										break;
							}
										break;
		case 4:
			operation.editCarDetails();
				break;
		case 5:	
				System.out.println("Thank you !! Visit again..");
				loop=false;
				scanner.close();
				break;
				
				
		default:System.out.println("Enter valid choice");
		
		}

}
}
