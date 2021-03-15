/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-15
 * PURPOSE: Searching, sorting, and printing a collection of Employee objects.
 */

public class EmployeeMain {

	public static void main(String[] args) {
		Employee danil;
		danil = new Employee ("Danil", 18, "2003-02-24", 14000, 897780);
		danil.setID(-7);
		System.out.println(danil.getID());
		System.out.println(danil);
		
		//HW: Create an array of employee objects for our class (and Mr. Poirier)
		//Loop through and print the entire employee array
		//Extra - sort by salary or id, then print
		
		//How are public and private variables different??
		
		danil.name = "Faisal"; // ok: name is public
		
		danil.id = 18; // error: id is not visible - cannot directly change it from outside the class/object.
	}

}
