/**
 * FILE:	CodingConventions/javaDocsExample.java
 * 
 * PURPOSE:	Examples of how to comment correctly in Eclipse.
 * 			Notice how Javadoc comments start with /** instead of /*
 * 			
 * ADVICE:	Eclipse: Preferences > Java > Code Style > Code Templates > Comments > Types
 * 			Eclipse: Preferences > Java > Editor > Folding
 * 			Eclipse: Option + Command + J > Auto-generate code element comment
 * 			Eclipse: Select All Text (Command + A) & Correct Indentation (Command + I)
 * 
 * SOURCE:	tutorialspoint.com/java/java_documentation.htm
 * 			stackoverflow.com/questions/2612633/how-do-i-change-the-javadocs-template-generated-in-eclipse
 * 
 * @author 	github.com/mvpoirier
 * @since 	2019-11-15
 */

import java.util.Random;

public class JavaDocsExample {

	public static void main(String[] args) {
		int sumAge, sumNetWorth;
		Random r = new Random();

		Person mPoirier = new Person("Mike Poirier", 34);
		Person bWheeler = new Person("Blake Wheeler", 33);

		BankAccount wGates = new BankAccount("Will Gates", 64, 107100); //in USD
		BankAccount eBusk = new BankAccount("Elon Busk", 48, 23700);

		//print sum of two random numbers (each between 0 and 100)
		System.out.println("Sum of two random integers: " + addNum(r.nextInt(100), r.nextInt(100)));

		//print sum of ages for Mike & Blake
		sumAge = addNum(mPoirier.getAge(), bWheeler.getAge());
		System.out.println("Combined ages of " + mPoirier.getName() + " & " + bWheeler.getName()+ ": " + sumAge);

		//print sum of net worth for Will & Elon
		sumNetWorth = addNum(wGates.getNetWorth(), eBusk.getNetWorth());
		System.out.println("Combined net worth of " + wGates.getName() + " & " + eBusk.getName()+ ": " + sumNetWorth);

		//exit program
		System.out.println("\n*** Program Completed Successfully. ***");
		System.exit(0);
	}

	/**
	 * METHOD:	addNum
	 * PURPOSE:	Adds two numbers together.
	 * 
	 * @param 	int a
	 * @param 	int b
	 * @return 	int a + b
	 */
	public static int addNum (int a, int b) {
		return a + b;
	}

}


/**
 * CLASS:	Person
 * PURPOSE:	An object of basic personal information.
 */
class Person {
	private String name;
	private int age;

	/**
	 * Constructor
	 * @param String name	- first and last name
	 * @param int age		- age of a person
	 */
	public Person (String name, int age) {
		this.name = name;
		this.age = age;
	}

	/*
	 * AUTO-GENERATE ACCESSORS AND MUTATORS IN ECLIPSE:
	 * Eclipse: Menu Bar > Source > Generate Getters and Setters...
	 */
	
	/**
	 * Accessor Method (Getter)
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator Method (Setter)
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor Method (Getter)
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Mutator Method (Setter)
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}


/**
 * CLASS:	BankAccount
 * PURPOSE:	Provides net worth information about a Person.
 * 			Child class of Person: inherits all data members and methods of Person.
 */
class BankAccount extends Person {
	private int netWorth;

	/**
	 * Constructor
	 * Calls super class Person's constructor
	 * @param String name	- first and last name
	 * @param int age		- age of a person
	 * @param int netWorth	- total net worth of bank account in USD
	 */
	public BankAccount (String name, int age, int netWorth) {
		super(name, age);
		this.netWorth = netWorth;
	}

	/**
	 * Accessor Method (Getter)
	 * @return the netWorth (in USD)
	 */
	public int getNetWorth() {
		return netWorth;
	}

	/**
	 * Mutator Method (Setter)
	 * @param netWorth the netWorth to set (in USD)
	 */
	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}
}
