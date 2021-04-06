/*
 * A 1D Array implementation of a queue, using Integers.
 */

public class StaticIntQueue {
	private int[] q;
	private int tail;
	
	public StaticIntQueue (int n) {
		q = new int[n];
		tail = -1;
	}
	
	public void enqueue (int value) {
		if (tail < q.length - 1) {
			tail++;
			q[tail] = value;
		}
	}
	
	public int dequeue () {
		int value = -1; // returns -1 if empty
		
		if (tail != -1) {
			value = q[0]; // get first item, then shift all remaining items from 1 up to and including tail
			for (int i = 1; i <= tail; i++) {
				q[i-1] = q[i];
			}
			tail--;
		}
		
		return value;
	}
	
	public boolean isEmpty () {
		return tail == -1;
	}
	
	public boolean isFull() {
		return tail == q.length - 1;
	}
}
