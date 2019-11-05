
/*
 * Mike Poirier
 * November 4, 2019
 * 
 * Purpose:	Provide examples of how Java handles file input and output
 * 			Importance of IOExceptions when handling file input and output
 * 			How to use a comma separated value (.csv) file, generated from mockaroo.com
 * 
 * 			Also provides a Linked List and OOP example with the Employee and Person classes
 */

import java.io.IOException;

import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;

public class FileIOTest {

	public static void main(String[] args) throws IOException { // Need to throw IOE when reading or creating a file
		
		/*
		 * FILE INPUT
		 * IB Java Examination Tool Subset (JETS):
		 * br.ready(), br.read(), br.readLine(), br.close()
		 */
		
		LinkedList<Employee> myCompany = new LinkedList<Employee>(); // LinkedList of Employee objects
		Random r = new Random(); // Used to provide a random salary
		
		Employee myEmployee;
		String line;
		
		FileReader fr = new FileReader("MOCK_DATA.csv"); 
        BufferedReader br = new BufferedReader(fr);

        if (br.ready()) {
        	br.readLine(); // ignore first line of .csv file (category listing)
        	
        	while ((line = br.readLine()) != null) {
        		String[] data = line.split(","); // split each data members in the .csv file, and store in data[]
        		int salary = r.nextInt(10) * 10000;  // random salary
        		
        		myEmployee = new Employee (data[0], data[1], data[2], data[3], data[4], salary); // create Employee object
        		
        		myCompany.add(myEmployee); // add Employee object to the LinkedList
        	}
        }
        br.close();
		
        
    	/*
		 * FILE OUPUT
		 * IB Java Examination Tool Subset (JETS):
		 * pw.print(), pw.println(), pw.close()
		 */
        
		FileWriter fw = new FileWriter("OUTPUT.txt");
		PrintWriter pw = new PrintWriter(fw);
        
        System.out.println("Employee List for MY COMPANY, with Salaries:\n");
		pw.println("Employee List for MY COMPANY, with Salaries:");
        
        while (myCompany.isEmpty() == false) {
        	myEmployee = myCompany.removeFirst();
        	pw.println(myEmployee.toString());
        	
        	myEmployee.print();
        }
		pw.close();
		

		// Program completed successfully
		System.out.println("\n\n*** Program Completed Successfully ***");
		System.exit(0);

	}
}


/*
 * An Employee SUPER class with five data members, which matches MOCK_DATA.csv
 * Note: 3 data members are inherited from the CHILD class Person
 */

class Employee extends Person { // Employee is the superclass of Person, and inherits its data members
	
	public String job;
	public String country;
	public int salary;
	
	public Employee (String first, String last, String gender, String job, String country, int salary) {
		super(first, last, gender); // calls constructor of Person
		this.job = job;
		this.country = country;
		this.salary = salary;
	}
	
	public void print () {
		System.out.println(firstName + ", " + lastName + ", " + gender + ", " + job + ", " + country + ", $" + salary);
	}
	
	public String toString () {
		String output = firstName + ", " + lastName + ", " + gender + ", " + job + ", " + country + ", $" + salary;
		return output;
	}
}

/*
 * A Person class with three data members: first name, last name, and gender.
 */

class Person {
	public String firstName;
	public String lastName;
	public String gender;
	
	public Person (String first, String last, String g) {
		this.firstName = first;
		this.lastName = last;
		this.gender = g;
	}
}
