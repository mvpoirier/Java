
public class StackTestbed {

	public static void main(String[] args) {
		
		/*
		 * Initializing a static 1D array Integer stack, and pushing/popping values.
		 */
		
		StaticIntStack myStack = new StaticIntStack(5);
		System.out.println("Empty: " + myStack.isEmpty());
		System.out.println("Full: " + myStack.isFull());
		
		myStack.push(5);
		myStack.push(3);
		myStack.push(1);
		myStack.push(4);
		myStack.push(7);
		
		myStack.push(99); // will not be added, stack is full
		
		System.out.println("Empty: " + myStack.isEmpty());
		System.out.println("Full: " + myStack.isFull());
		
		while (myStack.isEmpty() == false) {
			System.out.println(myStack.pop());
		}
		
		System.out.println("*** Program completed successfully. ***");
		System.exit(0);
		
	}

}
