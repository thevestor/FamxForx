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
	int getSize();//��ȡ���еĳ���
	boolean isEmpty();//�ж϶����Ƿ�Ϊ��
	void enqueue(E e);//���
	E dequeue();//����
	E getFront();//��ȡ���׵�Ԫ��
	
}
