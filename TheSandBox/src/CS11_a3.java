
/*
 * Mike Poirier
 * November 7, 2019
 * Grade 11 DP Computer Science (Cover for Mr. Narayanan)
 * Assignment 3 - Searching through arrays of random integers
 */

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class CS11_a3 {

	public static void main(String[] args) {
		
		// initialize variables
		int min = 0;
		int max = 99;
		int nums[] = new int[100]; // array of size 25

		// create an array of random numbers between max and min (inclusive)
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * (max-min) + 1) + min;
		}

		// print array on a line, separated by a space
		for (int i = 0; i < nums.length; i++) {
				
				if (nums[i] < 10) {
					System.out.print("0"); // append a leading '0' to numbers less than 10
				}
			
				System.out.print(nums[i] + " ");
				
				if ((i+1) % 25 == 0) {
					System.out.println(); // add a new line after 25 elements
				}
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
		System.out.println("\nNumbers between 50 and 60: " + count);
		
		/*
		 * MEDIUM: State the index of each value found
		 */
		System.out.print("Found at index: ");
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 50 && nums[i] <= 60) {
				System.out.print(i + " ");
			}
		}
		
		/*
		 * HARD: Histogram of values between ranges of 10 (e.g. 10-20, 20-30)
		 */
		System.out.println("\n\n***HISTOGRAM***");
		int[] bins = new int[10];
		for (int i = 0; i < nums.length; i++) {
			bins[(int) (nums[i]/10)]++; // divide each num by 10, increment bin counter
		}
		
		// print ASCII representation of a horizontal histogram
		for (int i = 0; i < bins.length; i++) {
			System.out.print((i*10) + "-" + ((i+1) * 10) + ":\t"); // range title
			for (int j = 0; j < bins[i]; j++) {
				System.out.print("x"); // print an x for each count
			}
			System.out.println();
		}
		
		// confirm total counts from histogram
		int total = 0;
		for (int i = 0; i < bins.length; i++) {
			total = total + bins[i];
		}
		System.out.println("\nTotal counts: " + total);
		System.out.println("Bins: " + Arrays.toString(bins));
		
		// exit successfully
		System.out.println("\n*** Program Completed Successfully ***");
		System.exit(0);
	}
}
