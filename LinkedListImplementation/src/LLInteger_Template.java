/*
 * Close Template Exercise to Develop a Singly Linked List from Scratch
 */


public class LLInteger { // TEMPLATE: RENAME FILE TO LLInteger.java

	Node head;
	
	public LLInteger () {
		this.head = null;
	}
	
	public void add (int d) {
		Node newNode = new Node(d);
		// if list empty, add player to the head (first)

		// else, traverse until we're at the end of the list, then add new node

	}
	
	public int removeFirst () {
		Node value;
		
		// if empty, return -1
		return -1;
		// else, remove first value from the linked list, return it
		return value.data;
		// set new header to next node
		
	}
	
	public void print () {
		Node currNode = this.head;
		
		// if list is empty, print "List is empty"
		// else, traverse linked list print each data value until node == null
		
	}
	
	public int size () {
		int size = 0;
		
		// if list if empty, size = 0
		// else traverse list, add to counter, and print
		
		return size;
	}
	
	public boolean isEmpty () {
		return (this.head == null);
	}
}

// A basic node object: contains data and pointer to next node.
class Node {
	
	int data;
	Node next;
	
	public Node (int d) {
		this.data = d;
		next = null;
	}
	
}