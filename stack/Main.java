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
	private Object[] stack;// ֧������
	private int top; // ����ջ��
	private int base; //����ջ��
	private int maxSize;
	
	/**
	 * @brief ָ��ջ�����Ĺ��캯��
	 * @return 
	 * 
	 */
	public Main(){
		this(3);
	}
	/**
	 * @brief ����ָ�������Ĺ��캯��
	 * @param maxSize
	 * 
	 */
	

	public Main(int maxSize) {
		this.stack = new Object[maxSize];
		this.top = -1;
		this.maxSize = maxSize;
	}
	/**
	 * @brief �ж�ջ�Ƿ�Ϊ��
	 * @return topValue
	 * 
	 */

	public boolean isEmpty(){
		return top == -1;
	}
	/**
	 * @brief ���Ԫ��
	 * @author Dername
	 * @param e
	 * @throws Exception
	 */
	public void push(E e) throws Exception{
		if (top == maxSize - 1){
			throw new Exception("ջ����");
		}
		stack[++top] = e;
	}
	/**
	 * @brief ��ջ
	 * @author Dername
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public E pop() throws Exception{
		if(top == -1){
			throw new Exception("ջΪ��");
		}
		E element = (E)stack[top];
		stack[top - 1] = null; //ɾ����Ԫ��
		return element;
	}
	/**
	 * @brief ��ӡջ
	 * @author Dername
	 * @return 
	 * 
	 */
	public String toString(){
		return Arrays.toString(stack);
	}
	/**
	 * @brief  ����ƥ��
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
	 * @brief  ������
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
		System.out.println("��������Ҫ���Ե���������:");
		while(in.hasNext()){
			String line = in.nextLine();
			boolean res = isValid(line);
			System.out.println(res);
		}
	}
}
