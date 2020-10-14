package queue;

/**
 * Title 结点类
 * @Description 线性表的实现  
 * @author Deemo
 *
 * @param <T>
 */
public class Node<T> {
	//包可见性
	Node<T> next;
	T data;
	/**
	 * Title 构造函数
	 * @Description 构造一个新结点
	 * @author FamxForx
	 * @param data
	 * 			新元素数据
	 * @param next
	 * 			新元素与链表的结点
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
