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
package test;

public class LinkedStack<T> implements SStack<T>{
	
	
	private Node<T> top;//ջ����㣬ʵ��ջ�ӿ�
	
	/**
	 * @brief �����ջ�������ս��
	 * @author Dername
	 * 
	 */
	public LinkedStack() {
		this.top = null;
	}
	

	/**
	 * @brief �ж�ջ�Ƿ�Ϊ�գ������򷵻�true 
	 * @author Dername
	 * @return bool
	 */
	
	@Override
	public boolean isEmpty() {
		return this.top == null;
	}
	
	/**
	 * @brief Ԫ��x��ջ���ն�������ջ 
	 * @author Dername
	 * @return void
	 */
	
	@Override
	public void push(T x) {
		if(x !=null) {
			this.top = new Node<T>(x,this.top);//ͷ���룬x�����Ϊ�µ�ջ��
			
		}
	}
	
	/**
	 * @brief ��ջ������ջ��Ԫ�أ���ջ�շ���null
	 * @param null
	 * @return temp
	 */
	
	@Override
	public T pop() {
		if(this.top == null)
			return null;
		T temp = this.top.data;//ȡջ�����
		this.top = this.top.next;//ɾ��ջ��Ԫ��
		return temp;
	}
	
	/**
	 * @brief ȡջ��Ԫ�أ�δ��ջ����ջ�շ���null
	 * @author Dername
	 * @return 
	 */
	@Override
	public T get() {
		return this.top == null ? null:this.top.data;
	}
	/**
	 * @brief ������
	 * @author Dername
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("{");
		stack.push("[");
		stack.push("]");
		stack.push("{");
		System.out.println(stack.get());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}
	
}
/**
 * @brief �����
 * @author Dername
 * @param <T>
 */
class Node<T>{
	
	//����ָ�� data,next
	public T data;
	public Node<T> next;
	
	public Node(T data,Node<T> next) {
		this.data = data;
		this.next = next;
		
	}
	
	public Node() {
		this(null,null);
	}
}