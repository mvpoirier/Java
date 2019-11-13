/**
 * JavaDocsExample.java
 * 
 * Commenting correctly with javadocs in Eclipse
 * Notice how it starts with /** instead of /*
 * Source: https://www.tutorialspoint.com/java/java_documentation.htm
 * Eclipse: Preferences > Java > Code Style > Code Templates > Comments > Types
 * 
 * @author 	mpoirier
 * @since 	Nov 13, 2019
 */

public class JavaDocsExample {

	public static void main(String[] args) {
		System.out.println(addNum(5, 8));

	}

	/**
	 * Add two numbers together
	 * @param 	a - int a
	 * @param 	b - int b
	 * @return 	sum of a and b
	 */
	public static int addNum (int a, int b) {
		return a + b;
	}

}
