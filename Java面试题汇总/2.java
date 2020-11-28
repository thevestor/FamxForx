题目：删除中间结点
实现一种算法，删除单向链表中间的某个结点(即不是第一个或最后一个结点)，假定你只能访问该
结点
输入：单向链表a -> b -> c -> d -> e -> f中的结点c
结果：不反悔任何数据，但该链表变为a -> b -> c -> d -> e -> f
class Solution{
    public void deleteNode(ListNode node){
        int val;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}