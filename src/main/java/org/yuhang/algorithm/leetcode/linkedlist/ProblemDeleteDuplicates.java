package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 删除排序链表中的重复节点 83
 */
public class ProblemDeleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode deleteDuplicates(ListNode head) {
         if(head==null) return null;
         ListNode curNode = head;
         while (curNode.next!=null){
             if(curNode.val == curNode.next.val){
                 curNode.next = curNode.next.next; //比较当前节点和下一节点的值，有重复则跳过
             }else{
                 curNode = curNode.next; //没有重复，则遍历下一个节点
             }
         }

         return head;
    }


}
