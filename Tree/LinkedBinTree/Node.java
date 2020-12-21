package LinkedBinTree;
/**
 * Title: ����� 
 * Description: �������Ľ��
 * 
 * @author FamxForx
 * @created 2020��11��1��
 */
public class Node<T> {
	T data;   // �������
	Node<T> left;  // ָ�����ӽ��
	Node<T> right;  // ָ���Һ��ӽ��
	boolean isFirst;  // ���ڷǵݹ�������
	
	
	/**
	 * ���캯��
	 * 
	 * @description ����һ���½��
	 * @author FamxForx
	 * @created 2020��11��1��
	 * @param data
	 *            ��Ԫ������
	 * @param next
	 *            ��Ԫ���������Ͻ��
	 */
	public Node(T data) { 
		this.data = data;
	}

	@Override
	public String toString() {
		return data == null ? null : data.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Node) {
			Node<T> temp = (Node<T>) obj;
			if (data.equals(temp.data)) {
				return true;
			}
		}
		return false;
	}
}
