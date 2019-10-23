import java.util.Queue;
import java.util.LinkedList;

public class javaQueue {

	public static void main(String[] args) {
		// A queue is only an interface, need to instantiate a Linked List object.
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
		
	}

}
