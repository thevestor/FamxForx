package queue;

/**
 * Title �����
 * @Description ���Ա��ʵ��  
 * @author Deemo
 *
 * @param <T>
 */
public class Node<T> {
	//���ɼ���
	Node<T> next;
	T data;
	/**
	 * Title ���캯��
	 * @Description ����һ���½��
	 * @author FamxForx
	 * @param data
	 * 			��Ԫ������
	 * @param next
	 * 			��Ԫ��������Ľ��
	 * @create 2020
	 */
	public Node (T data){
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return data.toString();
	}
}
