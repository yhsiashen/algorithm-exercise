package org.yuhang.algorithm.review;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthNodeFromLinkedList {


     // Definition for singly-linked list.
      public class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
      }


    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0);//虚拟节点
         dummy.next = head;
         ListNode preNode = dummy;
         ListNode p = dummy;
         int cnt = 0;
         while (p.next!=null){
             if(cnt >= n){
                 preNode = preNode.next;
             }
             p = p.next;
             cnt++;
         }

         ListNode delNode = preNode.next;
         preNode.next = delNode.next;
         delNode.next = null;
         return dummy.next;
    }


}
