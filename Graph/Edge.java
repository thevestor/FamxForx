package Graph;

/**
 * һ���ߣ����Ը�����Ҫ�̳д���
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class Edge<V> implements Comparable<Edge>{
    /**���*/
    private V src;
    /**�յ�*/
    private V dest;
    /**Ȩֵ*/
    private double weight;
    /**root**/
    private V root;
    /**
     * ����Ȩֵ��һ����
     * @param src
     * @param dest
     */
    public Edge(V src, V dest) {
        this(src, dest, 0);
    }
    
    /**
     * ��Ȩֵ��һ����
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
     * ��ȡ���
     * @return
     */
    public V getSource() {
        return this.src;
    }
    
    /**
     * ��ȡ�յ�
     * @return
     */
    public V getDest() {
        return this.dest;
    }
    
    /**
     * ��ȡȨֵ
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
