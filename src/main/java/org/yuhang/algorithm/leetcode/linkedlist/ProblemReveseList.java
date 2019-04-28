package org.yuhang.algorithm.leetcode.linkedlist;


/**
 * 反转一个单链表 206
 */
public class ProblemReveseList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    /**
     * 迭代法
      * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
         ListNode result = null;
         while (head!=null){
             ListNode next = head.next;
             head.next = result;
             result = head;
             head = next;
         }
       return result;
    }

    /**
     * 递归法 TODO
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if(head == null || head.next ==null) return head;
        ListNode result = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return result;

    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new ProblemReveseList().reverseList(head);

    }


}
