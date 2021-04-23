package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.ListNode;

/**
 * 链表中倒数第K个节点
 */
public class LastKNode {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k < 1) return null;
        ListNode res = head;
        ListNode cur = head;
        int cnt = 1;
        while (cur!=null){
            if(cnt >= k){
                res = res.next;
            }
            cur = cur.next;
            cnt++;
        }
        return res;
    }

}
