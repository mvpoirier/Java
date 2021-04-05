
public class QueueTestbed {

	public static void main(String[] args) {
		StaticIntQueue myQueue = new StaticIntQueue (5);
		
		System.out.println("Is Empty: " + myQueue.isEmpty());
		System.out.println("Is Full: " + myQueue.isFull());
		
		myQueue.enqueue(5);
		myQueue.enqueue(10);
		myQueue.enqueue(20);
		myQueue.enqueue(25);
		myQueue.enqueue(29);
		
		System.out.println("Is Empty: " + myQueue.isEmpty());
		System.out.println("Is Full: " + myQueue.isFull());
		
		while (myQueue.isEmpty() == false) {
			System.out.println(myQueue.dequeue());
		}
		
		System.out.println("*** Program completed successfully. ***");
		System.exit(0);
		
	}

}
