package queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Package queue
 * @date 2020
 */
public class DequeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Deque<String> deque = new LinkedList<String>();
        deque.add("d");
        deque.add("e");
        deque.add("f");
        
        //�Ӷ���ȡ��Ԫ�أ�����ɾ��
        System.out.println("����ȡ��Ԫ��:"+deque.peek());
        System.out.println("����Ϊ:"+deque);
        
        //�Ӷ��׼���Ԫ��(��������������ʱ�ã�������addFirst)
        deque.offerFirst("c");
        System.out.println("���׼���Ԫ�غ�Ϊ��"+deque);
        //�Ӷ�β����Ԫ��(��������������ʱ�ã�������addLast)
        deque.offerLast("g");
        System.out.println("��β����Ԫ�غ�Ϊ��"+deque);
        
        //��β����Ԫ��
        deque.offer("h");
        System.out.println("��β����Ԫ�غ�Ϊ��"+deque);
        
        //��ȡ���Ƴ����е�һ��Ԫ��,pollFirst()Ҳ�ǣ�
        //�������ڶ���Ϊ��ʱ,removeFirst���׳�NoSuchElementException�쳣�����߷���null
        deque.removeFirst();
        System.out.println("��ȡ���Ƴ����е�һ��Ԫ�غ�Ϊ:	"+deque);
        
        //��ȡ���Ƴ����е�һ��Ԫ��,�˷�����pollLast 
        //Ψһ�������ڶ���Ϊ��ʱ,removeLast���׳�NoSuchElementException�쳣�����߷���null
        deque.removeLast();
        System.out.println("��ȡ���Ƴ��������һ��Ԫ�غ�Ϊ:"+deque);
        
        //��ȡ���е�һ��Ԫ��.�˷����� peekFirst 
        //Ψһ�Ĳ�ͬ���ڣ������˫�˶���Ϊ�գ������׳�NoSuchElementException�����߷���null
        System.out.println("��ȡ���е�һ��Ԫ��Ϊ:"+deque.getFirst());
        System.out.println("��ȡ���е�һ��Ԫ�غ�Ϊ:"+deque);
        
        //��ȡ�������һ��Ԫ��.�˷����� peekLast 
        //Ψһ�Ĳ�ͬ���ڣ������˫�˶���Ϊ�գ������׳�NoSuchElementException�����߷���null
        System.out.println("��ȡ�������һ��Ԫ��Ϊ:"+deque.getLast());
        System.out.println("��ȡ���е�һ��Ԫ�غ�Ϊ:"+deque);
        
        //ѭ����ȡԪ�ز��ڶ����Ƴ�Ԫ��
        while(deque.size()>0){
            System.out.println("��ȡԪ��Ϊ��"+ deque.pop()+" ��ɾ��");
        }
        System.out.println("����Ϊ:"+deque);
    }

}
