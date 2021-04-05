
/*
 * A 1D Array implementation of a stack, using Integers.
 */

public class StaticIntStack {
	
	int[] data;
	int top;
	
	public StaticIntStack (int size) {
		this.data = new int[size];
		this.top = -1;
	}
	
	public void push (int value) {
		if(top < data.length - 1) {
			top++;
			data[top] = value;
		}
	}
	
	public int pop () {
		if (top != -1) {
			top--;
			return data[top + 1];
		}
		else {
			return -1;
		}
		
	}
	
	public boolean isEmpty () {
		if (top == -1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean isFull () {
		if (top == data.length - 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
