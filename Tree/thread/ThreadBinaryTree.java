package thread;

public class ThreadBinaryTree {
	
	ThreadTreeNode root;

    // ������ʱ�洢ǰ���ڵ�
    ThreadTreeNode pre = null;

    // ���ø��ڵ�
    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }

    // ��ȡ���ڵ�
    public ThreadTreeNode getRoot() {
        return root;
    }

    /**
     * ����������
     * ���ӣ�                   3
     * 8         16
     * 27   88
     */
    private void inOrderThreadTree(ThreadTreeNode node) {
        // �����ǰ�ڵ�Ϊ null ��ֱ�ӷ���
        if (node == null) {
            return;
        }
        // ����������
        inOrderThreadTree(node.leftNode);
        // ����ǰ���ڵ�
        // ����ڵ�������Ϊ null
        if (node.leftNode == null) {
            // ����ǰ���ڵ�
            node.leftType = 1;
            node.leftNode = pre;
        }
        // ����ǰ������ָ�룬����ڵ�������Ϊ null
        if (pre != null && pre.rightNode == null) {
            // ���ú�̽ڵ�
            pre.rightType = 1;
            // ��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
            pre.rightNode = node;
        }
        // ÿ����һ���ڵ㣬��ǰ�ڵ����¸��ڵ��ǰ���ڵ�
        pre = node;
        // ����������
        inOrderThreadTree(node.rightNode);
    }

    /**
     * �������������Ӹ��ڵ㿪ʼ
     */
    public void inOrderThreadTree() {
        inOrderThreadTree(root);
    }

    /**
     * �����������������
     */
    public void inOrderTraverse() {
        // ȡ�����ڵ�
        ThreadTreeNode node = root;
        if (root == null) {
            return;
        }
        // �ҳ�����߽��(����߽�� leftType �Ѿ���� 1)��Ȼ�������������һֱ���ұ���
        while (node != null && node.leftType == 0) {
            node = node.leftNode;
        }
        System.out.println("ֵΪ��" + node.value);
        // ������������һֱ���ұ���
        while (node != null) {
            node=node.rightNode;
            if(node!=null){
                System.out.println("ֵΪ��" + node.value);
            }
        }


    }
    public static void main(String[] args) {
        // ����һ����
        ThreadBinaryTree threadTree = new ThreadBinaryTree();
        // ����һ�Ÿ��ڵ�
        ThreadTreeNode root = new ThreadTreeNode(3);
        // ���ø��ڵ�
        threadTree.setRoot(root);

        // ����һ����ڵ�
        ThreadTreeNode left = new ThreadTreeNode(8);
        // ����һ���ҽڵ�
        ThreadTreeNode right = new ThreadTreeNode(16);
        root.setLeftNode(left);
        root.setRightNode(right);

        // Ϊ����ڵ㶼���������������ҽڵ�
        left.setLeftNode(new ThreadTreeNode(27));
        left.setRightNode(new ThreadTreeNode(88));
        // ��������������Ϊ��27 8 88 3 16��
        threadTree.inOrderThreadTree();
//        System.out.println(right.leftType);
//        System.out.println(right.leftNode.value);
        threadTree.inOrderTraverse();

    }
}