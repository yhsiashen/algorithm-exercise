package org.yuhang.algorithm.leetcode.linkedlist;


import java.util.PriorityQueue;

/**
 * 合并K个有序链表，优先队列(小顶堆) 23
 */
public class ProblemMergeKLists {


    /**
     * 链表定义
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 合并lists中的链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length==0)
            return null;
        //结果链表
        ListNode resultList=  new ListNode(0);
        //结果链表的头链表
        ListNode headResultList = resultList;

        //小顶堆优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.val > o2.val){
                return 1;
            }else if(o1.val == o2.val){
                return 0;
            }else{
                return -1;
            }
        });

        //将lists迭代添加到堆中
        for (ListNode listNode: lists) {
            if(listNode!=null) {
                queue.offer(listNode);
            }
        }
        //不断poll queue中最小的元素加入结果队列
        while (!queue.isEmpty()) {
            //取出最小的头链表
            ListNode minListNode = queue.poll();
            ListNode minListNodeNext = minListNode.next;
            minListNode.next = null;
            headResultList.next = minListNode;
            headResultList = headResultList.next;
            //将值最小的链表的下个节点重新加入堆中
            if(minListNodeNext!=null) {
                queue.offer(minListNodeNext);
            }
        }

        return resultList.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        lists[0] = listNode1;

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        lists[1] = listNode2;

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        lists[2] = listNode3;

        new ProblemMergeKLists().mergeKLists(lists);
    }


}
