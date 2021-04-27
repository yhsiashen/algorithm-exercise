package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并K个排序链表
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode list:lists){
            if(list!=null) queue.offer(list);
        }
        while (!queue.isEmpty()){
            ListNode top = queue.poll();
            if(top.next!=null) queue.offer(top.next);
            p.next = top;
            p = p.next;
        }
        return dummy.next;
    }
}
