/*
 * NAME:	Mr. Poirier
 * DATE:	March 2, 2021
 * PURPOSE:	An example of creating objects from classes.
 */

import java.util.Scanner;

class PokemonMain {
	public static void main(String[] args) {

		Pokemon pikachu = new Pokemon ("Pikachu", "Electric", 70, true);
		pikachu.attack(30); // "Pikachu used an Electric attack for 30 damage!"
		pikachu.dodge(5); // "Pikachu dodged, 65 health remaining!"
		pikachu.dodge(10); // "Pikachu dodged, 55 health remaining!"
		pikachu.evolve(); // "Pikachu evolved into Raichu!", name = "Raichu"
		pikachu.evolve(); // "Raichu cannot evolve any more."
		pikachu.evolve(); // "Raichu cannot evolve any more."

		Pokemon mewtwo = new Pokemon ("Mewtwo", "Psychic", 100, false);
		mewtwo.dodge(20);
		mewtwo.attack(17);
		mewtwo.evolve();

		// User-defined Pokemon
		Scanner s = new Scanner (System.in);
		Pokemon uPoke; // declare user-defined pokemon
		String uName;
		String uType;
		int uHealth;
		boolean uEvolve;

		// Get user information and create a new user-defined Pokemon object
		System.out.print("Pokemon name: ");
		uName = s.nextLine();

		System.out.print("Pokemon type: ");
		uType = s.nextLine();

		System.out.print("Pokemon base health: ");
		uHealth= s.nextInt();
		//s.nextLine(); // remove \n

		System.out.print("Can this pokemon evolve? (true or false): ");
		uEvolve = s.nextBoolean();
		s.close();

		uPoke = new Pokemon (uName, uType, uHealth, uEvolve);
		uPoke.dodge(25);
		uPoke.attack(13);
		uPoke.evolve();
		uPoke.evolve();

		System.exit(0);
	}
}