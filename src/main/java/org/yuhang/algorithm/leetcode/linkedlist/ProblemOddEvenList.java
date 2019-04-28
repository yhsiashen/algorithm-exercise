package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 将链表奇偶节点排在一起，保持相对位置不变，时间复杂度要求O(n)，空间复杂度要求O(1) 328
 * 双指针法!!!
 */
public class ProblemOddEvenList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
      if(head == null || head.next == null) return head;
      ListNode odd = head;//奇指针代表排好顺序的最后一个奇节点
      ListNode even = head.next;//偶指针代表排好顺序的最后一个偶节点
      while (odd!=null && even!= null && odd.next!= null && even.next != null){
          ListNode enext = even.next; //奇指针后面的节点(偶节点)
          ListNode onext  = odd.next; //偶指针后面的节点(奇节点)
          odd.next = enext;
          even.next = enext.next;
          enext.next = onext;

          odd = odd.next;
          even = even.next;
      }
      return head;
    }


    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        new ProblemOddEvenList().oddEvenList(list);
    }
}
