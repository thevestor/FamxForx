package VertalGraph;

public class Graph {
	
	private final int MAX_VERTS = 20;
	private final int INFINITY = 65535; 
	private int nTree = 0;
	private DistPar sPath[];
	private int currentVert;
	private int startToCurrent;
	private Vertex[] vertexList;//存放顶点的数组
	private int adjMat[][];//邻接矩阵
	private int nVerts;//当前顶点数量
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
	//添加顶点
	public void addVertex(char lab){
		vertexList[nVerts++]= new Vertex(lab);
	}
	//添加边
	public void addEdge(int start, int end,int weight){
//dfs		adjMat[start][end]=1;
//dfs		adjMat[end][start]=1;
		adjMat[start][end] = weight; //distance <=> weight 
	}
	public void displayVertex(int v){
		System.out.print(vertexList[v].label + "");
	}
	//深度优先搜索
	public void dfs(){
		vertexList[0].wasVisited = true;//第一个顶点标志位访问过的
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty()){
			int v=getAdjUnvisitedVertex(theStack.peek());
			if(v==-1)//没找到
				theStack.pop();
			else{
				vertexList[v].wasVisited=true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		for(int j=0; j<nVerts; j++)
			vertexList[j].wasVisited=false;//全部还原到初始状态
	}
	//获取指定顶点相邻接且未被访问过的顶点
	public int getAdjUnvisitedVertex(int v){
		for(int j=0; j<nVerts; j++)
		{
			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
			{
				return j;//找到了一个与V顶点相邻接且未被访问过的顶点
			}	
		}
		return -1;//未找到
	}
	//最短路径，该方法使用了DistPar类和Vertex类
	public void path() { //找到所有的最短路径
		int startTree = 0;//从首位顶点开始
		vertexList[startTree].wasVisited = true;
		nTree = 1;//将当前顶点放到树上
		
		for(int j = 0;j < nVerts;j++) {//将路径从adjMat传输到sPath
			int tempDist = adjMat[startTree][j];
			sPath[j] = new DistPar(startTree,tempDist);
		}
		//直到所有顶点都在树中
		while(nTree < nVerts) {
			int indexMin = getMin();//获取最短路径
			int minDist = sPath[indexMin].distance;//选择sPath[] 数组中的最小距离
			
			if(minDist == INFINITY) {//如果等于无穷或者在树中
				System.out.println("There are unreachable vertices");
				break;  //找到了
			}
			else {//否则重置当前顶点
				currentVert = indexMin;  //赋值给最近的顶点
				startToCurrent = sPath[indexMin].distance;
			}
			vertexList[currentVert].wasVisited = true;
			nTree ++;
			adjust_sPath(); //更新所有 sPath[]数组的内容
		}
		displayPaths();  //展示 sPath[] 的元素
		
		nTree = 0; //清空树
		for(int j = 0;j < nVerts;j++) {
			vertexList[j].wasVisited = false;
		}
	}
	//更新sPath()数组
	private void adjust_sPath() {//更新最短路径数组sPath中的值
		int column = 1; //跳过起始顶点
		while(column < nVerts) //column用于循环计数，依次指向每个顶点，用于检查顶点是否在树中，若不在树中
		{
			if(vertexList[column].wasVisited) {//如果这些起始顶点已经在树中，跳过它们
				column ++;
				continue;
			}
			// 计算一个sPath条目的距离
			int currentToFringe = adjMat[currentVert][column];//从currentVert获取边缘到起始顶点
			int startToFringe = startToCurrent + currentToFringe;//把到当前顶点的距离加到从currentVert顶点到column顶点的距离上
			int sPathDist = sPath[column].distance;//获取当前sPath条目的距离
			
			if(startToFringe < sPathDist)//比较startToFringe与sPath[]数组的当前项进行比较，如果短，则替换当前项
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
	private int getMin() { //从sPath[] 数组中获取最小距离
		int minDist = INFINITY; //假设为最短距离
		int indexMin = 0;
		for(int j = 1;j < nVerts;j++) { //遍历每一个顶点
			if(!vertexList[j].wasVisited && sPath[j].distance < minDist) {//如果当前顶点在树中，或者比之前的顶点的值小
									//sPath[j].distance < minDist
				minDist = sPath[j].distance; 
				indexMin = j; //更新最短路径
			}
		}
		return indexMin; //返回最短路径的索引
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
		System.out.println("最短路径为:");
		graph.path();
		System.out.println();
	}
}
