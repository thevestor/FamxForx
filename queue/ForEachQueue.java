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
 * Title: 循环队列
 * @author FamxForx
 * @create 2020
 */
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @brief 利用数组循环队列
 * @author Deemo
 * @create 2020
 * @param <E>
 */
public class ForEachQueue<E> implements QueueNode<E> {
	
	private E[] data;
    private int front, tail;
    private int size;
    
    /**
     * @brief 指定容量，初始化队列大小（由于循环队列需要浪费一个空间，所以我们初始化队列的时候，要将用户传入的容量加1）
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
     * @brief 模式容量，初始化队列大小
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
     * @brief 入队，若队满了，则扩容两倍 
     * @author FamxForx
     */
    @Override
    public void enqueue(E e){
    	// 检查队列为满
        //队列满了 进行扩容
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }
    /**
     * @brief 出队，若队列的数据的值能被除尽，则缩容
     * @author FamxForx
     * @return 
     */
    @Override
    public E dequeue(){

        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        //出队元素
        E ret = data[front];
        //元素出队后，将空间置为null
        data[front] = null;
        //维护front的索引位置（循环队列）
        front = (front + 1) % data.length;
        //维护size大小
        size --;
        //元素出队后，可以指定条件，进行缩容
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }
    
    /**
     * @brief 判断队列是否为空，否则返回队头的值
     * @author FamxForx
     * @return 
     */
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }
    //队列快满时，队列扩容；元素出队操作，指定条件可以进行缩容
    private void resize(int newCapacity){

        @SuppressWarnings("unchecked")
     // 这里的加1还是因为循环队列我们在实际使用的过程中要浪费一个空间
		E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0 ; i < size ; i ++)
        	// 注意这里的写法：因为在数组中，front 可能不是在索引为0的位置，相对于i有一个偏移量
            newData[i] = data[(i + front) 	% data.length];
     // 将新的数组引用赋予原数组的指向
        data = newData;
     // 充值front的位置（front总是指向队列中第一个元素）
        front = 0;
     // size 的大小不变，因为在这过程中，没有元素入队和出队
        tail = size;
    }

    @Override
    public String toString(){
    	//创建对象并回收对象
        StringBuilder res = new StringBuilder();
        //将队列以数组的形式排列打印输出
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        //遍历每一个入队的值
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * @brief 测试类（链式队列）
     * @author FamxForx
     * @param args
     */
    public static void main(String[] args){
    	//创建自定义对象
        ForEachQueue<Integer> queue = new ForEachQueue<Integer>(5);
        //因为模式容量为10，则遍历入队
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }        
        //优先队列自然排序之util
        Queue<Integer> naturePriorityQueue = new PriorityQueue<>(10);
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 100 + 1);
            System.out.println("add i value = " + random);
            naturePriorityQueue.add(random);
            //若队列为空，则抛出NullPointException异常操作 
            Integer peek = naturePriorityQueue.peek();
            System.out.println("poll i value = " + peek);
            System.out.println();
            
            
        }
    }

}
