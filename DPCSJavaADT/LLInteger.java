/*
 * Basic Linked List implementation of Integers
 */


// TODO: implement JETS - add, remove(index), getFirst(), getLast() size(), isEmpty()

public class LLInteger {

	Node head;
	
	public LLInteger () {
		this.head = null;
	}
	
	public void add(int d) {
		Node newNode = new Node(d);
		
		if (this.head == null) {
			// if list empty, add player to the head (first)
			this.head = newNode;
		}
		else {
			// traverse until we're at the end of the list, then add new node
			Node currNode = this.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
		}
	}
	
	public int removeFirst () {
		// remove first value from the linked list, return it
		// set new header to next node
		// if empty, return -1
		Node value;
		
		if (this.head == null) {
			return -1;
		}
		else {
			value = this.head;
			this.head = this.head.next;
			return value.data;
		}
	}
	
	public void print () {
		Node currNode = this.head;
		
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
		
		Node currNode = this.head;
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
 * A basic node object
 * Contains data (int) and pointer to next node.
 */

class Node {
	
	int data;
	Node next;
	
	public Node (int d) {
		this.data = d;
		this.next = null;
	}
	
}