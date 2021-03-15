/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-15
 * PURPOSE: An example of public and private data members,
 * 			with 'getter' (accessor) and 'setter' (mutator) methods.
 */

public class Employee {
	
	// Data
	public String name;
	public int age;
	public String dob;
	
	private double salary;
	private int id;
	
	// Constructor
	Employee (String name, int age, String dob){
		this.name = name; // If variable has same name, use keyword 'this'
		this.age = age;
		this.dob = dob;
		
		this.salary = -1.0; // Default to -1 if not set.
		this.id = -1; // Default to -1 if not set.
	}
	
	// Overloaded Constructor: an example of Polymorphism.
	Employee (String n, int a, String d, double s, int i){
		this (n, a, d); // Keyword 'this' to reference constructor
		
		salary = s;
		id = i;
	}
	
	// Actions
	
	public double getSalary () {
		return this.salary;
	}
	
	public void setSalary (double s) {
		if (s > 0.0)
			this.salary = s;
	}
	
	public int getID () {
		return this.id;
	}
	
	public void setID (int i) {
		if (i > 0)
			this.id = i;
	}
	
	// Override built-in toString() method: an example of Polymorphism.
	@Override
	public String toString () {
		return  "name: " + name +
				"\nage: " + age +
				"\ndob: " + dob +
				"\nsalary: $" + salary +
				"\nid: " + id + "\n";
	}

}
