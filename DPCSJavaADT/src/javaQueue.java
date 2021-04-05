import java.util.Queue; // not really needed, LL does all Queue functions!
import java.util.LinkedList;
import java.util.Scanner;

public class javaQueue {

	public static void main(String[] args) {
		// A Queue is only an interface, need to instantiate a Linked List object.
		Queue<Integer> myQueue = new LinkedList(); 
		
		System.out.println(myQueue.isEmpty());
		
		// enqueue items to the Linked List
		myQueue.add(5);
		myQueue.add(10);
		myQueue.add(15);

		System.out.println(myQueue.isEmpty());
		
		while (myQueue.isEmpty() == false) {
			
			// dequeue items from the linked list
			System.out.println(myQueue.remove());
		}
		
		//TODO: Use Scanner to enqueue items from the user, then print.
		Scanner myScan = new Scanner (System.in);
		System.out.print("Enter number (-1 to stop): ");
		int value = myScan.nextInt();
		
		while (value != -1) {
			myQueue.add(value);
			System.out.print("\nEnter number (-1 to stop): ");
			value = myScan.nextInt();
		}
		
		while (myQueue.isEmpty() == false) {
			
			// dequeue items from the linked list
			System.out.println(myQueue.remove());
		}
	}

}
