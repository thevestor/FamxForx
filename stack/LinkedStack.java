/*********************************************************************************************************
*  Copyright (c) 2020 FamxForx. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <s1074862962@gmail.com> or <s1074862962@163.com>                                                 
*                                                                                                        
*  FileName:  BalancedParan                                                                         
*  Author:  FamxForx                                                                                     
*  Version:  2.2                                                                                         
*  Date:  2020                                                                                     
*  Title: paranthesis are balanced                                                              
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package stack;

import java.util.Comparator;

/**
 * Title: ��ǿ�Զ�����ʽջ [ͨ��ά��һ��ջ����֤��O(1)��ʱ�临�Ӷ���ջ�е���СԪ�� (�ռ任ȡʱ��)]
 * Description: ʹ�ö����ջ�ṹ�洢ջ�е���СԪ��
 * 				�����ǰ��ջ��Ԫ�ر�ԭ��ջ�е���Сֵ��С�����䱣�浽��Сֵջ�У����򣬲����κβ�����
 *              �����ǰ��ջ��Ԫ�������ǵ�ǰջ�е���Сֵ����ô����Сֵջ�еĸ���СֵҲһ�����������򣬲����κβ�����
 * @author FamxForx
 * @created 2020
 */
public class LinkedStack<E> {
	
	private Node<E> top; // ջ��Ԫ��
	private int size; // ��ʽջ�Ĵ�С
	
	/**  ��Сֵջ   (@author: FamxForx) */    
	private LinkedStack<E> min;
	
	// ���캯��
	public LinkedStack(){
	}
	  
	/**     
	 * @description �ж�ջ�Ƿ�Ϊ��
	 * @author FamxForx       
	 * @created 2017��5��14�� ����10:54:44     
	 * @return     
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**     
	 * @description ѹջ
	 * @author rico       
	 * @param data     
	 */
	public void push(E data) {
		Node<E> node = new Node<E>(data); 
		// �¼����Ԫ��ָ��ջ��Ԫ��
		node.next = top;
		top = node;
		size++;
	}
	
	/**     
	 * @description ѹջ����,ʹ����Сֵջ
1	 * @author FamxForx       
	 * @param data     
	 */
	public void push(E data, Comparator<? super E> c) {
		push(data);
		if(min == null){
			min = new LinkedStack<E>();
		}
		if(min.peek() == null){
			min.push(data);
		}else if(c.compare(this.peek().data, min.peek().data) < 0){
			min.push(data);
		}
	}

	/**     
	 * @description ������ɾ��ջ��Ԫ��
	 * @author FamxForx       
	 * @return
	 * @throws Exception     
	 */
	public Node<E> pop(){
		if (isEmpty()) {
			return null;
		}

		Node<E> node = top;
		top = top.next;
		node.next = null;
		size--;
		return node;
	}
	
	/**     
	 * @description ������ɾ��ջ��Ԫ��,ʹ����Сֵջ
	 * @author FamxForx       
	 * @return
	 * @throws Exception     
	 */
	public Node<E> pop(Comparator<? super E> c){
		Node<E> temp = this.pop();
		if(temp != null && min.peek() != null){
			if(c.compare(temp.data, min.peek().data) == 0){
				min.pop();
			}
		}
		return temp;
	}
	
	/**     
	 * @description ����ջ��Ԫ��(��ִ��ɾ������)
	 * @author FamxForx       
	 * @return     
	 */
	public Node<E> peek(){
		if (isEmpty()) {
			return null;
		}
		return top;
	}

	/**     
	 * @description ��ȡ��ǰջ�е���Сֵ 
	 * @author FamxForx       
	 * @return     
	 */
	public Node<E> min() {
		if(min.peek() == null){
			return null;
		}else{
			return min.peek();
		}
	}
	
	/**     
	 * @description ��ӡջ
	 * @author FamxForx       
	 */
	public void print() {
		Node<E> index = top;
		while (index != null) {
			System.out.print(index.data + " ");
			index = index.next;
		}
		System.out.println();
	}
	  
	
	
	/**     
	 * @description ����ջ�Ĵ�С
	 * @author FamxForx       
	 * @return     
	 */
	public int size(){
		return size;
	}

	public LinkedStack<E> getMin() {
		return min;
	}

	public void setMin(LinkedStack<E> min) {
		this.min = min;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Node<E> index = top;
		StringBuilder sb = new StringBuilder();
		while (index != null) {
			sb.append(index.data).append(" ");
			index = index.next;
		}
		return sb.toString();
	}
	
	/**
	 * Title ������
	 * @author FamxForx
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
			
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2)
					return 1;
				else if(o1 < o2)
					return -1;
				else
					return 0;
			}
		};
			
		stack.push(7,c);
		stack.push(6,c);
		stack.push(8,c);
		stack.push(5,c);
		stack.push(3,c);
			
		System.out.println("ԭջ(�����Ԫ����ջ��Ԫ��)��");
		stack.print();
		System.out.println();
			
		System.out.println("����ջ��Ԫ�أ�");
		System.out.println(stack.peek());
		System.out.println("ջ�е���Сֵ��" + stack.min());
		System.out.println();

		System.out.println("������ɾ��ջ��Ԫ�غ������");
		stack.pop(c);
		stack.print();
		System.out.println("ջ�е���Сֵ��" + stack.min());
		System.out.println();
	}
}
