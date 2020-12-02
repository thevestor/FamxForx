package stack;

import java.util.LinkedList;

public class LinkListStack<E>{
	//支撑list
	private LinkedList<E> stack;
	//构造函数
	public LinkListStack() {
		stack = new LinkedList<E>();
	}
	//是否为空
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	//压栈
	public void push(E data) {
		stack.addFirst(data);
	}
	//出栈
	public E pop() throws Exception{
		if(stack.isEmpty()) {
			throw new Exception("栈已满");
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
