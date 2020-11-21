import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Title: Node��
 * @description ���������ʾ���Ľṹ���ô洢����������Ե�λ������ʾ��������е�λ�á�
 */
class Node{
	public int iData; // ������ݱ����ڱ�ʾ��ֵ
	public double dData; // ��������
	public Node leftChild; // ���node������ʾ��������
	public Node rightChild; // ���node������ʾ�����Һ���
	public void displayNode(){
		//������ʾ�ڵ������
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
// 		person p1; // �ο�person����
// 		Node leftChild; //���node������ʾ��������
// 		Node rightChild; // ���node������ʾ�����Һ���
//}
//class person{
// 		int iData;// ������ݱ����ڱ�ʾ��ֵ
// 		double dData;// ��������
//}
public class BinaryTree{
	private Node root;//���ڱ�ʾ���ڵ������
	public BinaryTree(){
		root = null;
	}
	public Node find(int key){ // ��ѯ��㲢������ֵ����ȷ�����ǿ���������£�,key��ʾҪѰ�ҵý��
		Node current = root;//������ڵ�
		while(current.iData != key){//����������ƥ�����㣬��˵���к���
			if(key < current.iData)//���ؼ���ֵС�ڸ����ؼ���ֵ����Ҫ�ҵý��϶��������󲿷���--�����Ǹ������ӽ�㣬���������ӽ�㡣
			{
				current = current.leftChild;
			}
			else if(key > current.iData)
			{
				current = current.rightChild;
			}
			if(current == null)//���û�к��ӣ���û���ҵ�
				return null;
		}
		return current;//�����ҵ��ùؼ���
	}
	 public void insert(int id,double dd){
		Node newNode = new Node();//����һ���½ڵ�
		newNode.iData = id;//������ֵ
		newNode.dData = dd;//������������ֵ
		if(root == null) // �жϽ���Ƿ��Ǹ��ڵ�
			root = newNode;
		else //�����root��ռ��
		{
			Node current = root;//�Ӹ��ڵ㿪ʼ
			Node parent;//current�ø��ڵ㣬���ڴ洢���������һ������null�ý�㡣������洢����ʧȥ�����½ڵ��λ��
			while(true){ //(�ڲ��˳�)
				parent = current;//������һ���±���parent��current��˫�׽�㣩�����洢���������һ������Null�ý�㡣
				if (id < current.iData){ //���ؼ���ֵС�ڸ����ؼ���ֵ����Ҫ�ҵý��϶��������󲿷���--�����Ǹ������ӽ�㣬���������ӽ�㡣
					current = current.leftChild;
					if(current == null)// ����ѯ�����ˣ������ؼ��ֵ����ӽ��
					{
						parent.leftChild = newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){// ����ѯ�����ˣ������ؼ��ֵ����ӽ��
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	//ǰ�������*A+BC��
	public void preOrder(Node localRoot){//��ʼʱ�ø���Ϊ���������������inOrder(root)��֮��ʵ�ֵݹ���̣�ֱ�����н�㶼������Ϊֹ
		if(localRoot != null)//�������Ϊ��
		{
			System.out.print(localRoot.iData + " ");//���ʸý��
			preOrder(localRoot.leftChild);//���������������������
			preOrder(localRoot.rightChild);//�����������������������
		}
	}
	//���������A*(B + C)��
	public void inOrder(Node localRoot){//��ʼʱ�ø���Ϊ���������������inOrder(root)��֮��ʵ�ֵݹ���̣�ֱ�����н�㶼������Ϊֹ
		if(localRoot != null)//�������Ϊ��
		{
			inOrder(localRoot.leftChild);//���������������������
			System.out.print(localRoot.iData + " ");//���ʸý��
			inOrder(localRoot.rightChild);//�����������������������
		}
	}
	//�������(ABC++)
	public void postOrder(Node localRoot) {//��ʼʱ�ø���Ϊ���������������inOrder(root)��֮��ʵ�ֵݹ���̣�ֱ�����н�㶼������Ϊֹ
		if (localRoot != null) {//�������Ϊ��
			postOrder(localRoot.leftChild);//���������������������
			postOrder(localRoot.rightChild);//�����������������������
			System.out.print(localRoot.iData + " ");//���ʸý��
		}
	}
	//��α���
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
	public boolean delete(int key){//ɾ�����ùؼ���(ȷ�����ǿ����������)����Ϊjava�����������Զ��ռ����ƣ����Բ���Ҫ�ǵðѽ�㱾���ɾ������
		Node current = root;//������ڵ�
		Node parent = root;//���ڱ���Ҫɾ���ý��
		boolean isLeftChild = true;//�ж��Ƿ�Ϊ����

		while(current.iData != key) {//����Ҳ�����㣬�ʹ�delete()��������false,����ҵ�����ˣ����whileѭ����������parent����Ҫɾ���ý�㡣
			parent = current;
			if (key < current.iData)//���ؼ���ֵС�ڸ����ؼ���ֵ����Ҫ�ҵý��϶��������󲿷���--�����Ǹ������ӽ�㣬���������ӽ�㡣
			{
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)// ������
				return false; //û���ҵ�
		}
		//�ҵ���㲢ɾ������û���ҵ��������ִ��delete()���������û�к��ӣ�ֱ��ɾ�������
		if(current.leftChild == null && current.rightChild == null)
		{
			if(current == root)
				root = null;
			if(isLeftChild)
				parent.leftChild = null; //û�й���
			else //��˫�׽�㿪ʼ
				parent.rightChild = null;
		}
		//���û���Һ��ӣ����滻������
		else if(current.rightChild == null)
		{
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild) //���ӵ�˫�׽��
				parent.leftChild = current.leftChild;
			else //�к��ӵ�˫�׽��
				parent.rightChild = current.rightChild;
		}
		//���û�����ӣ����滻������
		else if(current.leftChild == null)
		{
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild) //���ӵ�˫�׽��
				parent.leftChild = current.rightChild;
			else //�Һ��ӵ�˫�׽��
				parent.rightChild = current.rightChild;
		}
		else { //���������ӣ���˴���ǰ��ú������successor

			//��ȡҪɾ�����ú������successor
			Node successor  = getSuccessor(current);

			//����˫�׵�currentȥ����������
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;//��current����˫�׽���rightChild�ֶ��Ƴ���������ֶ���Ϊsuccessor

			//��ǰ�����������ӵ������ڵ�
			successor.leftChild = current.leftChild;//��current�����ӽ���current�Դ���successor��LeftChild�ֶ���Ϊcurrent�����ӽ��
		}
		return true;
	}
	private Node getSuccessor(Node delNode){ //���ز���delNode�ú�̽�㣨�����������delNode�����ӽ�㣬��Ϊ�Ѿ��жϹ����Ҫɾ���ý����������㣩
		Node successorParent = delNode;//delNode ��Ϊ��ǰ˫�׽��
		Node successor = delNode;
		Node current = delNode.rightChild;//�ҵ��Һ���
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;//�ҵ�����
		}
		if(successor != delNode.rightChild)//�����̽�㲻��Ҫɾ���������ӽ��ʱ������Ѱ�Һ�̽��
		{
			successorParent.leftChild = successor.rightChild;//�Ѻ��˫�׽���leftChild�ֶ���Ϊsuccessor�����ӽ��
			successor.rightChild = delNode.rightChild;//��successor��rightChild�ֶ���ΪҪɾ���������ӽ��
		}
		return successor;//���غ�̽��

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
	public Node minimum(){ //������С�ؼ���ֵ�������ӵ�ֵ��
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
	public Node maximum(){ //�������ؼ���ֵ�����Һ��ӵ�ֵ��
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
		BinaryTree tree = new BinaryTree();//����һ����
		
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
		System.out.println("�����ֵ��"+tree.maximum().iData + "," + tree.maximum().dData);
		System.out.println("��С��ֵ��"+tree.minimum().iData + "," + tree.minimum().dData);
		System.out.println("������ֵ:" + tree.getRoot().iData + "," + tree.getRoot().dData);

//		Node found2 = tree.find(25);
//		if(found2 != null)
//			System.out.println("Found the node with 25");
//		else
//			System.out.println("Could not found node with key 25");
//		����ѡ��������:
//		���õ���������ĸs��i��f��t���ֱ�������ʾ�����롢���ҡ�������i��fѡ����Ҫ����Ҫ�������ùؼ�֮��tѡ��Ҫ�û�ѡ������÷�ʽ��
//		1.��ǰ�������2.�����������3.�Ǻ���������ؼ���ֵ�Ͱ��û�ѡ��ñ���˳����ʾ������
//		��ʾ�������԰ѹؼ�֮����������չʾ����;����Ҫ����ߵô��ڡ��������߷��ţ�--����ʾ�������λ�õý�㲻���ڡ������ʼ��ʱ����һЩ��㣬
//		�û���û�����κβ������֮ǰ�Ϳ��Կ������ǡ������޸ĳ�ʼ���ô��룬����Ҫ���κν�㿪ʼ����û���κν�㡣
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

