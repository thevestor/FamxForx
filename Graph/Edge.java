package Graph;

/**
 * һ���ߣ����Ը�����Ҫ�̳д���
 * @param <V>
 */
public class Edge<V> {
    /**���*/
    private V src;
    /**�յ�*/
    private V dest;
    /**Ȩֵ*/
    private double weight;
    
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
}
