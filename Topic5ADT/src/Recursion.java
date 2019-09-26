/**
 * <Write a description here.>
 * @author  <firstname> <LASTNAME>
 * @version <submission>.<modification>
 * @date	 <yyyy>.<mm>.<dd>
 */

/**
 * Recursion Examples for DP Computer Science
 * Topic 5 - Abstract Data Structures (HL)
 * @author	Michael POIRIER
 * @version 1.0
 * @date	2019.09.11
 */

import java.io.*;
import java.util.*;

public class Recursion {

	public static void main(String[] args) {
		// TODO Write recursion examples
		// arithmetic sum, geometric sum, factorial, fibonacci, sorting
		
		int choice = 0;
		Scanner myScan = new Scanner (System.in);
		
		System.out.print("Artimetic sum of which number (-1 to Quit)? ");
		choice = myScan.nextInt();
		while (choice != -1) {
			System.out.println("Arithmetic Sum:" + arithmeticSum(choice));
			
			System.out.print("\n\nArtimetic Sum of which number (-1 to Quit)? ");
			choice = myScan.nextInt();
		}
		
		System.out.println("Fib 6: " + fibonacci(6));
		for (int j = 1; j <= 6; j++) {
			System.out.print(fibonacci(j) + " ");
		}
		
		System.out.println("\n\n***Program has completed successfully.***");
		System.exit(0);
	}
	
	public static int arithmeticSum(int value) {
		if (value == 1) {
			return value;
		}
		else {
			return value + arithmeticSum(value - 1);
		}
	}
	
	public static int fibonacci (int value) {
		if (value == 0 || value == 1) {
			//System.out.println(value);
			return value;
		}
		else {
			//System.out.println(fibonacci(value - 1) + fibonacci(value - 2));
			return fibonacci(value - 1) + fibonacci(value - 2);
		}
	}

}
