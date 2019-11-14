/**
 * javaDocsExample.java
 * 
 * CLASS:	JavaDocsExample
 * PURPOSE:	Examples of how to comment correctly using javadocs in Eclipse.
 * 			Notice how javadoc comments start with /** instead of /*
 * 			Eclipse Preferences > Java > Code Style > Code Templates > Comments > Types
 * 			Source: https://www.tutorialspoint.com/java/java_documentation.htm
 * 
 * @author 	mpoirier
 * @since 	2019-11-13 (Updated: 2019-11-14)
 * @version	0.1 (Beta)
 */
public class JavaDocsExample {

	/**
	 * METHOD: 	main
	 * PURPOSE:	Prints the sum of the ages of two people.
	 * 			Prints the sum of the net worth of two bank accounts.
	 * 
	 * @param 	String[] args	- arguments entered by user from command line
	 * @return 	VOID
	 */
	public static void main(String[] args) {
		int sumAge, sumNetWorth;
		
		Person mPoirier = new Person("Michael Poirier", 34);
		Person bWheeler = new Person("Blake Wheeler", 33);
		
		//bank account information in United States Dollars (USD)
		BankAccount wGates = new BankAccount("Will Gates", 64, 107100);
		BankAccount eBusk = new BankAccount("Elon Busk", 48, 23700);
		
		//print sum of ages for Mike & Blake
		sumAge = addNum(mPoirier.getAge(), bWheeler.getAge());
		System.out.println("Sum of ages for Mike & Blake: " + sumAge);
		
		//print sum of net worth for Will & Elon
		sumNetWorth = addNum(wGates.getNetWorth(), eBusk.getNetWorth());
		System.out.println("Sum of net worth for Will & Elon: " + sumNetWorth);
		
		//exit program
		System.out.println("\n*** Program Completed Successfully. ***");
		System.exit(0);
	}

	
	/**
	 * METHOD:	addNum
	 * PURPOSE:	Adds two numbers together.
	 * 
	 * @param 	int a	- number 1
	 * @param 	int b	- number 2
	 * @return 	int		- The sum of a and b
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
	
	/**
	 * METHOD:	getName
	 * PURPOSE:	Getter method for name.
	 * @return 	String	- the name of this person object
	 */
	public String getName () {
		return this.name;
	}
	
	/**
	 * METHOD:	getAge
	 * PURPOSE:	Getter method for age.
	 * @return	int	- the age of this person object.
	 */
	public int getAge () {
		return this.age;
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
	 * METHOD:	getNetWorth
	 * PURPOSE:	Getter method for netWorth
	 * @return	int	- the total net worth of the account holder in USD
	 */
	public int getNetWorth () {
		return this.netWorth;
	}
}
