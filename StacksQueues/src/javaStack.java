import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class javaStack {

	public static void main(String[] args) {
		
		/*
		 * INITIALIZE A STACK OBJECT FROM JAVA OF TYPE INTEGER
		 */
		
		Stack<Integer> myStack = new Stack();
		
		
		/*
		 * PUSH AND POP ELEMENTS ON A STACK
		 */
		
		System.out.println(myStack.isEmpty());
		
		myStack.push(5);
		myStack.push(10);
		myStack.push(15);
		
		System.out.println(myStack.isEmpty());
		
		while (myStack.isEmpty() == false) {
			System.out.println(myStack.pop());
		}
		
		/*
		 * ADD ARRAY TO STACK & PRINT
		 */
		
		int a[] = {2, 4, 6, 8, 10};
		
		for (int i = 0; i < a.length; i++) {
			myStack.push(a[i]);
		}
		
		System.out.println("\n\n" + Arrays.toString(a));
		
		while (myStack.isEmpty() == false) {
			System.out.println(myStack.pop());
		}
		
		/*
		 * USE SCANNER TO ADD ITEMS TO A STACK FROM THE USER, THEN PRINT
		 */
		Scanner myScan = new Scanner (System.in);
		int input;
		
		System.out.print("\nValue (-1 to stop): ");
		input = myScan.nextInt();
		while (input != -1) {
			myStack.push(input);
			System.out.print("\nValue (-1 to stop): ");
			input = myScan.nextInt();
		}
		
		System.out.println("\nInput stopped, printing stack: ");
		while (myStack.isEmpty() == false) {
			System.out.println(myStack.pop());
		}

	}

}
