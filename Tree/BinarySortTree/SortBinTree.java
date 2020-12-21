package BinarySortTree;

import java.util.Stack;

public class SortBinTree {
	private Node root;
	public SortBinTree() {
		root = null;
	}
	public Node find(int key) {
		Node current = root;
		while(current.iData != key) {
			if(key < current.iData) {
				current = current.leftChild;
			}
			else 
				current = current.rightChild;
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	public void insert(int id,double dd) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if(root == null)
		{
			root = newNode;
		}
		else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(id < current.iData) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return ;
					}
				}
				else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return ;
					}
				}
				
			}
		}
	}
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key) {
			if(key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) {
				return false;
			}
		}
		if(current.leftChild != null && current.rightChild != null) {
			if(current == root) {
				current = null;
			}else if(isLeftChild) {
				parent.leftChild = null;
			}else {
				parent.rightChild = null;
			}
		}else if(current.rightChild == null) {
			if(current == root) {
				current = current.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = current.leftChild;
			}else {
				parent.rightChild = current.leftChild;
			}
		}else {
			Node successor = getSuccessor(current);
			if(current == root) {
				root = current;
			}else if(isLeftChild) {
				parent.leftChild = successor;
			}else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null) {
			successorParent = delNode;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	public void traversal(int traversalType) {
		switch(traversalType) {
			case 1: System.out.println("\nPreOrder traversal: ");
					preOrder(root);
					break;
			case 2:System.out.println("\nInOrder traversal: ");
					inOrder(root);
					break;
			case 3:System.out.println("\nPostOrder traveral: ");
					postOrder(root);
					break;
			default:
					System.out.println("Invalid Entry\n");
					break;
		}
		System.out.println();
	}
	private void preOrder(Node localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	private void inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	private void postOrder(Node localRoot) {
		if(localRoot != null) {
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
			postOrder(localRoot.leftChild);
		}
	}
	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlank = 25;
		boolean isRowEmpty = false;
		System.out.println("........................");
		while(isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int j = 0;j < nBlank;j++) {
				System.out.print(' ');
			}
			while(globalStack.isEmpty() == false) {
				Node temp = (Node)globalStack.pop();
				if(temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}else {
						System.out.print("...");
						localStack.push(null);
						localStack.push(null);
					}
					for(int j = 0;j < nBlank*2 - 2;j++) {
						System.out.print(' ');
					}
					
				}
			}
			System.out.println();
			nBlank /= 2;
			while(localStack.isEmpty() == false) {
				globalStack.push(localStack.pop());
			}
			System.out.println(".............................");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value;
		SortBinTree theTree = new SortBinTree();
		
		theTree.insert(50,1.5);
		theTree.insert(25,1.2);
		theTree.insert(75,1.7);
		theTree.insert(12,1.5);
		theTree.insert(37,1.2);
		theTree.insert(43,1.7);
		theTree.insert(30,1.5);
		theTree.insert(33,1.2);
		theTree.insert(87,1.7);
		theTree.insert(93,1.5);
		theTree.insert(97,1.5);
		
		theTree.displayTree();
		
	}

}
