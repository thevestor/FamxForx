package Graph;
import java.util.*;

import VertalGraph.StackX;
/**
 * �ڽ�����Adjacency List��ʵ�ֵ�����ͼ
 * @param <V>
 */
public class ListDGraph<V> implements DGraph<V>{

    /**
     * ������������ж�Ӧ�Ķ����Լ����Դ˶���Ϊ���ı�
     */
    private class VE {
        /**�˶���*/
        private V v;
        /**�Դ˶���Ϊ���ıߵļ��ϣ���һ���б��б��ÿһ����һ����*/
        private List<Edge<V>> mEdgeList;
        /**
         * ����һ���µĶ������
         * @param v
         */
        public VE(V v) {
            this.v = v;
            this.mEdgeList = new LinkedList<Edge<V>>();
            Utils.log("VE construct : %s", v);
        }
        
        @Override
        public String toString() {
            String ret = String.format("v : %s , list len : %s",
                                       v, mEdgeList.size());
            return ret;
        }
        
        /**
         * ��һ������ӵ��߼�����
         * @param e
         */
        public void addEdge(Edge<V> e) {
            Utils.log("add edge : %s", e);
            if(getEdge(e.getDest()) == null) {
                mEdgeList.add(e);
                
            } else {
                Utils.log("edge exist : %s", e);
            }
        }       
        
		/**
         * ��ȡĳ����
         * @param dest
         * @return
         */
        public Edge<V> getEdge(V dest) {
            Edge<V> ret = null;
            if(dest != null) {
                for(Edge<V> edge : mEdgeList) {
                    if(edge.getDest() != null &&
                       dest.equals(edge.getDest())) {
                        Utils.log("get edge : %s", edge);
                        ret = edge;
                        break;
                    }
                }
            }
            return ret;
        }
        
        /**
         * ��ȡĳ����
         * @param dest
         * @return
         */
        public Edge<V> removeEdge(V dest) {
            Edge<V> ret = null;
            if(dest != null) {
                for(Edge<V> edge : mEdgeList) {
                    if(edge.getDest() != null &&
                       dest.equals(edge.getDest())) {
                        Utils.log("remove edge : %s", edge);
                        ret = edge;
                        mEdgeList.remove(edge);
                        break;
                    }
                }
            }
            return ret;
        }
    }
    

    /**
     * ������ȵĵ�����
     */
    private class BFSIterator implements Iterator<V> {
        /**�ѷ��ʹ��Ķ����б�*/
        private List<V> mVisitList = null;
        /**�����ʵĶ������*/
        private Queue<V> mVQueue = null;
        
        /**
         * ���������ȵ�����
         * @param dg
         * @param root
         */
        public BFSIterator(V root) {
            mVisitList = new LinkedList<V>();
            mVQueue = new LinkedList<V>();
            
            //����ʼ�ڵ������
            mVQueue.offer(root);
        }
        
        @Override
        public boolean hasNext() {
            Utils.log("queue size : " + mVQueue.size());
            if(mVQueue.size() > 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public V next() {
            //1.ȡ����Ԫ��
            V v = mVQueue.poll();
            
            if(v != null) {
                //2.����Ԫ�ص��ڽӱ��ж�Ӧ��������У���Щ������Ҫ��������������
                //1)û���ʹ���
                //2)���ڶ����У�
                VE ve = getVE(v);
                if(ve != null) {
                    List<Edge<V>> list = ve.mEdgeList;
                    for(Edge<V> edge : list) {
                        V dest = edge.getDest();
                        if(!VinList(dest, mVisitList.iterator()) &&
                           !VinList(dest, mVQueue.iterator())) {
                            mVQueue.offer(dest);
                            Utils.log("add to queue : " + dest);
                        }
                    }
                }
                
                //3.���˶�����ӵ��ѷ��ʹ��Ķ����б���
                mVisitList.add(v);
            }
            
            //4.���س����е�Ԫ��
            return v;
        }

        @Override
        public void remove() {
            // ��ʱ��ʵ��
        }
        
    }
    
    /**�����б����ڻᾭ�����в���ɾ����ʹ���������*/
    private LinkedList<VE> mVEList;
    
    /**
     * �����ڽ���������ͼ
     */
    public ListDGraph() {
        mVEList = new LinkedList<VE>();
        Utils.log("ListDGraph construct!");
    }
    
    @Override
    public int add(V v) {
        int index = -1;
        if(v != null) {
            Utils.log("add v: %s", v);
            VE list = new VE(v);
            mVEList.add(list);
            index = mVEList.indexOf(list);
        }
        return index;
    }

    @Override
    public void add(Edge<V> e) {
        if(e != null) {
            Utils.log("add edge: %s", e);
            VE ve = getVE(e.getSource());
            if(ve != null) {
                //���ߵ�����Ѿ����б����ֱ�ӽ�����ӵ���Ӧ�Ķ��������
                ve.addEdge(e);
            } else {
                //������ʾ����
                Utils.log("Error, can't find v : %s", e.getSource());
            }
        }
    }
    
    @Override
    public V remove(V v) {
        V ret = null;
        
        VE ve = removeVE(v);
        if(ve != null) {
            ret = ve.v;
        }
        
        removeRelateEdge(v);
        
        return ret;
    }

    @Override
    public Edge<V> remove(Edge<V> e) {
        Edge<V> ret = null;
        
        if(e != null) {
            VE ve = getVE(e.getSource());
            if(ve != null) {
                ret = ve.removeEdge(e.getDest());
            }
        }
        
        return ret;
    }

    @Override
    public V get(int index) {
        V ret = null;
        if(index >=0 && index < mVEList.size()) {
            VE ve = mVEList.get(index);
            if(ve != null) {
                ret = ve.v;
                Utils.log("get , index : %s , v : %s", index, ret);
            }
        }
        return ret;
    }

    @Override
    public Edge<V> get(int src, int dest) {
        Edge<V> ret = null;
        V s = get(src);
        V d = get(dest);
        if(s != null && d != null) {
            VE ve = getVE(s);
            if(ve != null) {
                ret = ve.getEdge(d);
            }
        }
        return ret;
    }

    @Override
    public Iterator<V> iterator(int type, V root) {
        Iterator<V> ret = null;
        if(type == ITERATOR_TYPE_BFS) {
            //������ȵĵ�����
            ret = new BFSIterator(root);
        } else if(type == ITERATOR_TYPE_DFS){
            //������ȵĵ���������ʱδʵ��
        } else {
            //...
        }
        return ret;
    }

    @Override
    public void convertDAG() {
        // TODO Auto-generated method stub
        
    }

    //////////////////////////////˽�з���//////////////////////////////
    /**
     * �Ӷ�������б��ж�ȡ���붥���Ӧ�Ķ���
     * @param v
     * @return
     */
    private VE getVE(V v) {
        VE ret = null;
        if(v != null) {
            for(VE ve : mVEList) {
                if(ve.v != null && v.equals(ve.v)) {
                    Utils.log("getVE : %s", ve);
                    ret = ve;
                    break;
                }
            }
        }
        return ret;
    }
    
    /**
     * �Ӷ�������б���ɾ�����붥���Ӧ�Ķ���
     * @param v
     * @return ɾ���Ķ������
     */
    private VE removeVE(V v) {
        VE ret = null;
        if(v != null) {
            for(VE ve : mVEList) {
                if(ve.v != null && v.equals(ve.v)) {
                    Utils.log("removeVE : %s", v);
                    ret = ve;
                    mVEList.remove(ve);
                    break;
                }
            }
        }
        return ret;
    }
    
    
    /**
     * ɾ����ĳ������Ϊ�ص�ı�
     * @param v
     */
    private void removeRelateEdge(V v) {
        if(v != null) {
            for(VE ve : mVEList) {
                ve.removeEdge(v);
            }
        }
    }
    /**
     * 
     * @param e
     * @return
     */
	public static List<Edge> miniSpanningTree(List<Edge> e){
    	List<Edge> result = new ArrayList<>();
    	Collections.sort(e);
    	for(Edge edge : e) {
    		Edge u = (Edge) edge.getSource();
    		Edge v = (Edge) edge.getDest();
    		// ��� u �� v �Ѿ���ͬһ������������
            if (u.getRoot() == v.getRoot()) {
                continue;
            }
            result.add(edge);
            // �� u �� v ����ͬһ������
            // �ϲ���������ֱ�ӵİ취����ʹ��һ���µĸ���㣬Ȼ��������������
            TreeNode newRoot = new TreeNode();
            u.setRoot(newRoot);
            v.setRoot(newRoot);
    	}
    	return result;
    }
    /**
     * �ж�ĳ���˵��Ƿ���ĳ���б���
     * @param v
     * @param it
     * @return
     */
    private boolean VinList(V v, Iterator<V> it) {
        boolean ret = false;
        
        if(v != null && it != null) {
            while(it.hasNext()) {
                V v_temp = it.next();
                if(v_temp != null && v_temp.equals(v)) {
                    ret = true;
                    break;
                }
            }
        }
        
        return ret;
    }

	@Override
	public Edge<V> miniSpanningTree(Edge<V> e) {
		// TODO Auto-generated method stub
		return null;
	}
}