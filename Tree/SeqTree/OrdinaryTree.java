package SeqTree;

import java.io.*;

class DataItem{
	public long dData;//long data item
	public DataItem(long dd){
		dData = dd;
	}
	public void displayItem(){
		System.out.println("/" + dData);
	}
}
class Node{
	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER - 1];
	//connect child to this node
	public void connectChild(int childNum,Node child){
		childArray[childNum] = child;
		if(child != null){
			child.parent = this;
		}
	}
	//disconnect child from this node,return it
	public Node disconnectChild(int childNum){
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	public Node getChild(int childNum){
		return childArray[childNum];
	}
	public Node getParent(){
		return parent;
	}
	public boolean isLeaf(){
		return (childArray[0] == null)?true : false;
	}
	public int getNumItems(){
		return numItems;
	}
	public DataItem getItem(int index){
		return itemArray[index];
	}
	public boolean isFull(){
		return (numItems == ORDER - 1)?true : false;
	}
	public int findItem(long key){
		for(int j = 0;j < ORDER - 1;j++)
		{
			if(itemArray[j] == null){
				break;
			}else if (itemArray[j].dData == key){
				return j;
			}
		}
		return -1;
	}
	public int insertItem(DataItem newItem){
		numItems++;
		long newKey = newItem.dData;
		
		for(int j = ORDER - 2;j >= 0;j--){
			if(itemArray[j] == null){
				continue;
			}
			else{
				long itskey = itemArray[j].dData;
				if(newKey < itskey){
					itemArray[j + 1] = itemArray[j];
				}else{
					itemArray[j + 1] = newItem;
					return j + 1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	public DataItem removeItem(){
		DataItem temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems --;
		return temp;
	}
	public void displayNode(){
		for(int j = 0;j < numItems;j++){
			itemArray[j].displayItem();
		System.out.println("/");
		}
	}
}
public class OrdinaryTree {
	private Node root = new Node();
	public int find(long key){
		Node curNode = root;
		int childNumber;
		while(true){
			if((childNumber = curNode.findItem(key)) != -1)
				return childNumber;
			else if(curNode.isLeaf())
				return -1;
			else
				curNode = getNextChild(curNode,key);
		}
	}
	
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while(true) {
			if(curNode.isFull()) {
				split(curNode);
				curNode = curNode.getParent();
				
				curNode = getNextChild(curNode,dValue);
			}else if (curNode.isLeaf()) {
				break;
			}else {
				curNode = getNextChild(curNode,dValue);
			}
		}
		curNode.insertItem(tempItem);
	}
	
	private void split(Node thisNode) {
		// TODO Auto-generated method stub
		DataItem itemB,itemC;
		Node parent,child2,child3;
		int itemIndex;
		
		itemC = thisNode.removeItem();
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);
		Node newRight = new Node();
		
		if(thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		}
		else {
			parent = thisNode.getParent();
		}
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		for(int j = n - 1;j > itemIndex;j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}
		parent.connectChild(itemIndex + 1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}

	private Node getNextChild(Node theNode, long theValue) {
		// TODO Auto-generated method stub
		int j;
		int numItems = theNode.getNumItems();
		for(j = 0;j <numItems;j++){
			if(theValue < theNode.getItem(j).dData)
				return theNode.getChild(j);
		}
		return theNode.getChild(j);
	}
	public void displayTree() {
		recDisplayTree(root,0,0);
	}
	public void recDisplayTree(Node thisNode,int level,int childNumber) {
		System.out.println("level="+level+"child="+childNumber+ " ");
		thisNode.displayNode();
		int numItems = thisNode.getNumItems();
		for(int j = 0;j < numItems + 1;j++) {
			Node nextNode = thisNode.getChild(j);
			if(nextNode != null) {
				recDisplayTree(nextNode,level + 1,j);
			}else {
				return;
			}
		}
	}
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long value;
		OrdinaryTree theTree = new OrdinaryTree();
		
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(70);
		while(true) {
			System.out.println("Enter the first letter of ");
			System.out.println("show,insert,or find: ");
			char choice = getChar();
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.println("Enter value to insert: ");
				value = getInt();
				theTree.insert(value);
				break;
			case 'f':
				System.out.println("Enter value to find: ");
				value = getInt();
				int found = theTree.find(value);
				if(found != -1)
				{
					System.out.println("Found" + value);
				}
				else {
					System.out.println("Could not find" + value);
				}
				break;
			default:
				System.out.println("Invalid entry\n");
			}
		}
	}
	//�쳣����
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
	

}
