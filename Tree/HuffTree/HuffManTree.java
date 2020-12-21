package HuffTree;

import java.util.*;

//���������룺ʵ������ѹ��
public class HuffManTree {
	private Node root;
	//��Ź���������Ľ����ÿ���ַ� + ��Ӧ�Ĺ���������
	private Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	//�趨�������ĸ��ڵ㣬��Ҫ������������֮�����ʹ�øú���������ʹ��ǰ�����
	public void setRoot(Node root) {
		this.root = root;
	}
	//ǰ�����
	public void preOrderTravesal() {
		System.out.println("\n================= PreOrderTraversal =================");
		if(root != null)
			root.preOrderTraversal();
		else
			System.out.println("Tree is null");
	}
	//�����ֽ����ݣ����뵽Node��
	public List<Node> getNodes(byte[] bytes){
		ArrayList<Node> nodes = new ArrayList<Node>();
		Map<Byte,Integer> counts = new HashMap<>();
		//����bytes��ͳ����ÿ��byte���ֵĴ���
		for(byte b : bytes) {
			Integer count = counts.get(b);
			//��byte��һ�γ���
			if(count == null)
				counts.put(b,1);
			else
				counts.put(b,count + 1);
		}
		//����ֵ�ԣ�ת����Node���󣬴浽Node�ļ����У������������Ϊ���ַ���ascllֵ���ַ����ֵ�Ƶ��
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
	//������������
	public Node createHuffmanTree(byte[] bytes) {
		List<Node> arrayList = new ArrayList<>();
		//1.���������ArrayList��
		arrayList = getNodes(bytes);
		//2.������������
		while(arrayList.size() > 1) {
			//3.��arrayList�е�Ԫ�����򣺴�С����
			Collections.sort(arrayList);
			
			//4.ѡȡ��С����������������
			Node leftNode = arrayList.get(0);
			Node rightNode = arrayList.get(1);
			Node parentNode = new Node(leftNode.getWeight() + rightNode.getWeight());
			
			parentNode.setLeftNode(leftNode);
			parentNode.setRightNode(rightNode);
			
			//5.ɾ���Ѿ�ʹ�õ�������С��㣬������½��Ľ��
			arrayList.remove(leftNode);
			arrayList.remove(rightNode);
			arrayList.add(parentNode);
		}
		return arrayList.get(0);
	} 
	//�ҵ��ַ����ı���
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
			//��Ҷ�ӽ��
			if(node.getLeftNode() != null || node.getRightNode() != null) {
				//�����ݹ飺ֱ���ҵ�Ҷ�ӽ��
				//��ݹ�
				getCode(node.getLeftNode(),"1",stringBuilder2);
				//�ҵݹ�
				getCode(node.getRightNode(),"0",stringBuilder2);
			}
			//��ȡ��Ӧ�ַ�(node.getData())�Ĺ�ϣ���루stringBuilder2��
			else
			{
				huffmanCodes.put(node.getData(),stringBuilder2.toString());
			}
		}
	}
	//���ַ���ת���ɶ��õĹ��������룬ֻ��Ҫ������Ҫת�����ַ�������
	public StringBuilder getStringHuffmanCode(String str) {
		System.out.println("\n ======================= Create strings is: ==============");
		byte[] str2bytes = str.getBytes();
		StringBuilder res = new StringBuilder();
		//1.������������
		Node root = createHuffmanTree(str2bytes);
		
		//2.���ù���������root
		setRoot(root);
		
		//3.��ȡÿ���ַ���Ӧ�Ĺ���������
		Map<Byte,String> getHuffmanCode = getCode(root);
		
		//4.���ݼ�����ѯ ��Ӧ�ַ��Ĺ��������룬�ٽ�����װ���õ����ַ�����Ӧ�Ĺ���������
		for(byte b : str2bytes) {
			res.append(huffmanCodes.get(b));
		}
		return res;
	}
	//��ӡ����
	public void printHuffmanCode(Map<Byte,String> hashMap) {
		System.out.println("\n ============ printHuffmanCode =================");
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
	public static void main(String[] args) {
		String str = "i like like like java do like a java";
        //���ַ���������ascII
        byte[] str2byte = str.getBytes();

        HuffManTree huffmanEncode = new HuffManTree();

        //1�������շ�����
        Node root = huffmanEncode.createHuffmanTree(str2byte);

        //2�����úշ�������root
        huffmanEncode.setRoot(root);

        //ǰ������շ�����
        huffmanEncode.preOrderTravesal();

        //3�����ÿ���ַ���Ӧ�ĺշ�������
        Map<Byte,String> getHuffmanCode = huffmanEncode.getCode(root);
        huffmanEncode.printHuffmanCode(getHuffmanCode);

        //4����ȡ�ַ����ĺշ������룺ֻ��Ҫ������Ҫת�����ַ�������
        StringBuilder res = huffmanEncode.getStringHuffmanCode(str);
        System.out.println(res);
    }

}

