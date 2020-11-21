package stack;
/**
 * Title: ����� 
 * Description: �����Ļ���Ԫ��
 * 
 * @author FamxForx
 * @created 2020
 */
public class Node<T> {
	//���ɼ���
	Node<T>  next;
	T data;
	/**
	 * ���캯��
	 * 
	 * @description ����һ���½ڵ�
	 * @author FamxForx
	 * @created 2020
	 * @param data
	 *            ��Ԫ������
	 * @param next
	 *            ��Ԫ����������Ͻڵ�
	 */
	public Node(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	@Override
	public String toString() {
		return data.toString();
	}
	public Node<T> getNext(){
		return next;
	}
}