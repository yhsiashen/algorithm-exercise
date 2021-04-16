package org.yuhang.algorithm.review.new20200226;

/**
 * 排序链表，要求时间复杂度O(nlogn)，常数时间复杂度
 */
public class SortedList {


     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * 归并排序
     * @param head
     * @return
     */
      public ListNode sortList(ListNode head) {
          if(head==null || head.next == null) return head;
          return mergeSort(head);
      }

      private ListNode mergeSort(ListNode head){
          if(head == null || head.next ==null) return head;
          ListNode fast = head;
          ListNode slow = head;
          ListNode mid = slow;
          while (fast!=null && fast.next!=null){//找中间节点
              mid = slow;
              fast = fast.next.next;
              slow = slow.next;
          }
          ListNode rightHead = mid.next;
          mid.next = null;
          ListNode left =  mergeSort(head);//mid左边有序
          ListNode right = mergeSort(rightHead);//mid右边有序
          return merge(left,right);//合并两个有序链表
      }

      private ListNode merge(ListNode list1,ListNode list2){
          ListNode dummy = new ListNode(-1);
          ListNode p = list1;
          ListNode q = list2;
          ListNode cur = dummy;
          while (p!=null && q!=null){
              if(p.val < q.val){
                  ListNode pnext = p.next;
                  cur.next = p;
                  p = pnext;
              }else{
                  ListNode qnext = q.next;
                  cur.next = q;
                  q = qnext;
              }
              cur = cur.next;
          }

          if(p!=null){
              cur.next = p;
          }
          if(q!=null){
              cur.next = q;
          }
          return dummy.next;
      }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        ListNode res = new SortedList().sortList(head);
        System.out.println(res);
    }

}
