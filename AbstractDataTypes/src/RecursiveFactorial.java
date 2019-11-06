import java.util.*;


public class RecursiveFactorial {

	public static void main(String[] args) {
		int value;
		Scanner myScan = new Scanner (System.in);
		
		System.out.print("Factorial value: ");
		
		value = myScan.nextInt();
		
		System.out.println("\nResult: " + factorial(value));
	}
	
	public static int factorial (int value) {
		if (value == 1) {
			return 1;
		}
		else {
			return value * factorial (value - 1);
		}
	}
}
