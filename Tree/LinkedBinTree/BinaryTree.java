package LinkedBinTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BinaryTree<E> {

	
	/**  二叉树的根结点 */      
	private Node<E> root;

	  
	/** 
	 * 无参构造函数 
	 * @description 默认无参构造函数 
	 * @author FamxForx       
	 *            
	 */ 
	public BinaryTree() {
		super();
	}

	/**
	 * 构造函数
	 * 
	 * @description 根据一个树的根结点复制构造树
	 * @param node
	 *            原树的根结点
	 */
	public BinaryTree(Node<E> node) {
		// TODO Auto-generated constructor stub
		this.root = copy(node);
	}

	  
	/** 
	 * 构造函数 
	 * @description 根据一个树的前序遍历结果复制构造树
	 * @param preOrderStr     
	 */ 
	public BinaryTree(char[] preOrderStr) {
		root = createTreeByPreOrederStr(preOrderStr, null);
	}

	  
	/** 
	 * 构造函数 
	 * @description 根据一个树的前序遍历+中序遍历(或中序遍历+后序遍历)复制构造树
	 * @param s1
	 * @param s2
	 * @param isPreIn     
	 */ 
	public BinaryTree(String s1, String s2, boolean isPreIn) {
		if (isPreIn) {
			root = createBinaryTreeByPreAndIn(s1, s2);
		}else{
			root = createBinaryTreeByInAndPost(s1, s2);
		}
	}

	/**
	 * @description 根据广义表表达式创建树
	 * @param exp 广义表
	 */
	public void createBinaryTree(String exp) {
		LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 辅助栈
		Node<E> node = null; // 新结点
		Node<E> temp = null; // 用于入栈
		Node<E> parent = null; // 父亲结点
		boolean flag = false; // true 表示链入到父结点的左孩子位置，false表示链入父结点的右孩子位置

		for (int i = 0; i < exp.length(); i++) { // 逐个读入表达式的各个字符
			char c = exp.charAt(i);
			switch (c) {
			case '(': // 当前节点有孩子节点，入栈以便设置其孩子
				stack.push(temp);
				flag = true;
				break;
			case ')': // 设置好了栈顶节点的孩子，出栈
				stack.pop();
				break;
			case ',': // 当前节点无孩子，不需要设置其孩子节点，因此不需要入栈
				flag = false;
				break;
			default: // 创建根据内容创建节点
				node = new Node(c);
				break;
			}

			// 若树不存在，则创建树的根结点
			if (root == null) {
				root = node;
			}

			// 为栈顶节点链入子女
			if (!stack.isEmpty()) {
				if (node != null) { // 当读入的是'('、')'、','字符时，略过
					parent = stack.peek();
					if (flag) {
						parent.left = node;
					} else {
						parent.right = node;
					}
				}
			}

			temp = node; // 用于入栈
			node = null; // node链入后，置空
		}
	}
	
	/**
	 * @description 根据广义表表达式创建树
	 * @param exp 广义表
	 */
	public static Node createBinaryTree(String exp, Node root) {
		LinkedList<Node> stack = new LinkedList<Node>(); // 辅助栈
		Node node = null; // 新结点
		Node temp = null; // 用于入栈
		Node parent = null; // 父亲结点
		boolean flag = false; // true 表示链入到父结点的左孩子位置，false表示链入父结点的右孩子位置

		for (int i = 0; i < exp.length(); i++) { // 逐个读入表达式的各个字符
			char c = exp.charAt(i);
			switch (c) {
			case '(': // 当前节点有孩子节点，入栈以便设置其孩子
				stack.push(temp);
				flag = true;
				break;
			case ')': // 设置好了栈顶节点的孩子，出栈
				stack.pop();
				break;
			case ',': // 当前节点无孩子，不需要设置其孩子节点，因此不需要入栈
				flag = false;
				break;
			default: // 创建根据内容创建节点
				node = new Node(c);
				break;
			}

			// 若树不存在，则创建树的根结点
			if (root == null) {
				root = node;
			}

			// 为栈顶节点链入子女
			if (!stack.isEmpty()) {
				if (node != null) { // 当读入的是'('、')'、','字符时，略过
					parent = stack.peek();
					if (flag) {
						parent.left = node;
					} else {
						parent.right = node;
					}
				}
			}

			temp = node; // 用于入栈
			node = null; // node链入后，置空
		}
		return root;
	}

	/**
	 * @description 广序/层次遍历，工作队列
	 * @return
	 */
	public String levelOrder() {
		StringBuilder sb = new StringBuilder();
		LinkedList<Node<E>> queue = new LinkedList<Node<E>>(); // 辅助队列
		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {
				Node<E> temp = queue.pop();
				sb.append(temp.data).append(" ");

				// 在遍历当前节点时，同时将其左右孩子入队
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		return sb.toString().trim();
	}

	/**
	 * @description 前序遍历(递归)
	 * @param root
	 * @return
	 */
	public String preOrder(Node<E> root) {
		StringBuilder sb = new StringBuilder(); // 存到递归调用栈
		if (root != null) { // 递归终止条件
			sb.append(root.data + " "); // 前序遍历当前结点
			sb.append(preOrder(root.left)); // 前序遍历左子树
			sb.append(preOrder(root.right)); // 前序遍历右子树
		}
		return sb.toString();
	}

	/**
	 * @description 前序遍历(迭代):非线性结构(树)，工作栈：当前节点入栈
	 * @return
	 */
	public String preOrder() {

		StringBuilder sb = new StringBuilder();
		LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 工作栈：记录回退路径
		Node<E> node = root;

		while (node != null || !stack.isEmpty()) { // 迭代条件
			if (node != null) { // 当前节点不为空
				sb.append(node.data + " "); // 访问当前节点
				stack.push(node); // 当前节点入栈
				node = node.left; // 遍历其左子树
			} else {
				node = stack.pop(); // 弹出其父节点
				node = node.right; // 遍历其右子树
			}
		}
		return sb.toString();
	}

	/**
	 * @description 中序遍历(递归)
	 * @param root
	 * @return
	 */
	public String inOrder(Node<E> root) {
		StringBuilder sb = new StringBuilder(); // 存到递归调用栈
		if (root != null) { // 递归终止条件
			sb.append(inOrder(root.left)); // 中序遍历左子树
			sb.append(root.data + " "); // 中序遍历当前结点
			sb.append(inOrder(root.right)); // 中序遍历右子树
		}
		return sb.toString();
	}

	/**
	 * @description 中序遍历(迭代)：非线性结构(树)，工作栈：当前节点入栈
	 * 
	 * @return
	 */
	public String inOrder() {
		StringBuilder sb = new StringBuilder();
		LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 工作栈：记录回退路径
		Node<E> node = root;

		while (node != null || !stack.isEmpty()) { // 迭代条件
			if (node != null) { // 当前节点不为空
				stack.push(node); // 当前节点入栈
				node = node.left; // 遍历其左子树
			} else {
				node = stack.pop(); // 父节点弹栈
				sb.append(node.data + " "); // 访问父节点
				node = node.right; // 遍历访问其右子树
			}
		}
		return sb.toString();
	}

	/**
	 * @description 后序遍历(递归)
	 * @param root
	 * @return
	 */
	public String postOrder(Node<E> root) {
		StringBuilder sb = new StringBuilder(); // 存到递归调用栈
		if (root != null) { // 递归终止条件
			sb.append(postOrder(root.left)); // 后序遍历左子树
			sb.append(postOrder(root.right)); // 后序遍历右子树
			sb.append(root.data + " "); // 后序遍历当前结点
		}
		return sb.toString();
	}

	/**
	 * @description 后序遍历(迭代):非线性结构(树)，工作栈：当前节点入栈
	 **第三次遍历一个节点时才访问,因此需要在节点Node中新增一个bool字段，用于标记是否需要在本次访问该节点
	 * @return
	 */
	public String postOrder() {
		StringBuilder sb = new StringBuilder();
		LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 记录回退路径的工作栈
		Node<E> node = root;
		while (node != null || !stack.isEmpty()) { // 迭代条件
			if (node != null) { // 当前节点不为空
				node.isFirst = true; // 首次访问该节点，记为true
				stack.push(node); // 压栈操作
				node = node.left; // 继续遍历左子树
			} else { // 当前节点为空但工作栈不为空
				node = stack.pop(); // 当前节点弹栈
				if (node.isFirst) {
					node.isFirst = false; // 第二次访问该节点,改为false
					stack.push(node); // 只有在第三次才访问，因此，前节点再次压栈
					node = node.right; // 访问该节点的右子树
				} else { // 第三次访问该节点
					sb.append(node.data + " "); // 访问
					node = null; // 当前节点的左子树、右子树及本身均已访问,需要访问工作栈中的节点
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @description 根据前序、中序遍历结果重建二叉树
	 * @return
	 */
	public Node<E> createBinaryTreeByPreAndIn(String pre, String in) {
		if (pre.length() > 0) {
			Node<E> root = new Node(pre.charAt(0));
			int index = in.indexOf(pre.charAt(0));
			root.left = createBinaryTreeByPreAndIn(pre.substring(1, index + 1),
					in.substring(0, index));
			root.right = createBinaryTreeByPreAndIn(
					pre.substring(index + 1, pre.length()),
					in.substring(index + 1, in.length()));
			return root;
		}
		return null;
	}
	/**
	 * @description 删除树中的某个结点
	 * @param data
	 * @param node
	 * @return
	 */
	public Node<E> remove(char data, Node<E> node) {
		Node<E> tmp = null;
		if (node != null) {
			if (data < (char)node.data) { // 从左子树删除
				node.left = remove(data, node.left);
			} else if (data > (char)node.data) { // 从右子树删除
				node.right = remove(data, node.right);
			} else if (node.left != null && node.right != null) { // 找到待删除结点，且其左右子树不为空
				// 找到以待删除结点右子树的中序遍历第一个结点(最小结点)
				tmp = node.right;
				while (tmp.left != null) {
					tmp = tmp.left;
				}

				// 用最小结点补位待删除结点
				node.data = tmp.data;

				// 删除待删除结点右子树上补位结点
				node.right = remove((char)node.data, node.right);
			} else {
				if (node.left == null) {
					node = node.right;
				} else {
					node = node.left;
				}
			}
		}
		return node;
	}
	/**
	 * @description 根据中序、后序遍历结果重建二叉树
	 * @return
	 */
	public Node<E> createBinaryTreeByInAndPost(String in, String post) {
		if (post.length() > 0) {
			Node<E> root = new Node(post.charAt(post.length() - 1));
			int index = in.indexOf(post.charAt(post.length() - 1));

			root.left = createBinaryTreeByInAndPost(in.substring(0, index),
					post.substring(0, index));
			root.right = createBinaryTreeByInAndPost(
					in.substring(index + 1, in.length()),
					post.substring(index, post.length() - 1));
			return root;
		}
		return null;
	}

	/**
	 * @description 根据原树的根结点复制出一颗一模一样的树
	 * @param root
	 * @return
	 */
	public Node<E> copy(Node<E> root) {
		if (root == null)
			return null;
		Node<E> node = new Node<E>(null);
		node.data = root.data;
		node.left = copy(root.left);
		node.right = copy(root.right);
		return node;
	}

	/** 方法createTreeByPreOrederStr需要用到的指针 (@author: FamxForx) */
	private int index = 0;

	/**
	 * @description 根据前序遍历结果重建二叉树，所有的叶子节点都用"#"表示
	 * @param preOrderStr
	 * @param temp
	 * @return
	 */
	public Node<E> createTreeByPreOrederStr(char[] preOrderStr, Node<E> temp) {
		if (index < preOrderStr.length) {
			char c = preOrderStr[index++];
			if (c != '#') { // 递归终止条件
				Node<E> node = new Node(c);
				node.left = createTreeByPreOrederStr(preOrderStr, node); // 递归为当前节点创建左子树
				node.right = createTreeByPreOrederStr(preOrderStr, node); // 递归为当前节点创建右子树
				return node;
			}
			return null;
		}
		return null;
	}
	
	/**
	 * @description 获取树的根结点
	 * @return
	 */
	public Node<E> getRoot() {
		return root;
	}

	/**
	 * @description 获得当前结点的左孩子结点
	 * @param node
	 * @return
	 */
	public Node<E> getLeftChild(Node<E> node) {
		return node.left;
	}

	/**
	 * @description 获得当前结点的右孩子结点
	 * @param node
	 * @return
	 */
	public Node<E> getRightChild(Node<E> node) {
		return node.right;
	}

	/**
	 * @description 后序遍历的思想：树中节点个数
	 * @param root
	 * @return
	 */
	public int size(Node<E> root) {
		if (root != null) { // 递归终止条件
			return size(root.left) + size(root.right) + 1;
		}
		return 0;
	}

	/**
	 * @description 后序遍历的思想：树的高度(空树为0)
	 * @param root
	 * @return
	 */
	public int height(Node<E> root) {
		if (root != null) { // 递归终止条件
			int h1 = height(root.left);
			int h2 = height(root.right);
			return h1 > h2 ? h1 + 1 : h2 + 1;
		}
		return 0;
	}

	/**
	 * @description 以广义表的形式打印二叉树：前序遍历的应用
	 * @param root
	 * @return
	 */
	public String printBinaryTree(Node<E> root) {
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			sb.append(root.data);
			if (root.left != null || root.right != null) {
				sb.append('(');
				sb.append(printBinaryTree(root.left));
				sb.append(',');
				sb.append(printBinaryTree(root.right));
				sb.append(')');
			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return levelOrder();
	}

	/**
	 * @description 根据树的根结点判断两颗树是否相等
	 * @param src
	 **           原树的根结点
	 * @param des
	 **         目标树的根结点
	 * @return
	 */
	private boolean equals0(Node<E> src, Node<E> des) {
		if (src == null && des == null) { // 空树相等
			return true;
		} else if (src == null || des == null) { // 空树与非空树不相等
			return false;
		} else { // 非空树与非空树是否相等：当前节点是否相等 && 左子树是否相等 && 右子树是否相等
			return src.equals(des) && equals0(src.left, des.left)
					&& equals0(src.right, des.right);
		}
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof BinaryTree) { // 对方是否也是一颗二叉树
			@SuppressWarnings("unchecked")
			BinaryTree<E> tree = (BinaryTree<E>) obj;
			return equals0(this.root, tree.root);
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		while(true) {
			BinaryTree<Character> tree = new BinaryTree<>();
			BinaryTree<Character> tree1 = new BinaryTree<>();
			BinaryTree<Character> tree2 = new BinaryTree<>(tree.getRoot());
			BinaryTree<Character> tree3 = new BinaryTree<Character>("ABC##DE#G##F###".toCharArray());
			tree.createBinaryTree("A(B(D,E(G(I,J),M)),C(F(,H(,K)),))");
			System.out.println("Please enter the first letter of ");
			System.out.println("travesalType,reBuildBinTreeType,deleteNode,copyTree,genListPri: ");
			char choice = getChar();
			switch(choice) {
				case 's':
					System.out.println("Please enter the second letter of ");
					System.out.println("prePri,inPri,postPri,travesal: ");
					char choice2 = getChar();
					switch(choice2) {
						case 'p':
							System.out.println("tree的前序遍历 (递归):" + tree.preOrder(tree.getRoot()));
							System.out.println("tree的前序遍历(迭代):" + tree.preOrder());
							System.out.println("\n-------------------------------------\n");
							break;
						case 'i':
							System.out.println("tree的中序遍历 (递归):" + tree.inOrder(tree.getRoot()));
							System.out.println("tree的中序遍历(迭代):" + tree.inOrder());
							System.out.println("\n-------------------------------------\n");
							break;
						case 'o':
							System.out.println("tree的后序遍历 (递归):" + tree.postOrder(tree.getRoot()));
							System.out.println("tree的后序遍历(迭代):" + tree.postOrder());
							System.out.println("\n-------------------------------------\n");
							break;
						case 's':
							System.out.println("tree的层次(广序)遍历:" + tree.levelOrder());
							System.out.println("\n-------------------------------------\n");
							break;
						default:
							System.out.println("Invalid entry\n");
							break;
					}
					break;
				case 'b':
					System.out.println("Please enter the third letter of ");
					System.out.println("PreAndIn,InAndPost, ");
					char choice3 = getChar();
					switch(choice3) {
						case 'n':
							// 根据tree的先序遍历和中序遍历结果构建树
							String pre = tree.preOrder().replace(" ", "");
							String in = tree.inOrder().replace(" ", "");
							BinaryTree<Character> tree4 = new BinaryTree<Character>(pre, in, true);
							System.out.println("根据tree的先序遍历和中序遍历结果构建的tree4为 ："+ tree.printBinaryTree(tree4.getRoot()));
							System.out.println("tree与tree4是否相等： " + tree.equals(tree4));
							System.out.println("\n----------------------------------------------\n");
							break;
						case 't':
							// 根据tree的中序遍历和后序遍历结果构建树
							String post = tree.postOrder().replace(" ", "");
							String in1 = tree.inOrder().replace(" ", "");
							BinaryTree<Character> tree5 = new BinaryTree<Character>(in1, post, false);
							System.out.println("根据tree的中序遍历和后序遍历结果构建的tree5为 ："+ tree.printBinaryTree(tree5.getRoot()));
							System.out.println("tree与tree5是否相等： " + tree.equals(tree5));
							System.out.println("\n----------------------------------------------\n");
							break;
						case 'p':
							// 根据tree的先序遍历和后序遍历结果构建树
							String pre1 = tree.preOrder().replace(" ", "");
							String post1 = tree.postOrder().replace(" ", "");
							BinaryTree<Character> tree6 = new BinaryTree<>(pre1,post1,false);
							System.out.println("根据tree的先序遍历和后续遍历结果构建的tree6为 ：" + tree.printBinaryTree(tree6.getRoot()));
							System.out.println("tree与tree6是否相等：" + tree.equals(tree6));
							System.out.println("\n---------------------------------------------\n");
							break;
						case 'r':
							// 根据前序遍历创建树
							System.out.println("根据前序遍历创建二叉树: " + tree3.printBinaryTree(tree3.getRoot()));
							System.out.println("前序遍历tree3： " + tree.preOrder(tree3.getRoot()));
							System.out.println("中序遍历tree3： " + tree.inOrder(tree3.getRoot()));
							System.out.println("后序遍历tree3： " + tree.postOrder(tree3.getRoot()));
							System.out.println("\n----------------------------------------------\n");
							break;
						default:
							System.out.println("Invalid entry\n");
							break;
					}
					break;
				case 'd':
					System.out.println("删除结点后树的结构为:");
					tree.remove('A',tree.getRoot());
					System.out.println("前序遍历tree3： " + tree.preOrder(tree.getRoot()));
					System.out.println("中序遍历tree3： " + tree.inOrder(tree.getRoot()));
					System.out.println("后序遍历tree3： " + tree.postOrder(tree.getRoot()));
					System.out.println("\n----------------------------------------------\n");
					break;
				case 'c':
					System.out.println("Please enter the fourth letter of ");
					System.out.println("copyValue,copyStructure: ");
					char choice4 = getChar();
					switch(choice4) {
						case 'v':
							//复制并构造树				
							System.out.println("tree为:" + tree.printBinaryTree(tree.getRoot()));
							System.out.println("复制tree为tree2:" + tree2.printBinaryTree(tree2.getRoot()));
							//判断tree2 与tree 是否相等
							System.out.println("tree2 与 tree是否相等:" + tree.equals(tree2));
							System.out.println("\n -------------------------- \n");
							break;
						case 's':
							//构造tree1
							tree1.createBinaryTree("A(B(D,E(G(I,J),)),C(F(,H(,K)),))");
							System.out.println("tree 为：" + tree.printBinaryTree(tree.getRoot()));
							System.out.println("构造的tree1为：" + tree1.printBinaryTree(tree1.getRoot()));
							//判断tree1 与 tree 是否相等
							System.out.println("tree1 与 tree 是否相等？" + tree.equals(tree1));
							System.out.println("\n --------------------------------------\n");
							break;
					}
				break;
				case 'g':
					// 以广义表的形式打印二叉树
					System.out.println("以广义表的形式打印tree为 ：" + tree.printBinaryTree(tree.getRoot()));
					System.out.println("以广义表的形式打印tree1为 ：" + tree1.printBinaryTree(tree1.getRoot()));
					System.out.println("以广义表的形式打印tree2为 ：" + tree2.printBinaryTree(tree2.getRoot()));
					System.out.println("以广义表的形式打印tree3为 ：" + tree3.printBinaryTree(tree3.getRoot()));
					System.out.println("\n----------------------------------------------\n");
					break;
				default:
					System.out.println("Invalid entry\n");
					break;
			}
		}
	}
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



