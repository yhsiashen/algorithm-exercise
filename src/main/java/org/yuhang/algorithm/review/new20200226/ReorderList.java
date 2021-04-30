package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.ListNode;

/**
 * 重排链表
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    /**
     * 拆分成两个链表，右边链表反转，再将两个链表合并
     * @param head
     */
    public void reorderList(ListNode head) {
         if(head == null || head.next == null || head.next.next == null) return;
         ListNode fast = head;
         ListNode slow = head;
         while (fast.next !=null && fast.next.next!=null) {//O(n)
             fast = fast.next.next;
             slow = slow.next;

         }
         ListNode left = head;
         ListNode right = slow.next;
         slow.next = null;
         right = reverseList(right);// O(n)
         while (right!=null){ // O(n)
             ListNode next =  right.next;
             right.next = left.next;
             left.next = right;
             left = left.next.next;
             right = next;
         }

    }

    private ListNode reverseList(ListNode list){
        ListNode pre = null;
        ListNode cur = list;
        while (cur!=null){
            ListNode next=  cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(head);
    }
}
