package tree;


public class Node{
	public int iData; // ������ݱ����ڱ�ʾ��ֵ
 	public double dData; // ��������
 	public Node leftChild; // ���node������ʾ�������� 
 	public Node rightChild; // ���node������ʾ�����Һ���
 	public void displayNode(){
 		//������ʾ�ڵ������
 		System.out.println("{");
 		System.out.println(iData);
 		System.out.println(",");
 		System.out.println("dData");
 		System.out.println("}");
 	}
}
 

//public class Node {
// 		person p1; // �ο�person����
// 		Node leftChild; //���node������ʾ��������
// 		Node rightChild; // ���node������ʾ�����Һ���
//}
//class person{
// 		int iData;
// 		double dData;
//}

