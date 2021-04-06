import java.util.Arrays;
import java.util.Random; // Random numbers
import java.util.Scanner; // Input

public class Array1D {

	public static void main(String[] args) {
		int n, min, max;
		int[] a;
		
		Scanner myScan = new Scanner (System.in);
		
		System.out.print("Size of array: ");
		n = myScan.nextInt();
		
		System.out.print("Min value: ");
		min = myScan.nextInt();
		
		System.out.print("Max value: ");
		max = myScan.nextInt();
		
		myScan.close();
		
		a = randomArray(n, min, max);
		
		printArray(a); // printArray method
		
		System.out.println(Arrays.toString(a)); // using built-in java.util.Arrays method
		
		//System.out.println(Arrays.toString(a).substring(1, Arrays.toString(a).length()-1)); // using built-in java.util.Arrays method
		
		//System.out.println("\n\nmetaPrint1:\n");
		//metaPrint1(a);
		
		//System.out.println("\nmetaPrint2:\n");
		//metaPrint2(a);

	}
	
	public static int[] randomArray(int n, int min, int max) {
		
		int[] a = new int[n];
		Random myRand = new Random();
		
		for (int i = 0; i < n; i++) {
			int r = myRand.nextInt(max) + min;
			a[i] = r;
		}
		
		return a;
	}
	
	public static void printArray (int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1)
				System.out.print(a[i] + "\n");
			else
				System.out.print(a[i] + ", ");
		}
	}
	
	public static void metaPrint1 (int[] a) {
		for (int i = 0; i < a.length; i++){
			printArray(a);
		}
	}
	
	public static void metaPrint2 (int[] a) {
		for (int k = 0; k < a.length; k++){
			for (int i = 0; i < a.length; i++) {
				if (i == a.length - 1)
					System.out.print(a[i] + "\n");
				else
					System.out.print(a[i] + ", ");
			}
		}
	}

}
