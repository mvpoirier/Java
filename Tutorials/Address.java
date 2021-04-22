
/*
 * NAME:	Mr. Poirier
 * DATE:	March 23, 2021 (Created)
 * 			April 22, 2021 (Updated)
 * PURPOSE: Address class to handle each object from the CSV file.
 */

public class Address {

	private String first;
	private String last;
	private int age;
	private String country;
	private String phone;
	private String email;
	// date of birth object (month, day, year)?
	
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
	
	public String getLast () {
		return last;
	}
	
	public String getFullName () {
		return last + ", " + first;
	}
	
	public int getAge () {
		return age;
	}
	
	@Override
	public String toString() {
		// A comma-separated String to support output to a file (e.g. PrintWriter)
		return first + "," + last + "," + age + "," + country + "," + phone + "," + email;
	}
	
}
