import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Title: Node类
 * @description 利用数组表示树的结构，用存储在数组中相对的位置来表示结点在树中的位置。
 */
class Node{
	public int iData; // 这个数据被用于表示主值
	public double dData; // 其他数据
	public Node leftChild; // 这个node变量表示的是左孩子
	public Node rightChild; // 这个node变量表示的是右孩子
	public void displayNode(){
		//用于显示节点的数据
		System.out.print('{');
		System.out.print(iData);
		System.out.print(",");
		System.out.print(dData);
		System.out.print("}");
	}
	public char[] find() {
		// TODO Auto-generated method stub
		return null;
	}
}
//public class Node {
// 		person p1; // 参考person对象
// 		Node leftChild; //这个node变量表示的是左孩子
// 		Node rightChild; // 这个node变量表示的是右孩子
//}
//class person{
// 		int iData;// 这个数据被用于表示主值
// 		double dData;// 其他数据
//}
public class BinaryTree{
	private Node root;//用于表示根节点的数据
	public BinaryTree(){
		root = null;
	}
	public Node find(int key){ // 查询结点并给它赋值（在确保不是空树得情况下）,key表示要寻找得结点
		Node current = root;//定义根节点
		while(current.iData != key){//遍历，若不匹配根结点，则说明有孩子
			if(key < current.iData)//若关键字值小于跟结点关键字值，则要找得结点肯定在树得左部分中--可能是根得左子结点，否则是右子结点。
			{
				current = current.leftChild;
			}
			else if(key > current.iData)
			{
				current = current.rightChild;
			}
			if(current == null)//如果没有孩子，则没有找到
				return null;
		}
		return current;//返回找到得关键字
	}
	 public void insert(int id,double dd){
		Node newNode = new Node();//创建一个新节点
		newNode.iData = id;//插入主值
		newNode.dData = dd;//插入其他数据值
		if(root == null) // 判断结点是否是根节点
			root = newNode;
		else //跟结点root被占用
		{
			Node current = root;//从根节点开始
			Node parent;//current得父节点，用于存储遇到得最后一个不是null得结点。如果不存储，则失去插入新节点得位置
			while(true){ //(内部退出)
				parent = current;//这里用一个新变量parent（current得双亲结点），来存储遇到得最后一个不是Null得结点。
				if (id < current.iData){ //若关键字值小于跟结点关键字值，则要找得结点肯定在树得左部分中--可能是根得左子结点，否则是右子结点。
					current = current.leftChild;
					if(current == null)// 若查询到底了，则插入关键字到左子结点
					{
						parent.leftChild = newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){// 若查询到底了，则插入关键字到右子结点
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	//前序遍历（*A+BC）
	public void preOrder(Node localRoot){//开始时用根作为参数调用这个方法inOrder(root)；之后实现递归过程，直到所有结点都被访问为止
		if(localRoot != null)//如果树不为空
		{
			System.out.print(localRoot.iData + " ");//访问该结点
			preOrder(localRoot.leftChild);//调用自身遍历结点得左子树
			preOrder(localRoot.rightChild);//调用自身白能力结点得右子树
		}
	}
	//中序遍历（A*(B + C)）
	public void inOrder(Node localRoot){//开始时用根作为参数调用这个方法inOrder(root)；之后实现递归过程，直到所有结点都被访问为止
		if(localRoot != null)//如果树不为空
		{
			inOrder(localRoot.leftChild);//调用自身遍历结点得左子树
			System.out.print(localRoot.iData + " ");//访问该结点
			inOrder(localRoot.rightChild);//调用自身白能力结点得右子树
		}
	}
	//后序遍历(ABC++)
	public void postOrder(Node localRoot) {//开始时用根作为参数调用这个方法inOrder(root)；之后实现递归过程，直到所有结点都被访问为止
		if (localRoot != null) {//如果树不为空
			postOrder(localRoot.leftChild);//调用自身遍历结点得左子树
			postOrder(localRoot.rightChild);//调用自身白能力结点得右子树
			System.out.print(localRoot.iData + " ");//访问该结点
		}
	}
	//层次遍历
	public void traverse(int traverseType){
		switch(traverseType){
			case 1: System.out.print("\n preOrder travesal: ");
					preOrder(root);
					break;
			case 2: System.out.print("\n inOrder travesal: ");
					inOrder(root);
					break;
			case 3: System.out.print("\n postOrder travesal: ");
			        postOrder(root);
			        break;
		}
		System.out.println();
	}
	public boolean delete(int key){//删除结点得关键字(确保不是空树得情况下)，因为java语言有垃圾自动收集机制，所以不需要非得把结点本身给删除掉。
		Node current = root;//定义根节点
		Node parent = root;//用于保存要删除得结点
		boolean isLeftChild = true;//判断是否为左孩子

		while(current.iData != key) {//如果找不到结点，就从delete()方法返回false,如果找到结点了，则从while循环中跳出。parent保存要删除得结点。
			parent = current;
			if (key < current.iData)//若关键字值小于跟结点关键字值，则要找得结点肯定在树得左部分中--可能是根得左子结点，否则是右子结点。
			{
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)// 到底了
				return false; //没有找到
		}
		//找到结点并删除，若没有找到，则继续执行delete()函数，如果没有孩子，直接删除根结点
		if(current.leftChild == null && current.rightChild == null)
		{
			if(current == root)
				root = null;
			if(isLeftChild)
				parent.leftChild = null; //没有关联
			else //从双亲结点开始
				parent.rightChild = null;
		}
		//如果没有右孩子，则替换左子树
		else if(current.rightChild == null)
		{
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild) //左孩子得双亲结点
				parent.leftChild = current.leftChild;
			else //有孩子得双亲结点
				parent.rightChild = current.rightChild;
		}
		//如果没有左孩子，则替换右子树
		else if(current.leftChild == null)
		{
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild) //左孩子得双亲结点
				parent.leftChild = current.rightChild;
			else //右孩子得双亲结点
				parent.rightChild = current.rightChild;
		}
		else { //有两个孩子，因此代替前序得后续结点successor

			//获取要删除结点得后续结点successor
			Node successor  = getSuccessor(current);

			//关联双亲得current去代替后续结点
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;//把current从它双亲结点得rightChild字段移除，把这个字段置为successor

			//当前结点得左孩子链接到后续节点
			successor.leftChild = current.leftChild;//把current得左子结点从current自处，successor得LeftChild字段置为current得左子结点
		}
		return true;
	}
	private Node getSuccessor(Node delNode){ //返回参数delNode得后继结点（这个方法假设delNode有右子结点，因为已经判断过这个要删除得结点有两个结点）
		Node successorParent = delNode;//delNode 作为当前双亲结点
		Node successor = delNode;
		Node current = delNode.rightChild;//找到右孩子
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;//找到左孩子
		}
		if(successor != delNode.rightChild)//如果后继结点不是要删除结点得右子结点时，向下寻找后继结点
		{
			successorParent.leftChild = successor.rightChild;//把后继双亲结点得leftChild字段置为successor得右子结点
			successor.rightChild = delNode.rightChild;//把successor得rightChild字段置为要删除结点得右子结点
		}
		return successor;//返回后继结点

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("................................................");
		while(isRowEmpty == false){
			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j = 0;j < nBlanks;j++)
				System.out.print(' ');
			while(globalStack.isEmpty() == false)
			{
				Node temp = (Node)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}
				else{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0;j < nBlanks*2-2;j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false){
				globalStack.push(localStack.pop());
			}
			System.out.println("........................................................");
		}
	}
	public Node minimum(){ //返回最小关键字值（即左孩子得值）
		Node current;
		Node last = new Node();
		current = root;
		while(current != null)
		{
			last = current;
			current = current.leftChild;
		}
		return last;
	}
	public Node maximum(){ //返回最大关键字值（即右孩子得值）
		Node current;
		Node last = new Node();
		current = root;
		while(current != null)
		{
			last = current;
			current = current.rightChild;
		}
		return last;
	}
	public Node getRoot(){
		return root;
	}
	public static void main(String[] args) throws IOException {
		int value;
		BinaryTree tree = new BinaryTree();//创建一个树
		
		tree.insert(50,1.5);
		tree.insert(25,1.2);
		tree.insert(75,1.7);
		tree.insert(12,1.5);
		tree.insert(37,1.2);
		tree.insert(43,1.7);
		tree.insert(30,1.5);
		tree.insert(33,1.2);
		tree.insert(87,1.7);
		tree.insert(93,1.5);
		tree.insert(97,1.5);

		//tree.displayTree();
		System.out.println("最大数值："+tree.maximum().iData + "," + tree.maximum().dData);
		System.out.println("最小数值："+tree.minimum().iData + "," + tree.minimum().dData);
		System.out.println("根结点的值:" + tree.getRoot().iData + "," + tree.getRoot().dData);

//		Node found2 = tree.find(25);
//		if(found2 != null)
//			System.out.println("Found the node with 25");
//		else
//			System.out.println("Could not found node with key 25");
//		下列选择程序介绍:
//		可用得命令是字母s、i、f、t，分别用于显示、插入、查找、遍历。i、f选项需要输入要操作结点得关键之。t选项要用户选择遍历得方式：
//		1.是前序遍历，2.是中序遍历，3.是后序遍历。关键字值就按用户选择得遍历顺序显示出来。
//		显示方法可以把关键之按树形排列展示出来;但需要设想边得存在。两个短线符号（--）表示树中这个位置得结点不存在。程序初始化时创建一些结点，
//		用户在没有做任何插入操作之前就可以看到它们。可以修改初始化得代码，从需要得任何结点开始，或没有任何结点。
		while(true)
		{
			System.out.print("Enter the first letter of show,");
			System.out.print("insert,find,delete,or traverse:");
			int choice = getChar();
			switch (choice)
			{
				case 's':
					tree.displayTree();
					break;
				case 'i':
					System.out.print("Enter value to insert:");
					value = getInt();
					tree.insert(value,value + 0.9);
					break;
				case 'f':
					System.out.print("Enter value to find:");
					value = getInt();
					Node found = tree.find(value);
					if(found != null)
					{
						System.out.print("Found:");
						found.displayNode();
						System.out.print("\n");
					}
					else
					{
						System.out.print("Could not found \n");
						System.out.print(value + '\n');
					}
					break;
				case 't':
					System.out.print("Enter type 1,2 or 3:");
					value = getInt();
					tree.traverse(value);
					break;
				default:
					System.out.print("Invalid entry\n");
			}
		}
	}
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}

}

