import java.util.*;

public class VetMain {

	public static void main(String[] args) {
		Pet sooty, harry, strayDog, strayCat;
		LinkedList<Pet> vetList = new LinkedList<Pet>();
		
		sooty = new Pet ("Sooty", "Cat", "Black");
		sooty.setDOB(22, 2, 2020);
		sooty.setOwner("Mike", "Muscat", "Teacher", 8, 1, 1985);
		
		harry = new Pet ("Harry", "Bedlington Terrier", "Grey");
		harry.setDOB(17, 3, 2006);
		harry.setOwner("Janice", "Canada", "Restaurant Owner", 19, 9, 1957);
		
		strayDog = new Pet ("Range", "Dog", "Mix");
		strayDog.setDOB(1, 12, 2021);
		
		strayCat = new Pet ("Subaru", "Cat", "Orange Mix");
		
		vetList.add(sooty);
		vetList.add(harry);
		vetList.add(strayDog);
		vetList.add(strayCat);
		
		while (!vetList.isEmpty()) {
			System.out.println(vetList.poll().toString());
			System.out.println();
		}
	}

}



