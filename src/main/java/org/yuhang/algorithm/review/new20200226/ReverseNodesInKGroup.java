package org.yuhang.algorithm.review.new20200226;

/**
 * K个一组翻转链表
 * 输入：head = [1,2,3,4,5], k = 2
 *        输出：[2,1,4,3,5]
 *
 * 输入：head = [1,2,3,4,5], k = 3
 *        输出：[3,2,1,4,5]
 */
public class ReverseNodesInKGroup {


     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode reverseKGroup(ListNode head, int k) {
          if(head == null)return null;
          ListNode dummy = new ListNode();//虚拟节点
          dummy.next = head;
          ListNode p = dummy;//表示上一轮翻转后的尾结点，初始值为dummy
          while (p!=null){
              ListNode cur =  p.next;
              ListNode first =  cur;//保存此轮k个链表的头结点
              ListNode pre = null;

              //检查剩余的链表节点是否有k个
              for (int i = 0; i < k; i++) {
                  if(cur == null) return dummy.next;
                  cur = cur.next;
              }
              cur = first;
              //翻转k个链表节点
              for (int i = 0; i < k; i++) {
                  ListNode next = cur.next;
                  cur.next = pre;
                  pre = cur;
                  cur = next;
                  if(i == k-1) first.next = next;//第k个节点时，将反转前的头结点，也就是反转后的尾结点指向下个的头结点
              }
              p.next = pre;//前一轮的尾结点指向该轮的头结点
              p = first;//
          }
          return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        new ReverseNodesInKGroup().reverseKGroup(head, 3);

    }
}
