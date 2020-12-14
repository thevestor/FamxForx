package VertalGraph;

public class Graph {
	
	private final int MAX_VERTS = 20;
	private final int INFINITY = 65535; 
	private int nTree = 0;
	private DistPar sPath[];
	private int currentVert;
	private int startToCurrent;
	private Vertex[] vertexList;//��Ŷ��������
	private int adjMat[][];//�ڽӾ���
	private int nVerts;//��ǰ��������
	private StackX theStack;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		for(int j=0; j<MAX_VERTS; j++)
			for(int k=0; k<MAX_VERTS; k++)
				adjMat[j][k]=INFINITY;
		theStack = new StackX();
		sPath = new DistPar[MAX_VERTS];
	}
	//��Ӷ���
	public void addVertex(char lab){
		vertexList[nVerts++]= new Vertex(lab);
	}
	//��ӱ�
	public void addEdge(int start, int end,int weight){
//dfs		adjMat[start][end]=1;
//dfs		adjMat[end][start]=1;
		adjMat[start][end] = weight; //distance <=> weight 
	}
	public void displayVertex(int v){
		System.out.print(vertexList[v].label + "");
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
	}
	//��ȡָ���������ڽ���δ�����ʹ��Ķ���
	public int getAdjUnvisitedVertex(int v){
		for(int j=0; j<nVerts; j++)
		{
			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
			{
				return j;//�ҵ���һ����V�������ڽ���δ�����ʹ��Ķ���
			}	
		}
		return -1;//δ�ҵ�
	}
	//���·�����÷���ʹ����DistPar���Vertex��
	public void path() { //�ҵ����е����·��
		int startTree = 0;//����λ���㿪ʼ
		vertexList[startTree].wasVisited = true;
		nTree = 1;//����ǰ����ŵ�����
		
		for(int j = 0;j < nVerts;j++) {//��·����adjMat���䵽sPath
			int tempDist = adjMat[startTree][j];
			sPath[j] = new DistPar(startTree,tempDist);
		}
		//ֱ�����ж��㶼������
		while(nTree < nVerts) {
			int indexMin = getMin();//��ȡ���·��
			int minDist = sPath[indexMin].distance;//ѡ��sPath[] �����е���С����
			
			if(minDist == INFINITY) {//��������������������
				System.out.println("There are unreachable vertices");
				break;  //�ҵ���
			}
			else {//�������õ�ǰ����
				currentVert = indexMin;  //��ֵ������Ķ���
				startToCurrent = sPath[indexMin].distance;
			}
			vertexList[currentVert].wasVisited = true;
			nTree ++;
			adjust_sPath(); //�������� sPath[]���������
		}
		displayPaths();  //չʾ sPath[] ��Ԫ��
		
		nTree = 0; //�����
		for(int j = 0;j < nVerts;j++) {
			vertexList[j].wasVisited = false;
		}
	}
	//����sPath()����
	private void adjust_sPath() {//�������·������sPath�е�ֵ
		int column = 1; //������ʼ����
		while(column < nVerts) //column����ѭ������������ָ��ÿ�����㣬���ڼ�鶥���Ƿ������У�����������
		{
			if(vertexList[column].wasVisited) {//�����Щ��ʼ�����Ѿ������У���������
				column ++;
				continue;
			}
			// ����һ��sPath��Ŀ�ľ���
			int currentToFringe = adjMat[currentVert][column];//��currentVert��ȡ��Ե����ʼ����
			int startToFringe = startToCurrent + currentToFringe;//�ѵ���ǰ����ľ���ӵ���currentVert���㵽column����ľ�����
			int sPathDist = sPath[column].distance;//��ȡ��ǰsPath��Ŀ�ľ���
			
			if(startToFringe < sPathDist)//�Ƚ�startToFringe��sPath[]����ĵ�ǰ����бȽϣ�����̣����滻��ǰ��
			{
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column ++;
		}
	}
	private void displayPaths() {
		for(int j = 0;j < nVerts;j++) {
			System.out.print(vertexList[j].label + "=");// B=
			if(sPath[j].distance == INFINITY)
				System.out.print("inf"); //inf
			else
				System.out.print(sPath[j].distance); // 50
			char parent = vertexList[sPath[j].parentVert].label;
			System.out.print("(" + parent + ")");// (A)
		}
		System.out.println();
	}
	private int getMin() { //��sPath[] �����л�ȡ��С����
		int minDist = INFINITY; //����Ϊ��̾���
		int indexMin = 0;
		for(int j = 1;j < nVerts;j++) { //����ÿһ������
			if(!vertexList[j].wasVisited && sPath[j].distance < minDist) {//�����ǰ���������У����߱�֮ǰ�Ķ����ֵС
									//sPath[j].distance < minDist
				minDist = sPath[j].distance; 
				indexMin = j; //�������·��
			}
		}
		return indexMin; //�������·��������
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A'); // 0 (start)
		graph.addVertex('B'); // 1
		graph.addVertex('C'); // 2
		graph.addVertex('D'); // 3
		graph.addVertex('E'); // 4
		
		graph.addEdge(0, 1, 50); // AB 50
		graph.addEdge(0, 3, 80); // AD 80
		graph.addEdge(1, 2, 60); // BC 60
		graph.addEdge(1, 3, 90); // BD 90
		graph.addEdge(2, 4, 40); // CE 40
		graph.addEdge(3, 2, 20); // DC 20
		graph.addEdge(3, 4, 70); // DE 70
		graph.addEdge(4, 1, 50); // EB 50
		
		//System.out.print("Visits:");
		//graph.dfs();
		System.out.println("���·��Ϊ:");
		graph.path();
		System.out.println();
	}
}
