/*
 * CircularIntQueue - A 1D Array Implementation of a Circular Queue of Integers
 * int[] q 	- an array of integers of size n
 * int head - the beginning of the queue
 * int tail - the end of the queue
 *
 * @author  Mike Poirier
 * @version 1.0
 * @since   2019-11-12
 */

import java.util.Arrays;

public class CircularIntQueue_TEMPLATE{	
	
	int[] q;
	int tail;
	int head;
	
	/*
	 * Constructor
	 */
	public CircularIntQueue_TEMPLATE (int n) {
		q = new int[n];
		tail = -1;
		head = -1;
	}
	
	/*
	 * Enqueue to the back of the array, OR loop to front: (tail + 1) % q.length
	 */
	public void enqueue (int value) {
		//TODO
	}
	
	/*
	 * Dequeue the front of the queue (head), if available, then increment head
	 */
	public int dequeue () {
		//TODO
	}
	
	public boolean isEmpty () {
		return head == -1; //if head == -1, empty queue
	}
	
	public boolean isFull() {
		return ((tail+1) % q.length) == head; // full if tail is left of head
	}
	
	public void print() {
		System.out.println(Arrays.toString(q));
		System.out.println("head: " + head + ", tail: " + tail);
		System.out.println();
	}
	
}
