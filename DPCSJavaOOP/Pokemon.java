public class Pokemon {
	// Data
	String name;
	String type;
	int health;
	boolean canEvolve;

	// Constructor
	Pokemon (String n, String t, int h, boolean e){
		name = n;
		type = t;
		health = h;
		canEvolve = e;
	}

	// Actions
	public void attack (int d){
		System.out.println(name + " used a " + type + " attack for " + d + " damage!");
	}

	public void dodge (int y){
		health = health - y; //reduce health from attack
		System.out.println(name + " dodged an attack, " + health + " health remaining.");
	}

	public void evolve (){
		if (canEvolve == true){
			System.out.println("EVOLVE!");
			canEvolve = false;
		}
		else {
			System.out.println("Can't evolve :-(");
		}
	}
}
