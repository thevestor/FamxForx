package Graph;

/**
 * 一条边，可以根据需要继承此类
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class Edge<V> implements Comparable<Edge>{
    /**起点*/
    private V src;
    /**终点*/
    private V dest;
    /**权值*/
    private double weight;
    /**root**/
    private V root;
    /**
     * 不带权值的一条边
     * @param src
     * @param dest
     */
    public Edge(V src, V dest) {
        this(src, dest, 0);
    }
    
    /**
     * 带权值的一条边
     * @param src
     * @param dest
     * @param weight
     */
    public Edge(V src, V dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    /**
     * 获取起点
     * @return
     */
    public V getSource() {
        return this.src;
    }
    
    /**
     * 获取终点
     * @return
     */
    public V getDest() {
        return this.dest;
    }
    
    /**
     * 获取权值
     * @return
     */
    public double getWeight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        String ret = String.format("src : %s , dest : %s , weight : %s", src, dest, weight);
        return ret;
    }

	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(Edge other) {
		// TODO Auto-generated method stub
		return (int) (this.weight - other.weight);
	}

	public V getRoot() {
		return root;
	}

	public void setRoot(V root) {
		this.root = root;
	}
	
	
}
