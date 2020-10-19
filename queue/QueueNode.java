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
package queue;

/**
 * @brief create queue and initQueue
 * @author FamxForx
 * @param <E>
 */
public interface QueueNode<E> {
	int getSize();//获取队列的长度
	boolean isEmpty();//判断队列是否为空
	void enqueue(E e);//入队
	E dequeue();//出队
	E getFront();//获取队首的元素
	
}
