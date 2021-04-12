package org.yuhang.algorithm.review.new20200226;

/**
 * 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {


     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
         if(head == null) return null;
         ListNode cur = null;//代表反转后的头指针
         while (head!=null){
             ListNode next = head.next;
             head.next = cur;
             cur = head;
             head = next;
         }

         return cur;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null|| head.next==null) return head;
        ListNode result = reverseList(head.next);//反转了head.next链表
        head.next.next = head;
        head.next = null;
        return result;
    }

    /**
     * 递归2
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode head){
        if(head == null) return pre;
        ListNode next = head.next;
        head.next = pre;
        return reverse(head, next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode reverse = new ReverseLinkedList().reverseList2(head);
        System.out.println(reverse);

    }


}
