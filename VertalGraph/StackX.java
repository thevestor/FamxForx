package VertalGraph;

public class StackX {
	private final int SIZE=20;//×î¶à20¸ö¶¥µã
	private int[] st;
	private int top;
	public StackX(){
		st = new int[SIZE];
		top=-1;
	}
	
	public void push(int j){
		st[++top]=j;
	}
	
	public int peek(){
		return st[top];
	}
	
	public int pop(){
		return st[top--];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
}
