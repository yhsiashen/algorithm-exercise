package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 删除排序链表中的重复元素II 82
 */
public class ProblemDeleteDuplicatesII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        dummyNode.next = head; //哨兵节点简化编程,将此哨兵节点当做头结点
        ListNode preNode = dummyNode;
        while (preNode!=null && preNode.next!=null){
            ListNode curNode = preNode.next;
            while (curNode.next!=null && curNode.val == curNode.next.val){
                curNode = curNode.next; //找到重复的最后一个节点
            }
            if(curNode!=preNode.next){
                preNode.next = curNode.next;//删除重复元素
            }else{
                preNode = curNode.next;//指向下一个元素
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         head.next = new ListNode(1);
         head.next.next = new ListNode(1);
         head.next.next.next = new ListNode(2);
         head.next.next.next.next = new ListNode(3);
         new ProblemDeleteDuplicatesII().deleteDuplicates(head);
    }


}
