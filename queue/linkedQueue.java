/*********************************************************************************************************
*  Copyright (c) 2020 FamxForx. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <s1074862962@gmail.com> or <s1074862962@163.com>                                                 
*                                                                                                        
*  FileName:  linkedQueue                                                                         
*  Author:  FamxForx                                                                                     
*  Version:  2.2                                                                                         
*  Date:  2020                                                                                     
*  Title: Based on linklist to create Queue                                                             
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package queue;


/**
 * @Title Based on linklist to create Queue
 * @author FamxForx
 * @create 2020Äê 
 * @param <E>
 */
public class linkedQueue<E> {
	
	private Node<E> head;//Team leader pointer
	private Node<E> rear;//Rear of the team pointer
	
	
	private int size;//Queue size
	public linkedQueue() {
		head = rear = new Node<E>(null);
	}
	/**
	 * @brief  Import Element to rear
	 * @author FamxForx
	 * @param data
	 * @create 2020Äê
	 * @return void
	 */
	public void put(E data) {
		Node<E> node = new Node<E>(data);
		rear.next = node;
		rear = node;
		size++;
	}
	
	/**
	 * @brief If queue have not value,delete front and return rear Element value
	 * @author FamxForx
	 * @return
	 */
	public E pop(){
		if(!isEmpty()) {
			E e = null;
			Node<E> temp = head.next;
			head.next = temp.next;
			e = head.data;
			
			temp.next = null;
			temp.data = null;
			size --;
			return e;
		}
		return null;
	}
	
	/**
	 * @brief If queue have not value,return Team leader Element value
	 * @author FamxForx
	 * @return
	 */
	public E peek() {
		if(!isEmpty()) {
			return head.next.data;
		}
		return null;
	}
	/**
	 * @brief Estimate queue have not value
	 * @author FamxForx
	 * @return
	 */
	public boolean isEmpty() {
		return size ==  0;
	}
	/**
	 * @brief Return queue size
	 * @author FamxForx
	 * @return
	 */
	public int size() {
		return size;
	}
	public E getRear() {
		if(!isEmpty()) {
			return rear.data;
		}
		return null;
	}
	/**
	 * Title: test class
	 * @author FamxForx
	 * @return args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedQueue<Integer> queue = new linkedQueue<Integer>();
		queue.put(1);
		queue.put(2);
		queue.put(4);
		queue.put(3);
		queue.put(0);
		System.out.println(queue);
		System.out.println("\n ------------------- \n");
		
				queue.pop();
		System.out.println("delete the head value:" + queue);
		System.out.println("\n ------------------- \n");
		
		
		System.out.println("get head value is:" + queue.peek());
		queue.put(121);
		System.out.println(queue);
		System.out.println("\n -------------------- \n");
		
		System.out.println("get rear value:" + queue.getRear());
		System.out.println("\n --------------------- \n");
		

		
		
		System.out.println("queue`s length is:" + queue.size);
		System.out.println("\n ---------------------- \n");
		
		System.out.println("queue is empty?:" + queue.isEmpty());
		System.out.println("\n ------------- \n");
		
			}
	@Override
	public String toString() {
		Node<E> cur = head.next;
		StringBuilder sb = new StringBuilder();
		while(cur!=null) {
			sb.append(cur.data).append("");
			cur = cur.next;
		}
		return sb.toString();
	}
}
