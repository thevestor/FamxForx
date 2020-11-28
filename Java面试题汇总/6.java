最小高度树
题目：给定一个有序证书数组，元素各不相同且按升序
排列，编写一个算法，创建一颗高度最小得二叉搜索树
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0 
         / \ 
       -3   9 
       /   / 
     -10  5 
Code:
class Solution{
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length == 0 )return null;
        TreeNode n = new TreeNode(nums.length);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2 + 1,nums.length));
        return n;
    }
}
