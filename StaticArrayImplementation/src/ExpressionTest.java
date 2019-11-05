
/*
* Testing the open and closed brackets for a valid expression
* Implements StaticObjectStack - a 1D array of static generic objects, with stack methods (push/pop)
* Note: Generic objects are required to be casted by type to (char) for comparison
*/

public class ExpressionTest {

	public static void main(String[] args) {
		
		System.out.println("Expression Check (()): "+ expressionCheck("(())"));
		System.out.println("Expression Check (x{a[b]l}c): "+ expressionCheck("(x{a[b]l}c)"));
		System.out.println("Expression Check (x{a[b): "+ expressionCheck("(x{a[b)"));
		System.out.println("Expression Check (((({{{{[[[[]]]]}}}})))): "+ expressionCheck("(((({{{{[[[[]]]]}}}}))))"));
		System.out.println("Expression Check (((({{[{[[[[]]]]}}}})))): "+ expressionCheck("(((({{[{[[[[]]]]}}}}))))"));
		
		System.out.println("\n*** Program completed successfully. ***");
		System.exit(0);

	}
	
	
	public static boolean expressionCheck (String s) {
		
		StaticObjectStack expStack = new StaticObjectStack(s.length()); //static 1D array stack of generic objects
		boolean validExpression = true;
		
		for (int i = 0; i < s.length() && validExpression; i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') { //push open brackets
				expStack.push(s.charAt(i));
			}
			else if (s.charAt(i) == ')') { //pop stack when closed bracket detected, then compare
				validExpression = ((char) expStack.pop() == '(');
			}
			else if (s.charAt(i) == ']') {
				validExpression = ((char) expStack.pop() == '['); //popped objects are casted as char
			}
			else if (s.charAt(i) == '}') {
				validExpression = ((char) expStack.pop() == '{');
			}
		}
		
		return validExpression; //returns false if invalid comparison was made
	}

}
