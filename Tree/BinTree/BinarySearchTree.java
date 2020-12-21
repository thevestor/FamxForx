package BinTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * �������������������������ʵ��
 */
public class BinarySearchTree {
	private TreeNode<Integer> root;  //���ڵ�

	public BinarySearchTree(){
		root = null;
	}

	//��һ������ȥ�������������
	public TreeNode<Integer> buildBST(Integer[] array){
		if(array.length == 0){
			return null;
		}else{
			root = null;  //��ʼ����Ϊ����
			for(int i=0; i<array.length; i++){ //���ν�ÿ��Ԫ�ز���
				root = insertNode(root,array[i]);
			}
			return root;
		}
	}

	//�ڶ���������в���һ��������Ϊdata�Ľ�㣬�²���Ľ��һ����ĳ��Ҷ�ӽڵ�
	public TreeNode<Integer> insertNode(TreeNode<Integer> node, Integer data){
		if(node == null){  //ԭ��Ϊ�գ��²���ļ�¼Ϊ���ڵ�
			node = new TreeNode<Integer>(data,null,null);
		}else{
			if(node.getData() == data){  //���д�����ͬ�ؼ��ֵĽ��,ʲôҲ����

			}else{
				if(node.getData() > data){  //���ڵ�>�������ݣ����뵽��������
					node.setLchild(insertNode(node.getLchild(),data));
				}else{ //���ڵ�<�������ݣ����뵽��������
					node.setRchild(insertNode(node.getRchild(),data));
				}
			}
		}
		return node;
	}

	//�����������ǰ����������Եõ�һ����������������
	public void preOrder(TreeNode<Integer> node){
		if(node != null){
			System.out.print(node.getData() + " ");
			preOrder(node.getLchild());
			preOrder(node.getRchild());
		}
	}

	//�����������������������Եõ�һ����������������
	public void inOrder(TreeNode<Integer> node){
		if(node != null){
			inOrder(node.getLchild());
			System.out.print(node.getData()+" ");
			inOrder(node.getRchild());
		}
	}
	//����������ĺ�����������Եõ�һ���ݼ�����������
	public void postOrder(TreeNode<Integer> node)
	{
		if(node != null)
		{
			postOrder(node.getLchild());
			postOrder(node.getRchild());
			System.out.print(node.getData() + " ");
		}
	}

	//����������Ĳ�α���
	public void levelOrder(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> nodeQueue = new LinkedList<TreeNode<Integer>>();
		TreeNode<Integer> node = null;
		nodeQueue.add(root);  //�����ڵ����
		while(!nodeQueue.isEmpty()){  //���в���ѭ��
			node = nodeQueue.peek();
			System.out.print(node.getData()+" ");
			nodeQueue.poll();    //��ͷԪ�س���
			if(node.getLchild() != null){    //���������գ��������������
				nodeQueue.add(node.getLchild());
			}
			if(node.getRchild() != null){    //���������գ��������������
				nodeQueue.add(node.getRchild());
			}
		}
	}

	//����������Ϊdata�Ľ�㣬�������ڣ�����null
	public TreeNode<Integer> searchNode(TreeNode<Integer> node, Integer data){
		while(node != null && node.getData() != data){
			if(node.getData() > data){
				node = node.getLchild();  //���ڵ�>���ݣ�������
			}else{
				node = node.getRchild();  //���ڵ�<���ݣ�������
			}
		}
		return node;
	}

	//�������ֵ�����ϵ�Ѱ�����ӽڵ�
	public TreeNode<Integer> getMaxData(TreeNode<Integer> node){
		if(node.getRchild() == null){
			return node;
		}else{
			return getMaxData(node.getRchild());
		}
	}

	//������Сֵ�����ϵ�Ѱ�����ӽڵ�
	public TreeNode<Integer> getMinData(TreeNode<Integer> node){
		if(node.getLchild() == null){
			return node;
		}else{
			return getMinData(node.getLchild());
		}
	}

	//�õ�������Ϊdata�Ľ���ֱ�Ӹ��ڵ�parentNode
	public TreeNode<Integer> getParentNode(TreeNode<Integer> root, Integer data){
		TreeNode<Integer> parentNode = root;
		if(parentNode.getData() == data){  //���ڵ�ĸ��ڵ㷵��Ϊnull
			return null;
		}
		while(parentNode != null){
			//���ҵ�ǰ�ڵ�ĸ��ڵ�������ӽڵ㣬������ȣ��򷵻ظø��ڵ�
			if((parentNode.getLchild() != null && parentNode.getLchild().getData() == data) ||
					(parentNode.getRchild() != null && parentNode.getRchild().getData() == data)){
				return parentNode;
			}else{
				if(parentNode.getData() > data){ //������Ҹ��ڵ�
					parentNode = parentNode.getLchild();
				}else{
					parentNode = parentNode.getRchild();  //���Ҳ��Ҹ��ڵ�
				}
			}
		}
		return null;
	}

	/**
	 * �õ����node��ֱ��ǰ��
	 * a.�ýڵ���������Ϊ�գ���ǰ���ڵ�Ϊ�������������Ԫ��
	 * b.�ýڵ�������Ϊ��: ��ǰ���ڵ�Ϊ�����Ƚڵ�(�ݹ�)���Ҹ����Ƚڵ���Һ���ҲΪ�����Ƚڵ�
	 *  (����һֱ����parent�ң�������պ���Ǹ����Ƚڵ�)
	 */
	public TreeNode<Integer> getPrecessor(TreeNode<Integer> root,TreeNode<Integer> node){
		if(node == null){
			return null;
		}
		//a.�ýڵ���������Ϊ�գ���ǰ���ڵ�Ϊ�������������Ԫ��
		if(node.getLchild() != null){
			return getMaxData(node.getLchild());
		}else{  //b.�ýڵ�������Ϊ��: ��ǰ���ڵ�Ϊ�����Ƚڵ�(�ݹ�)
			TreeNode<Integer> parentNode = getParentNode(root, node.getData());
			while(parentNode != null && node == parentNode.getLchild()){
				node = parentNode;
				parentNode = getParentNode(root, parentNode.getData());
			}
			return parentNode;
		}
	}

	/**
	 * �õ����node��ֱ�Ӻ��(��̽ڵ���Ǳ�Ҫɾ���Ľڵ�Ĺؼ�ֵҪ��Ľڵ㼯���е���Сֵ)
	 * a.�ýڵ���������Ϊ�գ����̽ڵ�Ϊ������������СԪ��
	 * b.�ýڵ�������Ϊ�գ������̽ڵ�Ϊ�����Ƚڵ�(�ݹ�)���Ҵ����Ƚڵ������Ҳ�Ǹýڵ�����Ƚڵ㣬
	 *  ����˵??ֱ�����������Ƚڵ㣬ֱ�������ҹպ���Ǹ����Ƚڵ㣺
	 */
	public TreeNode<Integer> getSuccessor(TreeNode<Integer> root,TreeNode<Integer> node){
		if(node == null){
			return null;
		}
		//a.�ýڵ���������Ϊ�գ����̽ڵ�Ϊ������������СԪ��
		if(node.getRchild() != null){
			return getMinData(node.getRchild());
		}else{  //b.�ýڵ�������Ϊ�գ������̽ڵ�Ϊ��������Ƚڵ�(�ݹ�)
			TreeNode<Integer> parentNode = getParentNode(root, node.getData());
			while(parentNode != null && node == parentNode.getRchild()){
				node = parentNode;
				parentNode = getParentNode(root, parentNode.getData());
			}
			return parentNode;
		}
	}

	/**
	 * ɾ��������Ϊdata�Ľ��
	 * �������������
	 * a.�����ɾ�����z��Ҷ�ӽڵ㣬��ֱ��ɾ���������ƻ����������������
	 * b.����ڵ�zֻ��һ����������������������z��������Ϊz���ڵ������������z��λ��
	 * c.�����z��������������������z��ֱ�Ӻ�̣���ֱ��ǰ�������z��
	 *  Ȼ��Ӷ����������ɾȥ���ֱ�Ӻ�̣���ֱ��ǰ����,������ת��Ϊ��һ��ڶ������
	 * @param node ����������ĸ��ڵ�
	 * @param data ��Ҫɾ���Ľ���������
	 * @return
	 */
	public boolean deleteNode(TreeNode<Integer> node, Integer data){
		if(node == null){ //��Ϊ��
			throw new RuntimeException("��Ϊ�գ�");
		}
		TreeNode<Integer> delNode= searchNode(node, data);  //������Ҫɾ���Ľ��
		TreeNode<Integer> parent = null;
		if(delNode == null){  //������в�����Ҫɾ���Ĺؼ���
			throw new RuntimeException("���в�����Ҫɾ���Ĺؼ��֣�");
		}else{
			parent = getParentNode(node,data);  //�õ�ɾ���ڵ��ֱ�Ӹ��ڵ�
			//a.�����ɾ�����z��Ҷ�ӽڵ㣬��ֱ��ɾ���������ƻ����������������
			if(delNode.getLchild()==null && delNode.getRchild()==null){
				if(delNode==parent.getLchild()){  //��ɾ���ڵ�Ϊ�丸�ڵ������
					parent.setLchild(null);
				}else{    //��ɾ���ڵ�Ϊ�丸�ڵ���Һ���
					parent.setRchild(null);
				}
				return true;
			}
			//b1.����ڵ�zֻ��һ��������������z��������Ϊz���ڵ������������z��λ��
			if(delNode.getLchild()!=null && delNode.getRchild()==null){
				if(delNode==parent.getLchild()){ //��ɾ���ڵ�Ϊ�丸�ڵ������
					parent.setLchild(delNode.getLchild());
				}else{ //��ɾ���ڵ�Ϊ�丸�ڵ���Һ���
					parent.setRchild(delNode.getLchild());
				}
				delNode.setLchild(null); //���ñ�ɾ����������Ϊnull
				return true;
			}
			//b2.����ڵ�zֻ��һ��������������z��������Ϊz���ڵ������������z��λ��
			if(delNode.getLchild()==null && delNode.getRchild()!=null){
				if(delNode==parent.getLchild()){ //��ɾ���ڵ�Ϊ�丸�ڵ������
					parent.setLchild(delNode.getRchild());
				}else{  //��ɾ���ڵ�Ϊ�丸�ڵ���Һ���
					parent.setRchild(delNode.getRchild());
				}
				delNode.setRchild(null); //���ñ�ɾ�������Һ���Ϊnull
				return true;
			}
			//c.�����z������������������ɾ���ý��ĺ�̽�㣬���øú�̽��ȡ���ý��
			if(delNode.getLchild()!=null && delNode.getRchild()!=null){
				TreeNode<Integer> successorNode = getSuccessor(node,delNode); //�õ���ɾ�����ĺ�̽ڵ�
				deleteNode(node,successorNode.getData()); //ɾ���ý��ĺ�̽��
				delNode.setData(successorNode.getData()); //�øú�̽��ȡ���ý��
				return true;
			}
		}
		return false;
	}


	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		Integer[] array = {8,3,10,1,6,14,4,7,13};
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode<Integer> root = bst.buildBST(array);
		System.out.print("��α���:");
		bst.levelOrder(root);
		System.out.println();
		System.out.print("\n" + "ǰ�����:");
		bst.preOrder(root);
		System.out.print("\n"+"�������:");
		bst.inOrder(root);
		System.out.print("\n" + "�������:");
		bst.postOrder(root);
		System.out.println();
		System.out.print("������ֵ:");
		System.out.println(bst.root.getData());
		System.out.print("�õ����ӽڵ�Ϊ:");
		System.out.println(bst.getMaxData(root).getData());
		System.out.print("�õ����ӽڵ�Ϊ:");
		System.out.println(bst.getMinData(root).getData());
		System.out.print("�����������в���һ���ڵ㣬�����������ڵ��������:");
		int data = input.nextInt();
		System.out.print("����ڵ�"+ data +"����������Ľ��:");
		root = bst.insertNode(root, data);
		bst.inOrder(root);
		System.out.println("\n"+"�ڶ���������в���Ԫ��,"+"��������Ҫ���ҵĽ��ֵ:");
		data = input.nextInt();
		if(bst.searchNode(root, data) == null){
			System.out.println("false");
		}else{
			System.out.println("true");
		}
		System.out.println("���ҽڵ��ֱ�Ӹ��ڵ�,"+"��������Ҫ���ҵĽ��ֵ:");
		data = input.nextInt();
		System.out.print("�ڵ�"+ data +"�ĸ��ڵ���:");
		if(bst.getParentNode(root, data) == null){
			System.out.println("null");
		}else{
			System.out.println(bst.getParentNode(root, data).getData());
		}
		System.out.println("ɾ�����,"+"��������Ҫɾ���Ľ��ֵ:");
		data = input.nextInt();
		if(bst.deleteNode(root, data)){
			System.out.print("ɾ������Ĳ�α���:");
			bst.levelOrder(root);
			System.out.print("\n"+"ɾ��������������:");
			bst.inOrder(root);
		}
	}


}