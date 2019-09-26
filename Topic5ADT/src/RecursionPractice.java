import java.util.*;

public class RecursionPractice {

	public static void main(String[] args) {
		int start;
		
		// Call my recursive method
		//physicsRules(1);
		
		Scanner myScan = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		start = myScan.nextInt();
		System.out.println(arithmeticSum(start));
	}
	
	public static void physicsRules(int num) {
		System.out.println(num);
		physicsRules(num + 1);
	}
	
	public static int arithmeticSum (int value) {
		if (value == 1) {
			return value;
		}
		else {
			return value + arithmeticSum(value - 1);
		}
	}
}
