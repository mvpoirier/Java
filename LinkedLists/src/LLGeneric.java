/*
 * Linked List implementation with Generic Type T
 * https://stackoverflow.com/questions/21733811/how-to-make-a-new-object-of-type-t
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 * https://www.geeksforgeeks.org/generics-in-java/
 */

// TODO: implement JETS - add, remove(index), getFirst(), getLast() size(), isEmpty()


public class LLGeneric<T>{ // Linked List (LL) of type T
	
	N<T> head; // Node (N) of type T
	
	public LLGeneric () {
		this.head = null;
	}
	
	public void add(T d) {
		N<T> newNode = new N<T>(d);
		
		if (this.head == null) {
			// if list empty, add player to the head (first)
			this.head = newNode;
		}
		else {
			// traverse until we're at the end of the list, then add new node
			N<T> currNode = this.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
		}
	}
	
	public T removeFirst () {
		// remove first value from the linked list, return it
		// set new header to next node
		// if empty, return -1
		N<T> value;
		
		if (this.head == null) {
			return null;
		}
		else {
			value = this.head;
			this.head = this.head.next;
			return value.data;
		}
	}
	
	public void print () {
		N<T> currNode = this.head;
		
		if (this.isEmpty()) {
			System.out.println("List is empty.");
		}
		else {
			while (currNode != null) {
				System.out.println(currNode.data);
				currNode = currNode.next;
			}
		}
	}
	
	public int size () {
		int size = 0;
		
		N<T> currNode = this.head;
		while (currNode != null) {
			size++;
			currNode = currNode.next;
		}
		
		return size;
	}
	
	public boolean isEmpty () {
		return (this.head == null);
	}
	
}

/*
 * Basic Node (N) implementation of Generic Type T
 */

class N<T>{

	T data;
	N<T> next;
	
	public N (T d) {
		// constructor
		this.data = d;
		this.next = null;
	}
}
