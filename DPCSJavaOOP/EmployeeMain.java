/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-16
 * PURPOSE: Searching, sorting, and printing a collection of Employee objects.
 * 			Create an object based on user input via Scanner.
 */

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		
		Employee faisal, danil, ignacio, stranger, user, temp;
		Employee[] myCoders = new Employee[5];

		String uName, uDOB;
		int uAge, uID;
		double uSalary;
		
		faisal = new Employee ("Faisal", 43, "1975-01-18", 57000, 81);
		danil = new Employee ("Danil", 18, "2003-02-24", 14000, 177);
		ignacio = new Employee ("Igancio", 56, "1962-03-16", 38000, 13);
		stranger = new Employee ("Stranger", 65, "1951-07-23");
		
		myCoders[0] = faisal;
		myCoders[1] = danil;
		myCoders[2] = ignacio;
		myCoders[3] = stranger;
		
		
		// 1 - Create an Employee object based on user input
		System.out.println("***CREATE AN EMPLOYEE***");
		System.out.println("Enter name: ");
		uName = s.nextLine();
		System.out.println("Enter age: ");
		uAge = s.nextInt();
		s.nextLine(); // remove \n character
		System.out.println("Enter DOB (yyyy-mm-dd): ");
		uDOB = s.nextLine();
		System.out.println("Enter salary: ");
		uSalary = s.nextDouble();
		s.nextLine(); // remove \n character
		System.out.println("Enter ID number: ");
		uID = s.nextInt();
		s.nextLine(); // remove \n character
		s.close();
		
		user = new Employee (uName, uAge, uDOB, uSalary, uID);
		myCoders[4] = user;
		
		
		// 2 - Print the UNSORTED Employee array for each Employee object.
		System.out.println("\n***UNSORTED***");
		for (int i = 0; i < myCoders.length; i++) {
			System.out.println(myCoders[i]);
		}
		
		
		// 3 - Bubble Sort the array by ID number (smallest to largest - ascending order)
		for (int k = 0; k < myCoders.length; k++) {
			for (int j = 0; j < myCoders.length - k - 1; j++) {
				if (myCoders[j].getID() > myCoders[j+1].getID()) {
					// Swap
					temp = myCoders[j];
					myCoders[j] = myCoders[j+1];
					myCoders[j+1] = temp;
				}
			}
		}
		
		// Print the SORTED BY ID Employee array for each Employee object.
		System.out.println("\n***SORTED BY ID***");
		for (int i = 0; i < myCoders.length; i++) {
			System.out.println(myCoders[i]);
		}
		
		
		// 4 - Bubble Sort the array by SALARY (smallest to largest - ascending order)
		for (int k = 0; k < myCoders.length; k++) {
			for (int j = 0; j < myCoders.length - k - 1; j++) {
				if (myCoders[j].getSalary() > myCoders[j+1].getSalary()) {
					// Swap
					temp = myCoders[j];
					myCoders[j] = myCoders[j+1];
					myCoders[j+1] = temp;
				}
			}
		}
		
		// Print the SORTED BY SALARY Employee array for each Employee object.
		System.out.println("\n***SORTED BY SALARY***");
		for (int i = 0; i < myCoders.length; i++) {
			System.out.println(myCoders[i]);
		}
		
		
		// 5 - Bubble Sort the array by AGE (smallest to largest - ascending order)
		for (int k = 0; k < myCoders.length; k++) {
			for (int j = 0; j < myCoders.length - k - 1; j++) {
				if (myCoders[j].age > myCoders[j+1].age) {
					// Swap
					temp = myCoders[j];
					myCoders[j] = myCoders[j+1];
					myCoders[j+1] = temp;
				}
			}
		}
		
		// Print the SORTED BY SALARY Employee array for each Employee object.
		System.out.println("\n***SORTED BY AGE***");
		for (int i = 0; i < myCoders.length; i++) {
			System.out.println(myCoders[i]);
		}	
		
		
		// 6 - Bubble Sort the array by NAME (alphabetical A to Z)
		for (int k = 0; k < myCoders.length; k++) {
			for (int j = 0; j < myCoders.length - k - 1; j++) {
				if (myCoders[j].name.compareTo(myCoders[j+1].name) > 0) {
					// Swap if name[j] is 'larger' than name[j+1]
					temp = myCoders[j];
					myCoders[j] = myCoders[j+1];
					myCoders[j+1] = temp;
				}
			}
		}
		
		// Print SORTED BY NAME using a formatted String output
		// https://stackoverflow.com/questions/26576909/how-to-format-string-output-so-that-columns-are-evenly-centered/
		System.out.println("\n***SORTED BY NAME (Formatted String Output)***");
		System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "NAME", "AGE", "DOB", "SALARY", "ID");
		System.out.println("------------------------------------------------------------------------------------");
		for (int i = 0; i < myCoders.length; i++) {
			System.out.printf("%-20s%-20d%-20s%-20.2f%-20d\n",
					myCoders[i].name, myCoders[i].age, myCoders[i].dob, 
					myCoders[i].getSalary(), myCoders[i].getID());
		}
		
		
		System.exit(0);
	}
}
