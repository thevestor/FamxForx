/*********************************************************************************************************
*  Copyright (c) 2020 FamxForx. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <s1074862962@gmail.com> or <s1074862962@163.com>                                                 
*                                                                                                        
*  FileName:  ForEachQueue                                                                         
*  Author:  FamxForx                                                                                     
*  Version:  2.2                                                                                         
*  Date:  2020                                                                                     
*  Title: ѭ������                                                              
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package queue;

/**
 * Title: ѭ������
 * @author FamxForx
 * @create 2020
 */
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @brief ��������ѭ������
 * @author Deemo
 * @create 2020
 * @param <E>
 */
public class ForEachQueue<E> implements QueueNode<E> {
	
	private E[] data;
    private int front, tail;
    private int size;
    
    /**
     * @brief ָ����������ʼ�����д�С������ѭ��������Ҫ�˷�һ���ռ䣬�������ǳ�ʼ�����е�ʱ��Ҫ���û������������1��
     * @author FamxForx
     * @param capacity
     */
    @SuppressWarnings("unchecked")
	public ForEachQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    /**
     * @brief ģʽ��������ʼ�����д�С
     * @author FamxForx
     */
    public ForEachQueue(){
        this(10);
    }
    /**
     * @brief return sumElement length
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }
    /**
     * @brief Estimate queue is empty
     * @author FamxForx
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }
    /**
     * @brief return queue`s length
     * @author FamxForx
     */
    @Override
    public int getSize(){
        return size;
    }
    /**
     * @brief ��ӣ��������ˣ����������� 
     * @author FamxForx
     */
    @Override
    public void enqueue(E e){
    	// ������Ϊ��
        //�������� ��������
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }
    /**
     * @brief ���ӣ������е����ݵ�ֵ�ܱ�������������
     * @author FamxForx
     * @return 
     */
    @Override
    public E dequeue(){

        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        //����Ԫ��
        E ret = data[front];
        //Ԫ�س��Ӻ󣬽��ռ���Ϊnull
        data[front] = null;
        //ά��front������λ�ã�ѭ�����У�
        front = (front + 1) % data.length;
        //ά��size��С
        size --;
        //Ԫ�س��Ӻ󣬿���ָ����������������
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }
    
    /**
     * @brief �ж϶����Ƿ�Ϊ�գ����򷵻ض�ͷ��ֵ
     * @author FamxForx
     * @return 
     */
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }
    //���п���ʱ���������ݣ�Ԫ�س��Ӳ�����ָ���������Խ�������
    private void resize(int newCapacity){

        @SuppressWarnings("unchecked")
     // ����ļ�1������Ϊѭ������������ʵ��ʹ�õĹ�����Ҫ�˷�һ���ռ�
		E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0 ; i < size ; i ++)
        	// ע�������д������Ϊ�������У�front ���ܲ���������Ϊ0��λ�ã������i��һ��ƫ����
            newData[i] = data[(i + front) 	% data.length];
     // ���µ��������ø���ԭ�����ָ��
        data = newData;
     // ��ֵfront��λ�ã�front����ָ������е�һ��Ԫ�أ�
        front = 0;
     // size �Ĵ�С���䣬��Ϊ��������У�û��Ԫ����Ӻͳ���
        tail = size;
    }

    @Override
    public String toString(){
    	//�������󲢻��ն���
        StringBuilder res = new StringBuilder();
        //���������������ʽ���д�ӡ���
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        //����ÿһ����ӵ�ֵ
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * @brief �����ࣨ��ʽ���У�
     * @author FamxForx
     * @param args
     */
    public static void main(String[] args){
    	//�����Զ������
        ForEachQueue<Integer> queue = new ForEachQueue<Integer>(5);
        //��Ϊģʽ����Ϊ10����������
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }        
        //���ȶ�����Ȼ����֮util
        Queue<Integer> naturePriorityQueue = new PriorityQueue<>(10);
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 100 + 1);
            System.out.println("add i value = " + random);
            naturePriorityQueue.add(random);
            //������Ϊ�գ����׳�NullPointException�쳣���� 
            Integer peek = naturePriorityQueue.peek();
            System.out.println("poll i value = " + peek);
            System.out.println();
            
            
        }
    }

}
