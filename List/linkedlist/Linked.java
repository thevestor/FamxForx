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
 * Title: �Զ���ջ�Ľṹ���Լ�������ʵ�ֳ���ջ
 * author: Deemo
 * version: 2020
 */
public class Linked {
	Node head=null;
    public Linked() {
        head=new Node();
    }
     /**
      * @brief  ��ջ
      * @author Dername
      * @param  obj
      * @return void
      */
    public void push(Object obj) {
        Node node=new Node(obj);
        //��node��head����
        node.setNext(head.getNext());
        //��node���head��λ��
        head.setNext(node);
    }
    /**
     * @brief �ж�ջ���Ƿ�Ϊ��
     * @param null
     * @return
     */
    public boolean isEmpty() {
        return (head.getNext()==null);
    }
    /**
     * @brief ��ջ
     * @author Dername
     * @param null
     * @return ջΪ��
     */
    public Object pop() {
        Object item=null;
        if(isEmpty()) {
            System.out.println("��ջΪ��");
            //return item;
        }
         item=head.getNext().getData();
        head.setNext(head.getNext().getNext());
        return item;
    }
    /**
     * @brief  ����ջ�Ĵ�С
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
     * @brief  ��ȡջ��Ԫ��
     * @author Dername
     * @param  null
     * @return ���ҵ�Ԫ��
     */
    public Object peak() {
        Object item=null;
        if(isEmpty()) {
            System.out.println("��ջΪ��");
            return item;
        }
        item=head.getNext().getData();
        return item;
    }

    
    /**
     * @brief ������
     * @author Dername
     * @param args
     * @return syso
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Linked link=new Linked();
        link.push("��һ��");
        link.push("�ڶ���");
        link.push("������");
        link.push("���ĸ�");
        System.out.println(link.isEmpty());
        System.out.println(link.pop());
        System.out.println(link.peak());
        System.out.println(link.size());

    }
}

