/**
 * 	A basic Person class with first name, last name, and age.
 */

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	
	public Person (String f, String l, int a) {
		this.firstName = f;
		this.lastName = l;
		this.age = a;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setFirstName(String f) {
		this.firstName = f;
	}
	
	public void setLastName(String l) {
		this.lastName = l;
	}
	
	public void setAge(int a) {
		this.age = a;
	}
	
}
