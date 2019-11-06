import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class onedArrays {

	public static void main(String[] args) {
		Scanner myScan = new Scanner (System.in);
		Random r = new Random ();
		
		int[] a;
		int[] b = new int[5];
		int[] c = {2, 4, 6, 8, 10};
		
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		
		for (int i = 0; i < b.length; i++) {
			b[i] = r.nextInt(10);
		}
		
		System.out.println();
		System.out.println(Arrays.toString(b));
		
		a = createRandomArray(10, 1, 5);
		printArray(a);
		
	}
	
	public static void printArray (int[] a) {
		
		// method that will print an array
		
	}
	
	public static int[] createRandomArray (int size, int max, int min) {
		int[] array = new int[size];
		
		// create random array of size with random numbers between max and min
		
		return array;
	}

}
