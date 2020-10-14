package stack;

import java.util.Scanner;
import java.util.Stack;

public class SqStack {
	
	Stack<String> stack = new Stack<String>();
	//num ��Ҫת�������֣�rank ��Ҫת���Ľ���
	public int getResult(int num,int rank) {
		return num / rank;//��ȡ������
	}
	public int getRemain(int num,int rank) {
		return num%rank;//��ȡ����
	}
	public void run(int num,int rank) {
		int result = getResult(num,rank);
		//�������ǽ�������ӵ�ջ�У��Ƴ��ݹ����
		if(result == 0) {
			stack.push(getRemain(num,rank) + " ");
		}else {
			stack.push(getRemain(num,rank) + " ");
			run(result,rank);//���еݹ�
		}
	}
	//����ƥ��
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
		System.out.println("������һ��ʮ��������");
		@SuppressWarnings("resource")
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		System.out.println("��������Ҫת�������Ƶ�����");
		int rank = sca.nextInt();
		sq.run(num,rank);
		String Result = "";
		while(!sq.stack.isEmpty()) {
			Result += sq.stack.pop();
		}
		System.out.println(Result);
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ҫ���Ե���������:");
		while(in.hasNext()){
			String line = in.nextLine();
			boolean res = isValid(line);
			System.out.println(res);
		}
	}
}
