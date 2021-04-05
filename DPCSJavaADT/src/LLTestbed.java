/*
 * A test bed program to test Linked Lists:
 * LLInteger - A linked list of integers
 * LLGeneric - A linked list of generic type T
 */

import java.util.Scanner;

public class LLTestbed {

	public static void main(String[] args) {
		/*
		 * LLInteger TEST
		 */
		
		LLInteger numList = new LLInteger();
		numList.add(5);		
		numList.add(10);
		numList.add(67);
		Scanner myScan = new Scanner(System.in);
		System.out.println("Type a number: ");
		numList.add(myScan.nextInt());
		System.out.println();
		numList.print();
		
		System.out.println("*** LLInteger Testing Completed Successfully ***\n");
		
		/*
		 * LLGeneric<Integer> TEST
		 */
		
		LLGeneric<Integer> intLL = new LLGeneric<Integer>();
		intLL.add(5);
		intLL.add(15);
		intLL.add(29);
		intLL.print();
		System.out.println("*** LLGeneric<Integer> Testing Completed Successfully ***\n");

		
		/*
		 * LLGeneric<String> TEST
		 */
		
		LLGeneric<String> stringLL = new LLGeneric<String>();
		stringLL.add("hello");
		stringLL.add("bonjour");
		stringLL.add("hola");
		System.out.print("Type a word: ");
		stringLL.add(myScan.next());
		System.out.println();
		stringLL.print();
		System.out.println("*** LLGeneric<String> Testing Completed Successfully ***\n");

		
		// Program completed
		System.out.println("\n*** LLTestbed Completed Successfully ***\n");
		System.exit(0);
	}

}