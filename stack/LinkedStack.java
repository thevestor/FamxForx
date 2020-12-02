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
 * Title: 增强自定义链式栈 [通过维护一个栈来保证用O(1)的时间复杂度求栈中的最小元素 (空间换取时间)]
 * Description: 使用额外的栈结构存储栈中的最小元素
 * 				如果当前入栈的元素比原来栈中的最小值还小，则将其保存到最小值栈中；否则，不做任何操作。
 *              如果当前出栈的元素正好是当前栈中的最小值，那么将最小值栈中的该最小值也一并弹出；否则，不做任何操作。
 * @author FamxForx
 * @created 2020
 */
public class LinkedStack<E> {
	
	private Node<E> top; // 栈顶元素
	private int size; // 链式栈的大小
	
	/**  最小值栈   (@author: FamxForx) */    
	private LinkedStack<E> min;
	
	// 构造函数
	public LinkedStack(){
	}
	  
	/**     
	 * @description 判断栈是否为空
	 * @author FamxForx       
	 * @created 2017年5月14日 上午10:54:44     
	 * @return     
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**     
	 * @description 压栈
	 * @author rico       
	 * @param data     
	 */
	public void push(E data) {
		Node<E> node = new Node<E>(data); 
		// 新加入的元素指向栈顶元素
		node.next = top;
		top = node;
		size++;
	}
	
	/**     
	 * @description 压栈操作,使用最小值栈
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
	 * @description 弹出并删除栈顶元素
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
	 * @description 弹出并删除栈顶元素,使用最小值栈
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
	 * @description 弹出栈顶元素(不执行删除操作)
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
	 * @description 获取当前栈中的最小值 
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
	 * @description 打印栈
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
	 * @description 返回栈的大小
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
	 * Title 测试类
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
			
		System.out.println("原栈(最左边元素是栈顶元素)：");
		stack.print();
		System.out.println();
			
		System.out.println("弹出栈顶元素：");
		System.out.println(stack.peek());
		System.out.println("栈中的最小值：" + stack.min());
		System.out.println();

		System.out.println("弹出并删除栈顶元素后的链表：");
		stack.pop(c);
		stack.print();
		System.out.println("栈中的最小值：" + stack.min());
		System.out.println();
	}
}
