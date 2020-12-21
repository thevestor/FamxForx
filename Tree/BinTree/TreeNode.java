package BinTree;

public class TreeNode<E> {
	private E data;  //������
	private TreeNode<E> lchild;  //����
	private TreeNode<E> rchild;  //�Һ���

	TreeNode(E e){
		this.data = e;
	}

	TreeNode(E data,TreeNode<E> lchild, TreeNode<E> rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public void setData(E data){
		this.data = data;
	}

	public E getData(){
		return this.data;
	}

	public void setLchild(TreeNode<E> lchild){
		this.lchild = lchild;
	}

	public TreeNode<E> getLchild(){
		return this.lchild;
	}

	public void setRchild(TreeNode<E> rchild){
		this.rchild = rchild;
	}

	public TreeNode<E> getRchild(){
		return this.rchild;
	}
}
