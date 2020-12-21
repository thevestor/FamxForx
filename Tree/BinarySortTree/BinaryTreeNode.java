package BinarySortTree;

public class BinaryTreeNode {
	// ������
    public long data;
    // ������
    public String sData;
    // ���ӽڵ�
    public BinaryTreeNode leftChild;
    // ���ӽڵ�
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(long data) {
        this.data = data;
    }

    public BinaryTreeNode(long data, String sData) {
        this.data = data;
        this.sData = sData;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getsData() {
        return sData;
    }

    public void setsData(String sData) {
        this.sData = sData;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * �ж��Ƿ�����ڵ�
     *
     * @return boolean
     */
    public boolean hasLeftNode() {
        return this.leftChild != null;
    }

    /**
     * �ж��Ƿ����ҽڵ�
     *
     * @return boolean
     */
    public boolean hasRightNode() {
        return this.rightChild != null;
    }
}
