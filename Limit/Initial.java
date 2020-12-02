package Limit;

class Node<T>{
	
	Node<T> next;
	T data;
	public Node (T data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return data.toString();
	}
}
public class Initial<E>{
	private Node<E> front;
	private Node<E> rear;
	
	private int size;
	public Initial() {
		front = rear = new Node<E>(null);
	}
	public void push(E data){
		Node<E> node = new Node<E>(data);
		rear.next = node;
		rear = node;
		size++;
	}
	public E pop() {
		if(!isEmpty()) {
			E e = null;
			Node<E> temp = front.next;
			front.next = temp.next;
			e = front.data;
			
			temp.next = null;
			temp.data = null;
			size --;
			
			return e;
		}
		return null;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E peek() {
		if(!isEmpty()) {
			return front.next.data;
		}
		return null;
	}
	public int getSize() {
		return size;
	}
	public E ClearQueue() {
		if(!isEmpty()) {
			front = rear;
		}
		return null;
	}
	public static void main(String[] args) {
		Initial<Integer> queue = new Initial<Integer>();
		queue.push(1);
		queue.push(4);
		queue.push(3);
		queue.push(0);
		queue.push(5);
		System.out.println(queue);
		
		System.out.println("\n -------------------- \n");
		queue.pop();
		System.out.println(queue);
		
		System.out.println("\n ----------------------- \n");
		
		System.out.println(queue.peek());
		System.out.println("\n -------------------- \n");
		
		
		queue.push(8);
		System.out.println(queue);
		System.out.println("\n --------------------- \n");
	
		queue.ClearQueue();
		System.out.println(queue);
	}
	@Override
	public String toString() {
		Node<E> cur = front.next;
		StringBuilder sb = new StringBuilder();
		while(cur!=null) {
			sb.append(cur.data).append("");
			cur = cur.next;
		}
		return sb.toString();
		
	}
}