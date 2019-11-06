/*
 * A 1D Array implementation of a generic Stack of Generic Type T
 */


public class GenericStack <T> {
	
	T[] data;
	int top;
	
	public GenericStack (int size) {
		//https://stackoverflow.com/questions/2927391/whats-the-reason-i-cant-create-generic-array-types-in-java
		//this.data = new T[size];
		//cannot explicitly create an array of generic type T (above), work around below...
		this.data = (T[]) new Object[size];
		this.top = -1;
	}
	
	public void push (T value) {
		if(top < data.length - 1) {
			top++;
			data[top] = value;
		}
	}
	
	public T pop () {
		if (top != -1) {
			top--;
			return data[top + 1];
		}
		else {
			return null;
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
