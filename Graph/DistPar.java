package Graph;

public class DistPar {
	public int distance; //从零点到当前结点的权重之和
	public int parentVert;//当点顶点的父节点
	
	public DistPar(int pv,int d) {
		distance = d;
		parentVert = pv;
	}
}
