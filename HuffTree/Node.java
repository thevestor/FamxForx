package HuffTree;

public class Node implements Comparable<Node>{

	private Node leftNode;
	private Node rightNode;
	private int weight;
	Byte data;
	
	//Ç°Ðò±éÀú
	public void preOrderTraversal() {
		System.out.println(this);
		//×óµÝ¹é
		if(this.getLeftNode() != null)
		{
			this.leftNode.preOrderTraversal();
		}
		//ÓÒµÝ¹é
		if(this.getRightNode() != null)
		{
			this.rightNode.preOrderTraversal();
		}
	}
	public String toString() {
		return "Node{" + "weight=" + weight + ",data=" + data + "}";
	}
	public Node(int weight) {
		this.weight = weight;
	}
	public Node(Byte data,int weight) {
		this.weight = weight;
		this.data = data;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Byte getData() {
		return data;
	}
	public void setData(Byte data) {
		this.data = data;
	}

}
