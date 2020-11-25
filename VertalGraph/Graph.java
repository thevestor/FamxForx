package VertalGraph;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph {
	
	private final int MAX_VERTS=20;
	private Vertex[] vertexList;//��Ŷ��������
	private int adjMat[][];//�ڽӾ���
	private int nVerts;//��ǰ��������
	private StackX theStack;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++)
			for(int k=0; k<MAX_VERTS; k++)
				adjMat[j][k]=0;
		theStack = new StackX();
	}
	//��Ӷ���
	public void addVertex(char lab){
		vertexList[nVerts++]= new Vertex(lab);
	}
	//��ӱ�
	public void addEdge(int start, int end){
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	public void displayVertex(int v){
		System.out.print(vertexList[v].label + " ");

	}
	//�����������
	public void dfs(){
		vertexList[0].wasVisited = true;//��һ�������־λ���ʹ���
		displayVertex(0);

		theStack.push(0);
		while(!theStack.isEmpty()){
			int v=getAdjUnvisitedVertex(theStack.peek());
			if(v==-1)//û�ҵ�
				theStack.pop();
			else{
				vertexList[v].wasVisited=true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		for(int j=0; j<nVerts; j++)
			vertexList[j].wasVisited=false;//ȫ����ԭ����ʼ״̬
		System.out.println();
	}
	//��ȡָ���������ڽ���δ�����ʹ��Ķ���
	public int getAdjUnvisitedVertex(int v){
		for(int j=0; j<nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
				return j;//�ҵ���һ����V�������ڽ���δ�����ʹ��Ķ���
		return -1;//δ�ҵ�
	}
	public static void main(String[] args) throws IOException{
		long value;
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		
		while(true){
			System.out.print("Enter the first letter of show:");
			char choice = getChar();
			switch (choice){
				case 'i':
					System.out.print("Visits:");
					graph.dfs();
					break;
				default:
					System.out.print("Invalid Entry\n");
					break;
			}
		}
	}
	//�쳣����
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}
