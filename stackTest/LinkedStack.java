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
	
	
	private Node<T> top;//栈顶结点，实现栈接口
	
	/**
	 * @brief 构造空栈，创建空结点
	 * @author Dername
	 * 
	 */
	public LinkedStack() {
		this.top = null;
	}
	

	/**
	 * @brief 判断栈是否为空，若空则返回true 
	 * @author Dername
	 * @return bool
	 */
	
	@Override
	public boolean isEmpty() {
		return this.top == null;
	}
	
	/**
	 * @brief 元素x入栈，空对象不能入栈 
	 * @author Dername
	 * @return void
	 */
	
	@Override
	public void push(T x) {
		if(x !=null) {
			this.top = new Node<T>(x,this.top);//头插入，x结点作为新的栈顶
			
		}
	}
	
	/**
	 * @brief 出栈，返回栈顶元素，若栈空返回null
	 * @param null
	 * @return temp
	 */
	
	@Override
	public T pop() {
		if(this.top == null)
			return null;
		T temp = this.top.data;//取栈顶结点
		this.top = this.top.next;//删除栈顶元素
		return temp;
	}
	
	/**
	 * @brief 取栈顶元素，未出栈，若栈空返回null
	 * @author Dername
	 * @return 
	 */
	@Override
	public T get() {
		return this.top == null ? null:this.top.data;
	}
	/**
	 * @brief 测试类
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
 * @brief 结点类
 * @author Dername
 * @param <T>
 */
class Node<T>{
	
	//定义指针 data,next
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