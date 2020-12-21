package SeqTree;

public class treeNode {
    private int iData; //data item(key)
    private double dData; // data item
    private treeNode leftChild; // this node`s left child
    private treeNode rightChild; //this node`s right child
    public void displayNode(){ //display ourself
        System.out.println('{');
        System.out.println(iData);
        System.out.println(',');
        System.out.println(dData);
        System.out.println('}');
    }
}
