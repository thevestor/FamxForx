package Graph;

/**
 * Java: Kruskal�㷨������С������(�ڽӾ���)
 *
 * @author FamxForx
 * @date 2014/04/24
 */

import java.io.*;
import java.util.*;

public class MatrixUDG {

    private int mEdgNum;        // �ߵ�����
    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ

    /* 
     * ����ͼ(�Լ���������)
     */
    public MatrixUDG() {

        // ����"������"��"����"
        Utils.log("input vertex number: ");
        int vlen = readInt();
        Utils.log("input edge number: ");
        int elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            Utils.log("input error: invalid parameters!\n");
            return ;
        }
        
        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
        	Utils.log("vertex(%d): ", i);
            mVexs[i] = readChar();
        }

        // 1. ��ʼ��"��"��Ȩֵ
        mEdgNum = elen;
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i==j)//��������ıߵĳ�����ͬ���򷵻�0
                    mMatrix[i][j] = 0;
                else
                    mMatrix[i][j] = INF;
            }
        }
        // 2. ��ʼ��"��"��Ȩֵ: �����û���������г�ʼ��
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����,��������,Ȩֵ
            Utils.log("edge(%d):", i);
            char c1 = readChar();       // ��ȡ"��ʼ����"
            char c2 = readChar();       // ��ȡ"��������"
            int weight = readInt();     // ��ȡ"Ȩֵ"

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            if (p1==-1 || p2==-1) {
                Utils.log("input error: invalid edge!\n");
                return ;
            }

            mMatrix[p1][p2] = weight;
            mMatrix[p2][p1] = weight;
        }
    }

    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     matrix-- ����(����)
     */
    public MatrixUDG(char[] vexs, int[][] matrix) {
        
        // ��ʼ��"������"��"����"
        int vlen = vexs.length;

        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // ��ʼ��"��"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];

        // ͳ��"��"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i+1; j < vlen; j++)
                if (mMatrix[i][j]!=INF)
                    mEdgNum++;
    }

    /*
     * ����chλ��
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private char readChar() {
        char ch='0';
        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private int readInt() {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /*
     * ���ض���v�ĵ�һ���ڽӶ����������ʧ���򷵻�-1
     */
    private int firstVertex(int v) {

        if (v<0 || v>(mVexs.length-1))
            return -1;

        for (int i = 0; i < mVexs.length; i++)
            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
                return i;

        return -1;
    }

    /*
     * ���ض���v�����w����һ���ڽӶ����������ʧ���򷵻�-1
     */
    private int nextVertex(int v, int w) {

        if (v<0 || v>(mVexs.length-1) || w<0 || w>(mVexs.length-1))
            return -1;

        for (int i = w + 1; i < mVexs.length; i++)
            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
                return i;

        return -1;
    }

    /*
     * ���������������ͼ�ĵݹ�ʵ��
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        Utils.log("%c ", mVexs[i]);
        // �����ö���������ڽӶ��㡣����û�з��ʹ�����ô����������
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w])
                DFS(w, visited);
        }
    }

    /*
     * ���������������ͼ
     */
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];       // ������ʱ��

        // ��ʼ�����ж��㶼û�б�����
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        Utils.log("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        Utils.log("\n");
    }

    /*
     * ����������������������Ĳ�α�����
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];            // �������
        boolean[] visited = new boolean[mVexs.length];  // ������ʱ��

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        Utils.log("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Utils.log("%c ", mVexs[i]);
                queue[rear++] = i;  // �����
            }

            while (head != rear) {
                int j = queue[head++];  // ������
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { //k��Ϊ���ʵ��ڽӶ���
                    if (!visited[k]) {
                        visited[k] = true;
                        Utils.log("%c ", mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        Utils.log("\n");
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        Utils.log("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                Utils.log("%10d ", mMatrix[i][j]);
            Utils.log("\n");
        }
    }

    /*
     * prim��С������
     *
     * ����˵����
     *   start -- ��ͼ�еĵ�start��Ԫ�ؿ�ʼ��������С��
     */
    public void prim(int start) {
        int num = mVexs.length;         // �������
        int index=0;                    // prim��С������������prims���������
        char[] prims  = new char[num];  // prim��С���Ľ������
        int[] weights = new int[num];   // �����ߵ�Ȩֵ

        // prim��С�������е�һ������"ͼ�е�start������"����Ϊ�Ǵ�start��ʼ�ġ�
        prims[index++] = mVexs[start];

        // ��ʼ��"�����Ȩֵ����"��
        // ��ÿ�������Ȩֵ��ʼ��Ϊ"��start������"��"�ö���"��Ȩֵ��
        for (int i = 0; i < num; i++ )
            weights[i] = mMatrix[start][i];
        // ����start�������Ȩֵ��ʼ��Ϊ0��
        // �������Ϊ"��start�����㵽������ľ���Ϊ0"��
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            // ���ڴ�start��ʼ�ģ���˲���Ҫ�ٶԵ�start��������д���
            if(start == i)
                continue;

            int j = 0;
            int k = 0;
            int min = INF;
            // ��δ�����뵽��С�������Ķ����У��ҳ�Ȩֵ��С�Ķ��㡣
            while (j < num) {
                // ��weights[j]=0����ζ��"��j���ڵ��Ѿ��������"(����˵�Ѿ���������С��������)��
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            // ��������Ĵ������δ�����뵽��С�������Ķ����У�Ȩֵ��С�Ķ����ǵ�k�����㡣
            // ����k��������뵽��С�������Ľ��������
            prims[index++] = mVexs[k];
            // ��"��k�������Ȩֵ"���Ϊ0����ζ�ŵ�k�������Ѿ��������(����˵�Ѿ���������С�������)��
            weights[k] = 0;
            // ����k�����㱻���뵽��С�������Ľ��������֮�󣬸������������Ȩֵ��
            for (j = 0 ; j < num; j++) {
                // ����j���ڵ�û�б�����������Ҫ����ʱ�ű����¡�
                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
                    weights[j] = mMatrix[k][j];
            }
        }

        // ������С��������Ȩֵ
        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            // ��ȡprims[i]��mMatrix�е�λ��
            int n = getPosition(prims[i]);
            // ��vexs[0...i]�У��ҳ���j��Ȩֵ��С�Ķ��㡣
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n]<min)
                    min = mMatrix[m][n];
            }
            sum += min;
        }
        // ��ӡ��С������
        Utils.log("PRIM(%c)=%d: ", mVexs[start], sum);
        for (int i = 0; i < index; i++)
            Utils.log("%c ", prims[i]);
        Utils.log("\n");
    }

    /*
     * ��³˹������Kruskal)��С������
     */
    public void kruskal() {
        int index = 0;                      // rets���������index
        int[] vends = new int[mEdgNum];     // ���ڱ���"������С������"��ÿ�������ڸ���С���е��յ�vends,mEdgNum��ʾ�ߵļ��ϡ�
        EData[] rets = new EData[mEdgNum];  // ������飬����kruskal��С�������ı�,mEdgNum��ʾ�ߵļ��ϡ�
        EData[] edges;                      // ͼ��Ӧ�����б�

        // ��ȡ"ͼ�����еı�"
        edges = getEdges();
        // ���߰���"Ȩ"�Ĵ�С��������(��С����)
        sortEdges(edges, mEdgNum);

        for (int i=0; i<mEdgNum; i++) {
            int p1 = getPosition(edges[i].start);      // ��ȡ��i���ߵ�"���"�����
            int p2 = getPosition(edges[i].end);        // ��ȡ��i���ߵ�"�յ�"�����

            int m = getEnd(vends, p1);                 // ��ȡp1��"���е���С������"�е��յ�
            int n = getEnd(vends, p2);                 // ��ȡp2��"���е���С������"�е��յ�
            // ���m!=n����ζ��"��i"��"�Ѿ���ӵ���С�������еĶ���"û���γɻ�·
            if (m != n) {
                vends[m] = n;                       // ����m��"���е���С������"�е��յ�Ϊn
                rets[index++] = edges[i];           // ������
                
            }
            
        }

        // ͳ�Ʋ���ӡ"Kruskal��С������"����Ϣ
        int length = 0;
        for (int i = 0; i < index; i++)
            length += rets[i].weight;
        Utils.log("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++)
            Utils.log("(%c,%c) ", rets[i].start, rets[i].end);
        Utils.log("\n");
    }

    /* 
     * ��ȡͼ�еı�
     */
    private EData[] getEdges() {
        int index=0;
        EData[] edges;

        edges = new EData[mEdgNum];
        for (int i=0; i < mVexs.length; i++) {
            for (int j=i+1; j < mVexs.length; j++) {
                if (mMatrix[i][j]!=INF) {
                    edges[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
                }
            }
        }

        return edges;
    }

    /* 
     * �Ա߰���Ȩֵ��С��������(��С����)
     */
    private void sortEdges(EData[] edges, int elen) {

        for (int i=0; i<elen; i++) {
            for (int j=i+1; j<elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // ����"��i"��"��j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /*
     * ��ȡi���յ�
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }

    // �ߵĽṹ��
    private static class EData {
        char start; // �ߵ����
        char end;   // �ߵ��յ�
        int weight; // �ߵ�Ȩ��

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    };
    public static void main(String[] args) throws IOException{
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        
        
       
        while(true) {
        	System.out.println("Enter the first letter of");
            System.out.println("c,n:");
        	char choice = getChar();
        	switch(choice) {
        		case 'c':
        			System.out.println("=============== �����Զ���ͼ ==============");
        			System.out.println("Enter the second letter of");
        			System.out.println("printCustom,print,dfs,bfs,prim,krukal:");
        			char choice1 = getChar();
        			MatrixUDG pG;
        			pG = new MatrixUDG();
        			switch(choice1) {
        				case 'p':
        					System.out.println("=============== ��ӡͼ =========");
        					pG.print();
        					break;
        				case 'd':
        					System.out.println("========== ������ȱ��� ==============");
        					pG.DFS();
        					break;
        				case 'b':
        					System.out.println("============= ������ȱ��� ===============");
        					pG.BFS();
        					break;
        				case 'm':
        					System.out.println("============ ����ķ�㷨 ===============");
        					pG.prim(0);
        					break;
        				case 'k':
        					System.out.println("============ ��³˹�����㷨 ===============");
        					pG.kruskal();
        					break;
        				default:
        					System.out.println("Invalid Entry\n");
        					break;
        			}
        			break;
        		case 'n':
        			System.out.println("============== �������е�ͼ ===================");
        			pG = new MatrixUDG(vexs,matrix);
        			System.out.println("Enter the second letter of");
        			System.out.println("printCustom,print,dfs,bfs,prim,krukal:");
        			char choice2 = getChar();
        			switch(choice2) {
        				case 'p':
        					System.out.println("=============== ��ӡͼ =========");
        					pG.print();
        					break;
        				case 'd':
        					System.out.println("========== ������ȱ��� ==============");
        					pG.DFS();
        					break;
        				case 'b':
        					System.out.println("============= ������ȱ��� ===============");
        					pG.BFS();
        					break;
        				case 'm':
        					System.out.println("============ ����ķ�㷨 ===============");
        					pG.prim(0);
        					break;
        				case 'k':
        					System.out.println("============ ��³˹�����㷨 ===============");
        					pG.kruskal();
        					break;
        				default:
        					System.out.println("Invalid Entry\n");
        					break;
        			}
        			break;
        		default:
        			System.out.println("Invalid Entry\n");
        			break;
        	}
        }
    }
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

