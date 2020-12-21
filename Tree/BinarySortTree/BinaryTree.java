package BinarySortTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	// ���ڵ�
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * ����ڵ�
     *
     * @param value �ڵ�ֵ
     */
    public void insert(long value) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        BinaryTreeNode current = root;
        BinaryTreeNode parent;
        // �����ǰû�и��ڵ㣬�²���ڵ�Ϊ���ڵ�
        if (root == null) {
            // �˴�����д�� current = node��current ֻ�����ã����ᱻ�������������գ���һ�� insert ��current �����գ�
            // root == null ��
            root = node;
            return;
        }
        while (true) {
            // ���ڵ�Ϊ���ڽڵ�
            parent = current;
            // �����ǰ�ڵ��ֵ�Ȳ���ֵС�����ڶ�������������������ұ߱���
            if (current.data < value) {
                // ��ǰ�ڵ�Ϊ�Һ��ӽڵ�
                current = current.rightChild;
                // �Һ��ӽڵ�Ϊ null , �ǾͿ��Ը�ֵ���Һ���
                if (current == null) {
                    parent.rightChild = node;
                    return;
                }
            } else {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = node;
                    return;
                }
            }
        }
    }

    /**
     * ������
     *
     * @param data Ҫ����Ľ��
     */
    public void insert(int data) {
        this.root = insert(data, root);
    }

    /**
     * �ݹ����
     *
     * @param data Ҫ����Ľ��
     */
    public BinaryTreeNode insert(int data, BinaryTreeNode node) {
        // ����ڵ�Ϊ null ��˵��û�к��ӣ��Ϳ��Դ����½��
        if (node == null) {
            node = new BinaryTreeNode(data);
        }

        // �������ֵ�ȸ��ڵ�С����������������
        if (data < node.data) {
            // ��Ϊ���Ǵ�����������ģ����������ӽڵ�֮����ô��һ���Ǹ���������
            node.leftChild = insert(data, node.leftChild);

        }
        // �������ֵ�ȸ��ڵ�󣬾�������������
        if (data > node.data) {
            // ��Ϊ��������������ģ����������ӽڵ�֮����ô��һ���Ǹ���������
            node.rightChild = insert(data, node.rightChild);
        }
        // ���ظ��ڵ�
        return node;
    }



    /**
     * ���ҽڵ�
     *
     * @param value ��Ҫ����ֵ
     * @return
     */
    public BinaryTreeNode find(long value) {
        // ��¼��ǰ�ڵ�,�Ӹ��ڵ㿪ʼ
        BinaryTreeNode current = root;
        // ����ڵ�Ϊ null ��return null
        if (root == null) {
            return null;
        }
        // ���һֱ�����ڣ�һֱѭ����Ԫ�أ�ֱ���ҵ�ֵ
        while (current.data != value) {
            // �����ǰ�ڵ�����ݱȲ���ֵ�󣬾������ӱ���
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    /**
     * ����������ҽڵ㣺������
     * ��ʵ���ȷ��� node.data ���ٷ�����������Ҳ�� node.data ,�ٷ���������
     *
     * @param node ���������ڵ�
     */
    public void preOrderTraverseSearch(BinaryTreeNode node, long searchData) {
        // ������������ڵ㲻Ϊ null
        if (node != null) {
            // �ȷ��ʸ��ڵ�
            if (searchData == node.data) {
                System.out.println("���ݣ�" + node.data);
            }
            // �ٷ���������
            preOrderTraverseSearch(node.leftChild, searchData);
            // �ٷ���������
            preOrderTraverseSearch(node.rightChild, searchData);
        }
    }

    /**
     * ���������������
     * ��ʵ���ȷ��� node.data ���ٷ�����������Ҳ�� node.data ,�ٷ���������
     *
     * @param node ���������ڵ�
     */
    public void preOrderTraverse(BinaryTreeNode node) {
        // ������������ڵ㲻Ϊ null
        if (node != null) {
            // �ȷ��ʸ��ڵ�
            System.out.println("���ݣ�" + node.data);
            // �ٷ���������
            preOrderTraverse(node.leftChild);
            // �ٷ���������
            preOrderTraverse(node.rightChild);
        }

    }


    /**
     * ��������������,��ʵ��Ϊ�Ƕ������������С�Ҵ�������������൱���������������2,10,20,21,30.....
     * ��ʵ�Ƿ��� node Ҷ�ӽڵ� node.leftChild==null���Ϳ��Է��� node.data��node.rightChild==null���Ϳ��Է��� node �ĸ���ڵ�
     *
     * @param node ���������ڵ�
     */
    public void inOrderTraverse(BinaryTreeNode node) {
        // ������������ڵ㲻Ϊ null
        if (node != null) {
            // �ȷ���������
            inOrderTraverse(node.leftChild);
            // �ٷ��ʸ��ڵ�
            System.out.print("���ݣ�" + node.data + " ");
            // �ٷ���������
            inOrderTraverse(node.rightChild);
        }
    }

    /**
     * ������������Ҹ�
     * ��ʵ�Ƿ��� node Ҷ�ӽڵ� node.leftChild==null��node.rightChild==null���Ϳ��Է��� node.data
     *
     * @param node ���������ڵ�
     */
    public void afterOrderTraverse(BinaryTreeNode node) {
        // ������������ڵ㲻Ϊ null
        if (node != null) {
            // �ȷ���������
            afterOrderTraverse(node.leftChild);
            // �ٷ���������
            afterOrderTraverse(node.rightChild);
            // �ٷ��ʸ��ڵ�
            System.out.println("���ݣ�" + node.data);
        }
    }


    /**
     * ��������ӡ�����������������ذ��ڹ涨��ʽ���أ���ÿ��λ�þ��������²�ṹ
     * [, , , , , , , 40, , , , , , , ]
     * [, , , 10, , , , , , , , 55, , , ]
     * [, 2, , , , 21, , , , 44, , , , 65, ]
     * [, , , , 20, , 30, , , , , , , , ]
     *
     * @param root ���������ڵ�
     */
    public List<List<String>> printTree(BinaryTreeNode root) {
        // ͨ����ʽȷ�����ݽṹ��List<List<String>>, List<List<String>> ���������List<String> ������ÿһ��
        List<List<String>> list = new ArrayList<>();
        // ȷ�����м��㣬�� List<List<String>> �������ж��� list
        int height = getHeight(root);
        // ȷ��ÿһ�� list �ж೤,���ȶ��� 2 �� height �η� -1��
        // �պ���һ�������Ԫ�ظ�������Ϊ����Ҫ���Ͽո��ټ�����Ԫ�أ��պ�Ϊһ�������Ԫ�ظ���
        int length = (int) Math.pow(2, height) - 1;
        // ���� list �����������Ԫ��
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // ���һ�� "",�� [, , , , , , , , , , , , , , ]
            subList.add("");
        }
        // Ϊ List<List<String>> ��������Ӳ���
        for (int i = 0; i < height; i++) {
            // ����������ݣ������
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            list.add(new ArrayList<>(subList));
        }
        // �ݹ飬�������Ԫ�ص������У�ÿ�ζ�����������߼����ұ� /2 ,�����������һ����� root ���ڵ�Ϊ null ������
        traverseFill(root, list, 0, height, 0, length - 1);
        return list;
    }

    /**
     * �ݹ飬�������Ԫ�ص������У�ÿ�ζ�����������߼����ұ�/2 ,�����������һ����� root ���ڵ�Ϊ null ������
     *
     * @param root   ���ڵ�
     * @param list   �洢���ݵ�����
     * @param row    ��ʼ����
     * @param height �����Ĳ���
     */
    public void traverseFill(BinaryTreeNode root, List<List<String>> list, int row, int height, int i, int j) {
        // ������ڵ�Ϊ null �����߱��������һ�㣬����
        if (root == null || row == height) {
            return;
        }
        // ��ֵ���Ѹ��ڵ��Ԫ��ֵ��ֵ�� ( ��߼��ұ� / 2 )��λ��
        list.get(row).set((i + j) / 2, String.valueOf(root.data));
        // ���������
        traverseFill(root.leftChild, list, row + 1, height, i, (i + j) / 2 - 1);
        // ���������
        traverseFill(root.rightChild, list, row + 1, height, (i + j) / 2 + 1, j);
    }

    /**
     * �õ����ĸ߶�
     *
     * @param root ���������ڵ�
     * @return ���ĸ߶�
     */
    public int getHeight(BinaryTreeNode root) {
        // ����ǿ��������� 0
        if (root == null) {
            return 0;
        }
        // ������������,�õ��������ĸ߶�
        int left = getHeight(root.leftChild);
        // ������������,�õ��������ĸ߶�
        int right = getHeight(root.rightChild);
        // + 1 ��Ϊ�˵��ڵ㣨root.leftChild | root.rightChild��Ϊ null �����ظ��ڵ㣬��ô�����ͼ�һ����ʵ�����������������������߶ȼ��ϸ��ڵ�
        return Math.max(left, right) + 1;
    }
    /**
     * ɾ�����������
     * 1. ���ҳ�Ҫɾ���Ľڵ�
     * 2. ɾ���Ľڵ������Ҷ�ӽڵ㣬ֱ���ø��ڵ�����ӻ����Һ���Ϊ null �Ϳ���
     * 3. ɾ���Ľڵ�����ǽ���һ�����ӵģ�ֱ�������ĸ��ڵ��������ĺ���
     * 4. ɾ���Ľڵ�����������Һ��ӵģ�ʹ������������������ýڵ㡣
     *
     * @param value Ҫɾ���ڵ�
     * @return ɾ���ɹ�����ʧ��
     */
    public boolean delete(long value) {
        // ���ҳ�Ҫɾ���ڵ�
        BinaryTreeNode current = root;
        // Ϊ����һ����ɾ�������常�ڵ�
        BinaryTreeNode parent = root;
        boolean isLeftChild = true;
        // ѭ������Ϊ�Ҳ������Ͽ�ѭ�������ҵ���
        while (current.data != value) {
            parent = current;
            // ��ѯ��ֵ�ȸ��ڵ�С����������������
            if (current.data > value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            // û���ҵ�
            if (current == null) {
                return false;
            }
        }
        // ���ɾ���Ľڵ���Ҷ�ӽڵ�
        if (current.leftChild == null && current.rightChild == null) {
            // ��Ҫ���ڵ�����ӻ����Һ���Ϊ null����Ҫ���ڵ�����û��� current �ڵ��Ƿ�Ϊ���ҽڵ������
            if (current == root) { // ����Ǹ��ڵ㣬ֱ���� null
                root = null;
            } else if (isLeftChild) { // ��������ӣ����ڵ�������� null
                parent.leftChild = null;
            } else {// ������Һ��ӣ����ڵ���Һ����� null
                parent.rightChild = null;
            }
        } else if (current.leftChild == null) {// ���ɾ���Ľڵ���һ�����ӻ�����һ���Һ���
            // ����Ϊ null ��һ�����Һ���
            if (current == root) {// ����Ǹ��ڵ㣬���ڵ�Ϊ�Һ���
                root = current.rightChild;
            } else if (isLeftChild) {// �����ɾ���ڵ������ӣ���ô���ڵ�����Ӿ�Ϊ��ǰ�ڵ���Һ���
                parent.leftChild = current.rightChild;
            } else {// �����ɾ���ڵ����Һ��ӣ���ô���ڵ���Һ��Ӿ�Ϊ��ǰ�ڵ���Һ���
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            // �Һ���Ϊ null ��һ��������
            if (current == root) {// ����Ǹ��ڵ㣬���ڵ�Ϊz����
                root = current.leftChild;
            } else if (isLeftChild) {// �����ɾ���ڵ������ӣ���ô���ڵ�����Ӿ�Ϊ��ǰ�ڵ������
                parent.leftChild = current.leftChild;
            } else {// �����ɾ���ڵ����Һ��ӣ���ô���ڵ���Һ��Ӿ�Ϊ��ǰ�ڵ������
                parent.rightChild = current.leftChild;
            }
        } else {
            // �ҳ���̽ڵ�
            BinaryTreeNode successor = getSuccessor(current);
            if (current == root) {// ����Ǹ��ڵ�,���ڵ��Ϊ successor
                root = successor;
            } else if (isLeftChild) {// �����ɾ���ڵ�������,���ڵ�����Ӿ�Ϊ��̽ڵ�
                parent.leftChild = successor;
            } else {// �����ɾ���ڵ����Һ���,���ڵ���Һ��Ӿ�Ϊ��̽ڵ�
                parent.rightChild = successor;
            }
            // ���� successor �� ��ɾ���ڵ��滻��֮��successor ����������������Ϊ��ɾ���ڵ�ĵ���������������
            successor.leftChild = current.leftChild;
            // successor.rightChild=current.rightChild;
            // ����ע�͵�����Ϊ����ֱ��ָ����̽ڵ���Һ���Ϊ��ɾ���ڵ���Һ���ʱ���߼���û�����������һ���㣬�����̽ڵ㻹���Һ����أ������Ѱ�Һ�̽ڵ��ʱ��ֱ�Ӵ����̽ڵ㻹��û���Һ��ӵ����
        }
        return true;
    }

    /**
     * �ҳ���ǰ�ڵ�ĺ�̽ڵ�
     *
     * @param delNode ��ǰ�ڵ�
     * @return
     */
    public BinaryTreeNode getSuccessor(BinaryTreeNode delNode) {
        // ������ǰ�ڵ����ã�Ϊɾ���ڵ���Һ��ӽڵ�
        BinaryTreeNode current = delNode.rightChild;
        // ������̽ڵ�����
        BinaryTreeNode successor = current;
        // ������̽ڵ㸸�ڵ�����
        BinaryTreeNode parentSuccessor = delNode;
        // �������������������ҵ���ɾ���ڵ���ֵ����С��ֵ
        while (current != null) {
            parentSuccessor = successor;
            successor = current;
            current = current.leftChild;
        }
        // �����̽ڵ㻹��û���Һ��ӵ����,������̽ڵ㲻��Ҫɾ���ڵ���Һ���ʱ
        if (successor != delNode.rightChild) {
            // �󼯽�㸸�ڵ������Ϊ��̽ڵ���Һ���
            parentSuccessor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
    public static void main(String[] args) throws IOException{
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(40);
        binaryTree.insert(10);
        binaryTree.insert(55);
        binaryTree.insert(44);
        binaryTree.insert(2);
        binaryTree.insert(65);
        binaryTree.insert(21);
        binaryTree.insert(30);
        binaryTree.insert(18);
        binaryTree.insert(20);
        binaryTree.insert(1);
        binaryTree.insert(5);
        binaryTree.insert(45);
        binaryTree.insert(64);
        while(true) {
        	System.out.println("Please enter the first letter of ");
        	System.out.println("PreTraversal,inTraversal,postTraversal,GenerPrint,find,delete :");
        	char choice = getChar();
        	switch(choice) {
        		case 'p' :
        			 // �����������򡢺������
        	        System.out.println("ǰ������Ľ��Ϊ��");
        	        binaryTree.preOrderTraverse(binaryTree.getRoot());
        	        binaryTree.preOrderTraverseSearch(binaryTree.getRoot(),32);
        	        break;
        		case 'i':
        			 System.out.println("��������Ľ��Ϊ��");
        		     binaryTree.inOrderTraverse(binaryTree.getRoot());
        		     break;
        		case 'o':
        			  System.out.println("��������Ľ��Ϊ��");
        		      binaryTree.afterOrderTraverse(binaryTree.getRoot());
        		      break;
        		case 'r':
        			 // ���Զ�������ӡ
          	         System.out.println("��������ӡ���Ϊ��");
        	         List<List<String>> list = binaryTree.printTree(binaryTree.getRoot());
        	         for (List<String> list1 : list) {
        	        	 System.out.println(list1);
        	         }
        	         System.out.print("����ͷ�����Ϊ�գ����Ƿ���� :");
        	         System.out.println(binaryTree.getRoot()==null);
        	         break;
        		case 'f':
        			 // ���Բ�ѯ�ڵ�
        	         BinaryTreeNode node = binaryTree.find(10);
        	         System.out.println(node.data);
        	         BinaryTreeNode node1 = binaryTree.find(31);
        	         System.out.println("node: "+node1);
        	         break;
        		case 'd':
        	        // ����ɾ���ڵ㣺1.ɾ��Ҷ�ӽڵ� 2.ɾ��ֻ��һ�����ӵĽڵ� 3.ɾ��ӵ���������ӵĽڵ�
        	        System.out.println(binaryTree.delete(10));
        	        // ���Զ�������ӡ
        	        binaryTree.inOrderTraverse(binaryTree.getRoot());
        	        break;
        	    default:
        	    	System.out.println("Invalid entry\n");
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
