package thread;
/************************
* ����Ķ������ṹΪ��
*  2
* / \
* 1  8
*   / \
*   7 9
*   /
*  4
* / \
* 3 6
*   /
*  5
* **********************/
public  class ThreadTree {
	      TreeNode head;
	      TreeNode root;
	  
	      public void initTBTree() {
	         head = new TreeNode(-1);
	      }
	  
	      public void buildTree(int[] data) {
	          head = null;
	          root = new TreeNode(data[0]);
	          for (int i = 1; i < data.length; i++) {
	              TreeNode tmpNode = root;
	              while (true) {
	                  if (tmpNode.data == data[i])
	                      break;
	                  // С�ڵ��ڸ��ڵ�
	                  if (tmpNode.data > data[i]) {
	                      // �������Ϊ�գ���ѵ�ǰ����Ԫ�ز��뵽���ӽڵ��λ��
	                      if (tmpNode.lchild == null) {
	                          tmpNode.lchild = new TreeNode(data[i]);
	                          break;
	                      }
	                      // �����Ϊ�յĻ���������ӽڵ������͵�ǰ����Ԫ�����Ƚ�
	                      tmpNode = tmpNode.lchild;
	                  } else // ���ڸ��ڵ�
	                  {
	                      // ����Һ���Ϊ�գ���ѵ�ǰ����Ԫ�ز��뵽���ӽڵ��λ��
	                      if (tmpNode.rchild == null) {
	                          tmpNode.rchild = new TreeNode(data[i]);
	                          break;
	                      }
	                      // �����Ϊ�յĻ�������Һ��ӽڵ������͵�ǰ����Ԫ�����Ƚ�
	                      tmpNode = tmpNode.rchild;
	                  }
	              }
	          }
	      }
	  
	      // �������������������������������
	      public void inOrderThreading() {
	          TreeNode current;
	          TreeNode previous;
	  
	          initTBTree();// head�ڵ�ĳ�ʼ��,root�ڵ�Ϊ�û������Ķ�����
	  
	          head.LTag = 0;
	          head.RTag = 1;
	          // ������Ϊ�յ�ʱ��ͷ���ָ���䱾��
	          if (root == null) {
	              head.lchild = head.rchild = head;
	          } else {
	             current = root;
	  
	              head.lchild = current;
	              previous = head;
	              previous = inThreading(current, previous);
	              System.out.println("����������������previousָ���ֵΪ��" + previous.data);
	              previous.RTag = 1;
	              previous.rchild = head;
	              head.rchild = previous;            
	              System.out.println("�������������������һ���ڵ�Ϊ��" + previous.data
	                      + "����Ӧ�ĺ�̽ڵ�Ϊ��" + previous.rchild.data);
	          }
	      }
	  
	      // ǰ����̶��������ͷ����Ҷ�ӽڵ����
	      // ����currentָ��ָ��ǰ���ʵĽڵ㣻previous�ڵ�ָ��ոշ��ʹ��Ľڵ�
	      private TreeNode inThreading(TreeNode current, TreeNode previous) {
	          if (current != null) {
	              TreeNode tmpNode = inThreading(current.lchild, previous);
	              // ǰ������
	              if (current.lchild == null && current.LTag == 0) {
	                  current.LTag = 1;
	                  current.lchild = previous;
	              }
	             previous = tmpNode;
	              // �������
             if (previous.rchild == null && previous.RTag == 0) {
	                 previous.RTag = 1;
	                 previous.rchild = current;
	             }
	 
	             previous = current;// ����previousָ��current��ǰ��
	             previous = inThreading(current.rchild, previous);
	 
	             return previous;
	          	}
	         return previous;
	     }
	 
	     // ���Ҷ������������С�ڵ�:������������ǰ�������
	     public TreeNode getFirstTBTNode(TreeNode node) {
	         if (head != null) {
	             while (node.lchild != head) {
	                 node = node.lchild;
	             }
	         } else {
	             while (node.lchild != null) {
	                 node = node.lchild;
	             }
	         }
	         return node;
	     }
	 
	     // ���Ҷ�������������ڵ�
	     public TreeNode getLastTBTNode(TreeNode node) {
	         if (head == null) {
	             while (node.rchild != null) {
	                 node = node.rchild;
	             }
	         } else {
	             while (node.rchild != head) {
	                 node = node.rchild;
	             }
	         }
	         return node;
	     }
	 
	     // ���ҽڵ��ǰ���ڵ�
	     public TreeNode getPredecessor(TreeNode node) {
	         if (node.lchild != null) {
	             return getLastTBTNode(node.lchild);// �����������ֵ
	         }
	         TreeNode parent = getParent(node);
	         while (parent != null && node == parent.lchild) {// �����ҵ������һ���ڵ㣬�丸�׽ڵ�������������˵�ǰ�ڵ�����丸�׽ڵ�Ϊ��
	             node = parent;
	             parent = getParent(parent);
	         }
	         return parent;
	     }
	 
	     // ���ҽڵ�ĺ�̽ڵ�
	     public TreeNode getSuccessor(TreeNode node) {
	         if (node.rchild != null) {
	             return getFirstTBTNode(node.rchild);// ����������Сֵ
	         }
	         TreeNode parent = getParent(node);
	         if (parent == null)
	             return null;
	         while (parent != null) {
	             if (parent.lchild == node) {
	                 return parent; // Ϊ��������������Ϊ���ڵ�
	             } else {
	                 node = parent; // ����ݹ�
	                 parent = getParent(parent);
	             }
	         }
	         return parent;
	     }
	 
	     // ������׽ڵ㣬�ڶ���ڵ���BSTreeNode��ʱ��û���������׽ڵ㣬��������ר����parent����������׽ڵ㣨��Ҫ�ǲ����޸Ĵ����ˣ����������һ��parent�����ɣ�
	     public TreeNode getParent(TreeNode node) {
	         TreeNode p = root;
	         TreeNode tmp = null;
	         while (p != null && p.data != node.data) {// ����pΪp.data����k.data�Ľڵ㣬tmpΪp�ĸ��׽ڵ�
	             if (p.data > node.data) {
	                 tmp = p;// ��ʱ��Ÿ��׽ڵ�
	                 p = p.lchild;
	             } else {
	                 tmp = p;// ��ʱ��Ÿ��׽ڵ�
	                 p = p.rchild;
	             }
	         }
	         return tmp;
	     }
	 
	     /**
	      * �������ĵݹ����������
	      */
	     public void inOrderReaversal() {
	         TreeNode node;
	         if (head != null) {
	             node = head.lchild; // node��ʾheadͷָ��ָ���root�ڵ�
	             // �������߱������� node==head
	             while (node != head) {
	                 // ����������
	                 while (node.LTag == 0)
	                     node = node.lchild;
	                 System.out.print(node.data + "   ");
	                 while (node.RTag == 1 && node.rchild != head) {
	                     // ����Ҷ�ӽڵ�ĺ��
	                     node = node.rchild;
	                     System.out.print(node.data + "   ");
	                 }
	                 // ������Ҷ�ӽڵ�ĺ�̺󣬷���������
	                 node = node.rchild;
	             }
	         }
	     }
	 
	     /**
	      * δ������������ݹ����������
	      */
	     public void traversalTBTree() {
	         traversalTBTree(root);
	         System.out.println();
	     }
	 
	     private void traversalTBTree(TreeNode node) {
	         if (node != null) {
	             traversalTBTree(node.lchild);
	             System.out.print(node.data + "  ");
	             traversalTBTree(node.rchild);
	         }
	     }
	     public static void main(String[] args) {
	         ThreadTree tbTree = new ThreadTree();
	         /***********************************************************************
	          * ��ʼ������
	          **********************************************************************/
	         int[] data = { 2, 8, 7, 4, 9, 3, 1, 6, 7, 5 }; // { 8, 7, 1, 6, 4, 5,
	                                                         // 10, 3, 2, 9 };
	         tbTree.buildTree(data);
	         System.out.println("########################################");
	         System.out.println("δ����������ǰ������������������:");
	         tbTree.traversalTBTree();
	         System.out.println(tbTree.head == null);
	         System.out.println("δ����������ǰ���������е�һ���ڵ�����һ���ڵ�ֵ�ֱ�Ϊ��"
	                 + tbTree.getFirstTBTNode(tbTree.root).data + "   "
	                 + tbTree.getLastTBTNode(tbTree.root).data);
	 
	         /***********************************************************************
	          * ��������������
	          **********************************************************************/
	         System.out.println("########################################");
	         System.out.println("�������󣬶������������:");
	         tbTree.inOrderThreading();
	         tbTree.inOrderReaversal();
	         System.out.println();
	         System.out.println("��������headͷָ������ӽڵ�ͺ�̽ڵ�ֱ�Ϊ��"
	                 + tbTree.head.lchild.data + "   " + tbTree.head.rchild.data);
	         System.out.println("�������󣬶������е�һ���ڵ�����һ���ڵ�ֵ�ֱ�Ϊ��"
	                 + tbTree.getFirstTBTNode(tbTree.root).data + "   "
	                 + tbTree.getLastTBTNode(tbTree.root).data);
	 
	     }
}
