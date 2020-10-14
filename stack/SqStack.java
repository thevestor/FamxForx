package stack;

import java.util.Scanner;
import java.util.Stack;

public class SqStack {
	
	Stack<String> stack = new Stack<String>();
	//num 是要转换的数字，rank 是要转换的进制
	public int getResult(int num,int rank) {
		return num / rank;//获取整数商
	}
	public int getRemain(int num,int rank) {
		return num%rank;//获取余数
	}
	public void run(int num,int rank) {
		int result = getResult(num,rank);
		//当整数是将余数添加到栈中，推出递归过程
		if(result == 0) {
			stack.push(getRemain(num,rank) + " ");
		}else {
			stack.push(getRemain(num,rank) + " ");
			run(result,rank);//进行递归
		}
	}
	//括号匹配
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(c == '('){
				stack.push(')');
			}
			else if (c == '{'){
			    stack.push('}');
			}
			else if (c == '['){
				stack.push(']');
			}
			else if(stack.isEmpty() || stack.pop() != c){
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	
	public static void main(String[] args) {
		SqStack sq = new SqStack();
		System.out.println("请输入一个十进制数字");
		@SuppressWarnings("resource")
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		System.out.println("请输入想要转换几进制的数字");
		int rank = sca.nextInt();
		sq.run(num,rank);
		String Result = "";
		while(!sq.stack.isEmpty()) {
			Result += sq.stack.pop();
		}
		System.out.println(Result);
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入想要测试的括号类型:");
		while(in.hasNext()){
			String line = in.nextLine();
			boolean res = isValid(line);
			System.out.println(res);
		}
	}
}
