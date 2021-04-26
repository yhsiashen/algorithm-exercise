package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.ListNode;

/**
 * 反转链表II
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseLinkedListII {

    /**
     * left和right表示节点位置
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode p = dummy;
         ListNode before = null;//反转部分之前的最后一个链表节点
         ListNode after = null;//反转部分之后的链表头结点
         for (int i = 0; i <= right; i++) {
            if(i == left-1){
                before = p;
            }
            if(i == right){
                after = p.next;
            }
            p = p.next;
         }
         p = before.next;//要翻转部分的当前节点
         ListNode tail = p;//要翻转的链表头部，翻转后变成链表尾部
         ListNode pre = null;
         while (p!=after){
             ListNode next = p.next;
             if(next!=null && next.val == right){
                 after = next.next;
             }
             p.next = pre;
             pre = p;
             p = next;
         }
         before.next = pre;
         tail.next = after;
         return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//pre为left位置前的那个节点
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;

        for (int i = left; i < right; i++) {//将left~right的链表反转
           ListNode next= cur.next;
           cur.next = next.next;
           next.next = pre.next;
           pre.next = next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReverseLinkedListII().reverseBetween(head, 2,4);

    }
}
