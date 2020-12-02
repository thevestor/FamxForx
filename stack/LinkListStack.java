package stack;

import java.util.LinkedList;

public class LinkListStack<E>{
	//֧��list
	private LinkedList<E> stack;
	//���캯��
	public LinkListStack() {
		stack = new LinkedList<E>();
	}
	//�Ƿ�Ϊ��
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	//ѹջ
	public void push(E data) {
		stack.addFirst(data);
	}
	//��ջ
	public E pop() throws Exception{
		if(stack.isEmpty()) {
			throw new Exception("ջ����");
		}
		return stack.pop();
	}

	@Override
	public String toString() {
		return stack.toString();
	}
	
	public static void main(String[] args) throws Exception {
		LinkListStack <String> stack = new LinkListStack<String>();
		stack.push("{");
		stack.push("}");
		
		stack.pop();
		System.out.println(stack);

	}

}
