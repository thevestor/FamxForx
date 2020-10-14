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

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main<E> {
	private Object[] stack;// 支撑数组
	private int top; // 定义栈顶
	private int base; //定义栈底
	private int maxSize;
	
	/**
	 * @brief 指定栈容量的构造函数
	 * @return 
	 * 
	 */
	public Main(){
		this(3);
	}
	/**
	 * @brief 可以指定容器的构造函数
	 * @param maxSize
	 * 
	 */
	

	public Main(int maxSize) {
		this.stack = new Object[maxSize];
		this.top = -1;
		this.maxSize = maxSize;
	}
	/**
	 * @brief 判断栈是否为空
	 * @return topValue
	 * 
	 */

	public boolean isEmpty(){
		return top == -1;
	}
	/**
	 * @brief 添加元素
	 * @author Dername
	 * @param e
	 * @throws Exception
	 */
	public void push(E e) throws Exception{
		if (top == maxSize - 1){
			throw new Exception("栈已满");
		}
		stack[++top] = e;
	}
	/**
	 * @brief 出栈
	 * @author Dername
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public E pop() throws Exception{
		if(top == -1){
			throw new Exception("栈为空");
		}
		E element = (E)stack[top];
		stack[top - 1] = null; //删除该元素
		return element;
	}
	/**
	 * @brief 打印栈
	 * @author Dername
	 * @return 
	 * 
	 */
	public String toString(){
		return Arrays.toString(stack);
	}
	/**
	 * @brief  括号匹配
	 * @author Dername
	 * @param  s
	 * @return
	 */
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(c == '('){
				stack.push(')');
			}
			else if (c == '{'){
				stack.push('}');
			}
			else if (c == '['){
				stack.push(']');
			}
			else if(stack.isEmpty() || stack.pop() != c){
				return false;
			}
		}
		return stack.isEmpty();
	}
	/**
	 * @brief  测试类
	 * @author Dername
	 * @param  args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception{
		Main<String> stack = new Main<String>();
		stack.push("name");
		stack.push("sist");
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		@SuppressWarnings("resource")
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入想要测试的括号类型:");
		while(in.hasNext()){
			String line = in.nextLine();
			boolean res = isValid(line);
			System.out.println(res);
		}
	}
}
