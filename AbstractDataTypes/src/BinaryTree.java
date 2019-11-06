/*
 * Developing a basic implementation of a BinaryTree.
 */

public class BinaryTree {
	Node root;
	
	public BinaryTree () {
		root = null;
	}
	
	public BinaryTree (int[] sortedArray) {
		Node curr;
		root = new Node (this.root, sortedArray[0]);
		
		for (int i = 0; i < sortedArray.length; i++) {
			// create child nodes... not sure...
		}
		
		
	}

}

class Node {
	Node parent;
	Node leftChild;
	Node rightChild;
	int data;
	
	public Node (Node p, int d) {
		this.parent = p;
		this.data = d;
		this.leftChild = null;
		this.rightChild = null;
	}
}
