/*
 * PURPOSE: Example OOP lesson with Food Recipes.
 * AUTHOR: Mr. Michael Poirier
 * DATE: October 30, 2019
 */

public class FoodRecipes {

	public static void main(String[] args) {
		// main method that will run "java FoodRecipies args[0] args[1] ..."

		Recipe pasta; // create a pointer/variable of type Recipie
		pasta = new Recipe("Spaghetti", 4, 4); // pasta in an instance of the "Recipie" class.

		Recipe chicken = new Recipe("Chinese Chicken", 5, 3);

		pasta.ingredients[0] = "pasta";
		pasta.ingredients[1] = "tomato sauce";
		pasta.ingredients[2] = "cheese";
		pasta.ingredients[3] = "oregano";

		for (int i = 0; i < pasta.ingredients.length; i++) {
			System.out.println(pasta.ingredients[i]);
		}

	}

}

class Recipe {
	public String name;
	public String[] ingredients;
	public String[] steps;
	private int cost;

	public Recipe(String name, int numI, int numS) {
		// constructor
		this.name = name;
		this.ingredients = new String[numI];
		this.steps = new String[numS];
	}

	public String printCost() {
		String totalCost;
		totalCost = this.cost + ".00 OMR";
		return totalCost;
	}
}
