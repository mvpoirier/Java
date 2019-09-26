/* * @author mpoirier
 *
 */

import java.util.Scanner;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int terms = 0;
		Scanner myScan = new Scanner(System.in);
		System.out.print("How many terms? ");
		terms = myScan.nextInt();
		
		for (int i = 0; i < terms; i++) {
			System.out.println(i);
		}
		
		myScan.close();
	}

}
