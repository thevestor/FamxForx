package Graph;

import java.util.Iterator;

public interface DGraph<V> {
	/**������ȱ���*/
    public static final int ITERATOR_TYPE_DFS = 0;
    /**������ȱ���*/
    public static final int ITERATOR_TYPE_BFS = 0;
    
    /**
     * ���һ���˵�
     * @param v
     * @return �����˵�ı�ţ�-1��ʾ����ʧ��
     */
    public int add(V v);
    
    /**
     * ���һ����
     * @param e
     */
    public void add(Edge<V> e);
    
    /**
     * ɾ��һ�����㣬���������ı�Ҳ�ᱻɾ��
     * @param v
     * @return ��ɾ���Ķ��㣬����Ҳ�����Ӧ�����򷵻�null
     */
    public V remove(V v);
    
    /**
     * ɾ��һ����
     * @param e
     * @return ��ɾ���ıߣ�����Ҳ�����Ӧ�ı��򷵻�null
     */
    public Edge<V> remove(Edge<V> e);
    
    /**
     * ���һ������
     * @param index ����ı��
     * @return
     */
    public V get(int index);
    
    /**
     * ���һ����
     * @param src ���ı��
     * @param dest �յ�ı��
     * @return
     */
    public Edge<V> get(int src, int dest);
    
    /**
     * �õ���ǰͼ�ĵ����������ڶ�ͼ���б���
     * @param type �������ͣ�������Ȼ��߹������
     * @param root ���ĸ��㿪ʼ����
     * @return
     */
    public Iterator<V> iterator(int type, V root);
    
    /**
     * ��ͼת��Ϊ�޻�ͼ
     */
    public void convertDAG();
}
