/*
 * An example of how to use Java's implementation of a Linked List.
 * 
 * @author	Mr. Poirier
 * @version 1.1
 * @since	2019-11-12
 */

import java.util.LinkedList;

public class LLJavaExample {

	public static void main(String[] args) {
		LinkedList<String> myShoppingList = new LinkedList<String>();
		
		System.out.println(myShoppingList.isEmpty());
		
		myShoppingList.add("Apples");
		myShoppingList.add("Soda Water");
		myShoppingList.add("Toothbrush");
		
		System.out.println(myShoppingList.remove()); // default: removes first item
		System.out.println(myShoppingList.removeLast());
		
		System.out.println(myShoppingList.isEmpty());
	}
}
