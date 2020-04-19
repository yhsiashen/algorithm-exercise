package org.yuhang.algorithm.review;

/**
 * K个一组翻转链表 LC25
 */
public class ReverseNodesInKgroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p!=null){
           ListNode cur = p.next;
           ListNode first = cur;
           ListNode pre = null;

           for (int i = 0; i < k; i++) {//检测剩余的节点是否有k个
               if(cur == null) return dummy.next;
               cur = cur.next;
           }
           cur = first;
           for (int i = 0; i < k; i++) {//反转k个节点
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                if(i == k-1) first.next= cur;
           }
           p.next = pre;
           p = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReverseNodesInKgroup().reverseKGroup(head,2);
    }
}
