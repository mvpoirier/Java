/**
 * FILE:	JavaIntroduction/IfElse.java
 * PURPOSE:
 *
 * @author 	github.com/mvpoirier
 * @since 	2020-10-12
 */

import java.util.Scanner;

/**
 * CLASS:	IfElse
 * PURPOSE:
 */
public class IfElse {

	/**
	 * METHOD:	main
	 * PURPOSE:
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");

		int myNum = input.nextInt();

		if (myNum % 2 == 0) {
			System.out.println("Even!");
		}
		else {
			System.out.println("Odd!");
		}

		System.exit(0);

	}

}
