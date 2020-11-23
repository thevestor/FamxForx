package HuffTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//哈夫曼编码：实现无损压缩
public class HuffManTree {
	private Node root;
	//存放哈夫曼编码的结果：每个字符 + 对应的哈夫曼编码
	private Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	//设定哈夫曼的根节点，需要创建哈夫曼树之后才能使用该函数，进而使用前序遍历
	public void setRoot(Node root) {
		this.root = root;
	}
	//前序遍历
	public void preOrderTraversal() {
		System.out.println("\n================= 前序遍历结果为 =================");
		if(root != null)
			root.preOrderTraversal();
		else
			System.out.println("Tree is null");
	}
	//接收字节数据，存入到Node中
	public List<Node> getNodes(byte[] bytes){
		ArrayList<Node> nodes = new ArrayList<Node>();
		Map<Byte,Integer> counts = new HashMap<>();
		//遍历bytes，统计内每个byte出现的次数
		for(byte b : bytes) {
			Integer count = counts.get(b);
			//该byte第一次出现
			if(count == null)
				counts.put(b,1);
			else
				counts.put(b,count + 1);
		}
		//将键值对，转换成Node对象，存到Node的集合中，存入结点的数据为：字符的ascll值，字符出现的频率
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
	//创建哈夫曼树
	public Node createHuffmanTree(byte[] bytes) {
		List<Node> arrayList = new ArrayList<>();
		//1.将数组放入ArrayList中
		arrayList = getNodes(bytes);
		//2.创建哈夫曼树
		while(arrayList.size() > 1) {
			//3.将arrayList中的元素排序：从小到大
			Collections.sort(arrayList);
			
			//4.选取最小的两个创建二叉树
			Node leftNode = arrayList.get(0);
			Node rightNode = arrayList.get(1);
			Node parentNode = new Node(leftNode.getWeight() + rightNode.getWeight());

			//引用孩子结点
			parentNode.setLeftNode(leftNode);
			parentNode.setRightNode(rightNode);
			
			//5.删除已经使用的两个最小结点，并添加新建的结点
			arrayList.remove(leftNode);
			arrayList.remove(rightNode);
			arrayList.add(parentNode);
		}
		return arrayList.get(0);
	} 
	//找到字符串的编码，0为左孩子,1为右孩子（在非空树的情况下）
	public Map<Byte,String> getCode(Node root){
		if(root == null)
		{
			System.out.println("Tree is null");
		}
		StringBuilder stringBuilder = new StringBuilder();
		getCode(root,"0",stringBuilder);
		getCode(root,"1",stringBuilder);
		return huffmanCodes;
	}
	private void getCode(Node node, String code, StringBuilder stringBuilder) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder2 = new StringBuilder();
		stringBuilder2.append(code);
		if(node != null) {
			//非叶子结点
			if(node.getLeftNode() != null || node.getRightNode() != null) {
				//继续递归：直到找到叶子结点
				//左递归
				getCode(node.getLeftNode(),"1",stringBuilder2);
				//右递归
				getCode(node.getRightNode(),"0",stringBuilder2);
			}
			//获取对应字符(node.getData())的哈希编码（stringBuilder2）
			else
			{
				huffmanCodes.put(node.getData(),stringBuilder2.toString());
			}
		}
	}
	//将字符串转换成对用的哈夫曼编码，只需要传入需要转换的字符串即可
	public StringBuilder getStringHuffmanCode(String str) {
		System.out.println("\n ======================= 创建的哈夫曼编码为: ==============");
		byte[] str2bytes = str.getBytes();
		StringBuilder res = new StringBuilder();
		//1.创建哈夫曼树
		Node root = createHuffmanTree(str2bytes);
		
		//2.设置哈夫曼树的root
		setRoot(root);
		
		//3.获取每个字符对应的哈夫曼编码
		Map<Byte,String> huffmanCodes = getCode(root);
		
		//4.根据键来查询 对应字符的哈夫曼编码，再进行组装，得到该字符串对应的哈夫曼编码
		for(byte b : str2bytes) {
			res.append(huffmanCodes.get(b));
		}
		return res;
	}
	//打印编码
	public void printHuffmanCode(Map<Byte,String> hashMap) {
		System.out.println("\n ============ 打印哈夫曼树 =================");
		@SuppressWarnings("rawtypes")
		Iterator iter = hashMap.entrySet().iterator();
		while(iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			System.out.println(key + "--" + val);
		}
	}
	public static void main(String[] args) throws IOException {
		String str = "ABABDACABBAADDABCD";
        //将字符串换换成ascII
        byte[] str2byte = str.getBytes();

        HuffManTree huffmanEncode = new HuffManTree();

        //1、创建赫夫曼树
        Node root = huffmanEncode.createHuffmanTree(str2byte);

        //2、设置赫夫曼树的root
        huffmanEncode.setRoot(root);

        while(true)
		{
			System.out.println("Enter the first letter of");
			System.out.println("print,traversal,getCoding:");
			char choice = getChar();
			switch (choice){
				case 't':
					//前序遍历赫夫曼树
					huffmanEncode.preOrderTraversal();
					break;
				case 'p':
					//3、获得每个字符对应的赫夫曼编码,打印哈夫曼树
					Map<Byte,String> getHuffmanCode = huffmanEncode.getCode(root);
					huffmanEncode.printHuffmanCode(getHuffmanCode);
					break;
				case 'g':
					//4、获取字符串的赫夫曼编码：只需要传入需要转换的字符串即可
					StringBuilder res = huffmanEncode.getStringHuffmanCode(str);
					System.out.println(res);
					break;
				default:
					System.out.print("Invalid entry\n");
					break;
			}
		}
    }
	//异常处理
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

