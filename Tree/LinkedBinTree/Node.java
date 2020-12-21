package LinkedBinTree;
/**
 * Title: 结点类 
 * Description: 二叉树的结点
 * 
 * @author FamxForx
 * @created 2020年11月1日
 */
public class Node<T> {
	T data;   // 结点数据
	Node<T> left;  // 指向左孩子结点
	Node<T> right;  // 指向右孩子结点
	boolean isFirst;  // 用于非递归后序遍历
	
	
	/**
	 * 构造函数
	 * 
	 * @description 构造一个新结点
	 * @author FamxForx
	 * @created 2020年11月1日
	 * @param data
	 *            新元素数据
	 * @param next
	 *            新元素与链表结合结点
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
