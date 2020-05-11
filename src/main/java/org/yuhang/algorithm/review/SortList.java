package org.yuhang.algorithm.review;

/**
 * 排序链表 LC148
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head== null || head.next==null) return head;
        return mergeList(head);
    }

    private ListNode mergeList(ListNode head) {
        if(head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = slow;
        while (fast!=null && fast.next!=null){//找中间节点mid
            mid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        mid.next = null;
        ListNode left = mergeList(head);
        ListNode right = mergeList(slow);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;//此处的dummy
        ListNode p = left;
        ListNode q = right;
        while (p!=null && q!=null){
            if(p.val < q.val){
                r.next = p;
                r = r.next;
                p = p.next;
            }else{
                r.next = q;
                r = r.next;
                q = q.next;
            }
        }
        if (p!=null){
            r.next = p;
        }
        if(q!=null){
            r.next = q;
        }

        return dummy.next;

    }
}
