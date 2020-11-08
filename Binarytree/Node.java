package tree;


public class Node{
	public int iData; // 这个数据被用于表示主值
 	public double dData; // 其他数据
 	public Node leftChild; // 这个node变量表示的是左孩子 
 	public Node rightChild; // 这个node变量表示的是右孩子
 	public void displayNode(){
 		//用于显示节点的数据
 		System.out.println("{");
 		System.out.println(iData);
 		System.out.println(",");
 		System.out.println("dData");
 		System.out.println("}");
 	}
}
 

//public class Node {
// 		person p1; // 参考person对象
// 		Node leftChild; //这个node变量表示的是左孩子
// 		Node rightChild; // 这个node变量表示的是右孩子
//}
//class person{
// 		int iData;
// 		double dData;
//}

