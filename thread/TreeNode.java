package thread;

public class TreeNode {
	int data;
	int LTag;//0,1
	int RTag;//0,1
	TreeNode lchild;
	TreeNode rchild;
	
	public TreeNode(int data)
	{
		this(data,null,null,0,0);
	}
	
	public TreeNode(int data,TreeNode lchild,TreeNode rchild,int LTag,int RTag) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
		this.LTag = LTag;
		this.RTag = RTag;
	}
	
}
