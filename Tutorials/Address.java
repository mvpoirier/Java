
/*
 * NAME:	Mr. Poirier
 * DATE:	March 23, 2021
 * PURPOSE: Address class to handle each object from the CSV file.
 */

public class Address {

	private String first;
	private String last;
	private int age;
	private String country;
	private String phone;
	private String email;
	
	Address (String f, String l, int a, String c, String p, String e){
		this.first = f;
		this.last = l;
		this.age = a;
		this.country = c;
		this.phone = p;
		this.email = e;
	}
	
	public String[] getData () {
		String[] data = {first, last, Integer.toString(age), country, phone, email};
		return data;
	}
	
	public String getFullName () {
		String name = last + ", " + first;
		return name;
	}
	
}
