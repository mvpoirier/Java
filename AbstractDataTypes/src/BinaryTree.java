/*
 * Developing a basic implementation of a Binary Tree.
 * Source Video: https://www.youtube.com/watch?v=oSWTXtMglKE
 */

public class BinaryTree {
	public static void main (String[] args) {
		BinaryIntTree myTree = new BinaryIntTree(5);
		myTree.insert(4);
		myTree.insert(6);
		System.out.println(myTree.contains(1));
		System.out.println(myTree.contains(6));
		myTree.printInOrder();
	}
}

class BinaryIntTree{
	
	// Treat each binary tree as the root of a subtree of left and right children
	BinaryIntTree left, right;
	int data;
	
	public BinaryIntTree (int data) {
		this.data = data;
	}
	
	// Recursively insert 'value' into the tree, in correct order
	public void insert (int value) {
		if (value <= data) {
			if (left == null) {
				left = new BinaryIntTree(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new BinaryIntTree(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	// Recursively search for 'value' in the tree
	public boolean contains (int value) {
		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else if (right == null) {
			return false;
		} else {
			return right.contains(value);
		}
	}
	
	// Recursively print using an In Order Traversal
	public void printInOrder () {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if (right != null) {
			right.printInOrder();
		}
	}
}