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
package linkedlist;

/**
 * Title: 自定义栈的结构，以及容量，实现出入栈
 * author: Deemo
 * version: 2020
 */
public class Linked {
	Node head=null;
    public Linked() {
        head=new Node();
    }
     /**
      * @brief  入栈
      * @author Dername
      * @param  obj
      * @return void
      */
    public void push(Object obj) {
        Node node=new Node(obj);
        //把node和head连接
        node.setNext(head.getNext());
        //把node变成head的位置
        head.setNext(node);
    }
    /**
     * @brief 判断栈内是否为空
     * @param null
     * @return
     */
    public boolean isEmpty() {
        return (head.getNext()==null);
    }
    /**
     * @brief 出栈
     * @author Dername
     * @param null
     * @return 栈为空
     */
    public Object pop() {
        Object item=null;
        if(isEmpty()) {
            System.out.println("该栈为空");
            //return item;
        }
         item=head.getNext().getData();
        head.setNext(head.getNext().getNext());
        return item;
    }
    /**
     * @brief  出入栈的大小
     * @author Dername 
     * @param  null
     * @return length
     */
    public int size() {
        int len = 0;
        Node pNode = head;
        while (pNode.getNext() != null) {
            len++;
            pNode = pNode.getNext();

        }
        return len;
    }
    /**
     * @brief  读取栈的元素
     * @author Dername
     * @param  null
     * @return 查找的元素
     */
    public Object peak() {
        Object item=null;
        if(isEmpty()) {
            System.out.println("该栈为空");
            return item;
        }
        item=head.getNext().getData();
        return item;
    }

    
    /**
     * @brief 测试类
     * @author Dername
     * @param args
     * @return syso
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Linked link=new Linked();
        link.push("第一个");
        link.push("第二个");
        link.push("第三个");
        link.push("第四个");
        System.out.println(link.isEmpty());
        System.out.println(link.pop());
        System.out.println(link.peak());
        System.out.println(link.size());

    }
}

