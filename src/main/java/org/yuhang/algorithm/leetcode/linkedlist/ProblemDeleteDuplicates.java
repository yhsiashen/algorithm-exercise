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
         if(head == null) return null;
         ListNode dummyNode = new ListNode(0);
         dummyNode.next = head; //哨兵节点简化编程
         int used = Integer.MAX_VALUE;
         ListNode cur = head;
         while (cur!=null){
             if(cur.val==used){ //找到重复的则删除
                 dummyNode.next = dummyNode.next.next;
                 cur = dummyNode.next;
                 continue; //直接continue考察cur节点
             }
             used = cur.val;
             cur = cur.next;
             dummyNode = dummyNode.next;
         }
         return head;
    }


}
