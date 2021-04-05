/*
 * A 1D Array implementation of a stack, using generic Objects.
 */


public class StaticObjectStack {
	
	Object[] data;
	int top;
	
	public StaticObjectStack (int size) {
		this.data = new Object[size];
		this.top = -1;
	}
	
	public void push (Object value) {
		if(top < data.length - 1) {
			top++;
			data[top] = value;
		}
	}
	
	public Object pop () {
		if (top != -1) {
			top--;
			return data[top + 1]; // because it's a generic Object, will need to cast type > e.g. (int)
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
