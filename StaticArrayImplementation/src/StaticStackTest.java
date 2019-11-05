
public class StaticStackTest {

	public static void main(String[] args) {
		StaticStack myStack = new StaticStack(5);
		
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
	}

}
