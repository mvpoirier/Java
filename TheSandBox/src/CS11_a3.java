
/*
 * Mike Poirier
 * November 7, 2019
 * Grade 11 DP Computer Science (Mr. Narayanan Cover)
 * Searching through random arrays (Assignment 3)
 */

import java.util.Scanner;
import java.math.*;

public class CS11_a3 {

	public static void main(String[] args) {
		
		// initialize variables
		int min = 0;
		int max = 100;
		int nums[] = new int[25]; // array of size 25

		// create an array of random numbers between max and min
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * (max-min)) + min;
		}

		// print array on a line, separated by a space
		for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
		}
		
		/*
		 * EASY: Count the numbers between 50 and 60 (inclusive)
		 */
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 50 && nums[i] <= 60) {
				count++;
			}
		}
		System.out.println("Numbers between 50 and 60: " + count);
		
		/*
		 * MEDIUM: State the index of each value found
		 */
		System.out.print("Found at index: ");
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 50 && nums[i] <= 60) {
				System.out.print(i + " ");
			}
		}
	}
}
