/*
 * Mike Poirier
 * November 7, 2019
 * 
 * CircularIntQueue - A 1D Array Implementation of a Circular Queue of Integers
 * int[] q 	- an array of integers of size n
 * int head - the beginning of the queue
 * int tail - the end of the queue
 */

import java.util.Arrays;

public class CircularIntQueue{	
	
	int[] q;
	int tail;
	int head;
	
	/*
	 * Constructor
	 */
	public CircularIntQueue (int n) {
		q = new int[n];
		tail = -1;
		head = -1;
	}
	
	/*
	 * Enqueue to the back of the array, OR loop to front: (tail + 1) % q.length
	 */
	public void enqueue (int value) {
		if (this.isEmpty()) {
			head++;
			tail++;
			q[0] = value;
		}
		else if (!this.isFull()) {
			tail = (tail + 1) % q.length;
			q[tail] = value;
		}
		

	}
	
	/*
	 * Dequeue the front of the queue (head), if available, then increment head
	 */
	public int dequeue () {
		int temp = head; //store current position of head
		
		if (this.isEmpty()) {
			return -1;
		} else if (head == tail) {
			head = -1;
			tail = -1;
		} else { // head != tail
			head = (head + 1) % q.length; // increment head (loop over with % q.length)
		}
		
		return q[temp];
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
