
public class LLGenericTest {

	public static void main(String[] args) {
		// TODO: Test a Linked List as a stack and queue
		
		LL<Integer> myLL = new LL<Integer>();
		System.out.println("Hello world");

	}

}

/*
 * Basic Linked List (LL) implementation using type parameter T
 * https://stackoverflow.com/questions/21733811/how-to-make-a-new-object-of-type-t
 */

class LL<T>{
	
	N head;
	
	public LL () {
		this.head = null;
	}
	
	public LL<T> () {
		this.head = null;
	}
	
	// TODO: implement JETS - add, remove(index), getFirst(), getLast() size(), isEmpty()
	
}

/*
 * Basic node (N) implementation
 */

class N<T> {

	T data;
	N<T> next;
	
	public N () {
		
	}
	
	public N<T> (T d) {
		// constructor
		this.data = d;
	}
}

/*
class N {

	Object data;
	N next;
	
	public N (Object d) {
		// constructor
		this.data = d;
	}
}
*/