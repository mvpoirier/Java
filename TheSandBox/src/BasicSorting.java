/**
 * Implementation of basic sorting algorithms: Bubble, Selection, Insertion
 * @author 		Mike Poirier
 * @category 	Sorting Algorithms & Testing
 * @since 		April 7, 2019 (Updated: November 12, 2019)
 */

import java.util.Random;

public class BasicSorting {

	static final int MAX_ARRAY_LENGTH = 10000;
	static final int DATA_RANGE = 100;
	static final int ROW_LENGTH = 40;
	
	public static void main(String[] args) {
		int[] unSortedData = new int[MAX_ARRAY_LENGTH];
		int[] sortedData = new int[MAX_ARRAY_LENGTH];
		
		// Create a randomly unsorted array of integers
		long startTime = System.nanoTime();
		unSortedData = makeRandomArray(unSortedData.length, DATA_RANGE);
		long elapsedTime = System.nanoTime() - startTime;
		printArray(unSortedData, ROW_LENGTH);
		System.out.println("\nMake Array - Elapsed Time: " + elapsedTime/1000000 + " ms.\n");
		
		// Bubble Sort
		startTime = System.nanoTime();
		sortedData = bubbleSort(unSortedData);
		elapsedTime = System.nanoTime() - startTime;
		printArray(sortedData, ROW_LENGTH);
		System.out.println("\nBubble Sort - Elapsed Time: " + elapsedTime/1000000 + " ms.\n");
		
		// Selection Sort
		startTime = System.nanoTime();
		sortedData = selectionSort(unSortedData);
		elapsedTime = System.nanoTime() - startTime;
		printArray(sortedData, ROW_LENGTH);
		System.out.println("\nSelection Sort - Elapsed Time: " + elapsedTime/1000000 + " ms.\n");
		
		// Insertion Sort
		startTime = System.nanoTime();
		sortedData = insertionSort(unSortedData);
		elapsedTime = System.nanoTime() - startTime;
		printArray(sortedData, ROW_LENGTH);
		System.out.println("\nInsertion Sort - Elapsed Time: " + elapsedTime/1000000 + " ms.\n");
		
		// Program exit
		System.out.println("***Program Finished Successfully.***");
		System.exit(0);
	}

	
	/**
	 * @method	Make a Random Array
	 * @use 	Creates a random integer array with elements from 0 to range
	 */
	
	public static int[] makeRandomArray (int arrayLength, int range){
		int[] randomArray = new int[arrayLength];
		Random r = new Random();
		
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = r.nextInt(range);
		}
		
		return randomArray;
	}
	
	
	/**
	 * @method	Print Array
	 * @use 	Prints an entire 1D array, upto a specific row length,
	 * 			before printing on a new line
	 */
	
	public static void printArray (int[] myArray, int rowLength) {
		for (int i = 0; i < myArray.length; i++) {
			if (i % rowLength == 0) {
				System.out.println();
			}
			System.out.print(myArray[i] + " ");
		}
	}

	
	/**
	 * @method	Bubble Sort (or Sinking Sort)
	 * @use 	Repeatedly steps through an array, compares adjacent pairs, 
	 * 			and then swap if in the wrong order
	 */
	
	public static int[] bubbleSort (int[] unSorted) {
		int temp;
		boolean finished = false;
		
		while (!finished) {
			finished = true;
			
			// tranverse the entire array
			for (int index = 0; index < (unSorted.length - 1); index++) {
				// if two adjacent elements are not in correct order, swap them
				if (unSorted[index] > unSorted[index + 1]) {
					temp = unSorted[index];
					unSorted[index] = unSorted[index + 1];
					unSorted[index + 1] = temp;
					finished = false;
				}
			}
		}
		return unSorted;
	}

	
	/**
	 * @method	Selection Sort
	 * @use 	Go through the unsorted array and find the smallest value,
	 * 			and create a new sub array in ascending order
	 */
	
	public static int[] selectionSort (int[] unSorted) {
		int[] sorted = new int[unSorted.length];
		int temp;
		int index;
		boolean found;
		
		// traverse the entire array
		for (int i = 0; i < unSorted.length; i++) {
			// store next element at index i to compare
			temp = unSorted[i];
			index = i;
			
			// traverse from i + 1 to end of the array
			for (int j = i + 1; j < unSorted.length; j++) {
				if (unSorted[j] < temp) {
					// store the new smallest element
					temp = unSorted[j];
					index = j;
					
					// swap with the previously smallest element
					unSorted[j] = unSorted[i];
				}
			}
			
			// add smallest element to the new sub array
			sorted[i] = temp;
		}
		return sorted;
	}
	
	
	/**
	 * @method	Insertion Sort
	 * @use 	Pick element arr[i] and insert it into sorted sequence arr[0…i-1] 
	 * 			Source: https://www.geeksforgeeks.org/insertion-sort/
	 */
	
	public static int[] insertionSort (int[] unSorted) {
		// TODO Insertion Sort
		int n = unSorted.length;
		
		for (int i = 1; i < n; i++) {
			int key = unSorted[i]; //get next item in the array
			int j = i - 1;
			
			while (j >= 0 && unSorted[j] > key) { //compare will all items previously
				unSorted[j+ 1] = unSorted[j];
				j--;
			}
			
			unSorted[j + 1] = key; //make final swap
		}
		
		return unSorted;
	}
}
