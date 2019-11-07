/*
 * Mike Poirier
 * November 7, 2019
 * 
 * Testing the implementation of a Circular Queue of Integers
 */

public class CircularQueueTestbed {
	public static void main (String[] args) {
		int value;
		CircularIntQueue myQueue = new CircularIntQueue(5);
		
		myQueue.print();
		myQueue.enqueue(1);
		myQueue.print();
		myQueue.enqueue(2);
		myQueue.print();
		myQueue.enqueue(3);
		myQueue.print();
		myQueue.enqueue(4);
		myQueue.print();
		myQueue.enqueue(5);
		myQueue.print();
		
		myQueue.enqueue(99); // will be ignored, queue is full
		myQueue.print();
		
		value = myQueue.dequeue();
		myQueue.print();
		value = myQueue.dequeue();
		myQueue.print();
		value = myQueue.dequeue();
		myQueue.print();
		
		myQueue.enqueue(12);
		myQueue.print();
		myQueue.enqueue(13);
		myQueue.print();
		myQueue.enqueue(14);
		myQueue.print();
		
		myQueue.enqueue(99); // will be ignored, queue is full
		myQueue.print();
		
		//dequeue until empty
		while (!myQueue.isEmpty()) {
			System.out.println(myQueue.dequeue());
			myQueue.print();
		}
		myQueue.print();
		System.out.println(myQueue.dequeue()); // will print -1 (empty)
		
		//enqueue until full
		value = 2;
		while (!myQueue.isFull()) {
			myQueue.enqueue(value);
			myQueue.print();
			value = value * 4;
		}
		
		System.out.println("*** Program Completed Successfully ***");
		System.exit(0);
	}
}
