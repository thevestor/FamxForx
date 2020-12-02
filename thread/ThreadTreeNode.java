package thread;

public class ThreadTreeNode {
	// �ڵ��Ȩ
    public int value;
    // ����
    public ThreadTreeNode leftNode;
    // �Һ���
    public ThreadTreeNode rightNode;
    // ���ͱ�־ָ�룺Ĭ��Ϊ 0 �������ӣ�Ϊ 1 ����ǰ���ڵ㡣
    public int leftType;
    // ���ͱ�־ָ�룺Ĭ��Ϊ 0 �����Һ��ӣ�Ϊ 1 �����̽ڵ㡣
    public int rightType;

    public ThreadTreeNode(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ThreadTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ThreadTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}
