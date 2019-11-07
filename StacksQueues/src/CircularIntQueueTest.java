/*
 * A 1D Array implementation of a CIRCULAR queue, using Integers.
 */

import java.util.Arrays;

public class CircularIntQueueTest {
	public static void main (String[] args) {
		int value;
		CircularIntQueue myQueue = new CircularIntQueue(5);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		myQueue.enqueue(6);
		myQueue.enqueue(7);
		value = myQueue.dequeue();
		System.out.println("DEQUEUE: " + value);
		myQueue.enqueue(8);
	}
}

class CircularIntQueue{	
	int[] q;
	int tail;
	int head;
	boolean full;
	boolean empty;

	public CircularIntQueue (int n) {
		q = new int[n];
		tail = -1;
		head = -1;
		full = false;
		empty = true;
	}
	
	public void enqueue (int value) { // WORKS!
		if (head == -1) {
			head++;
			tail++;
			q[0] = value;
			empty = false;
		}
		else if ((tail+1) % q.length != head && !full) {
			tail = (tail + 1) % q.length;
			q[tail] = value;
		}
		else {
			full = true;
		}
		
		System.out.println(Arrays.toString(q));
		System.out.println("head: " + head + " tail: " + tail);
	}
	
	public int dequeue () { // RETURN NEGATIVE ONE IF EMPTY
		if (head == -1 || empty) {
			return -1;
		} else if (head == tail) {
			int temp = head;
			head = -1;
			tail = -1;
			empty = true;
			return q[temp];
		} else if (head){
			// head not equal to tail...
		}
	}
	
	/*
	public boolean isEmpty () {
		return tail == -1;
	}
	
	public boolean isFull() {
		return tail == q.length - 1;
	}
	*/
}
