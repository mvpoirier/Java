/*
 * A short example of using OOP to create useful data structures.
 */


public class TripOrganizer {

	public static void main(String[] args) {
		// declare a luggageItem array suitcase[] of size 3 (1st index = 0)
		luggageItem suitcase[] = new luggageItem[3]; // first index = 0
		
		// instantiate 3 luggageItem objects with three arguments: name, cost, weight
		luggageItem phone = new luggageItem ("iPhone", 900, 0.2);
		luggageItem sunscreen = new luggageItem("Sunscreen SPF 50", 15, 0.4);
		luggageItem shoes = new luggageItem("Dress Shoes", 150, 1.0);
		
		// add all three items to array suitcase[]
		suitcase[0] = phone;
		suitcase[1] = sunscreen;
		suitcase[2] = shoes;
		
		suitcase[2].setWeight(-5.2);
		
		// use a for loop to print all three luggageItems
		System.out.println("I will bring the following items on my trip:\n");
		for (int i = 0; i < suitcase.length; i++) {
			System.out.println(suitcase[i].name);
			System.out.println(suitcase[i].cost);
			System.out.println(suitcase[i].getWeight() + "\n");
		}
		
		//System.out.println(args[0]);
		System.exit(0);
	}

}

class luggageItem{
	
	// luggageItems data members
	private double weight;
	public int cost;
	public String name;
	
	public luggageItem (String name, int cost, double weight) {
		// constructor for luggageItems
		this.name = name;
		this.cost = cost;
		this.weight = weight;
	}
	
	public double getWeight () {
		return weight;
	}
	
	public void setWeight(double newWeight) {
		if (newWeight > 0) {
			this.weight = newWeight;
		}
		else {
			System.out.println("Error: cannot have negative weight.");
		}
	}
}
