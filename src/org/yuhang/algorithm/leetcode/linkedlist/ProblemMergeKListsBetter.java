package org.yuhang.algorithm.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * 合并K个排序链表 优先队列(小顶堆) 23
 * Created by chinalife on 2018/11/29.
 */
public class ProblemMergeKListsBetter {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class ListNodeFlag {
        int flag;
        ListNode listNode;

        ListNodeFlag(int f, ListNode l) {
            flag = f;
            listNode = l;

        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode result = new ListNode(1);
        //头指针
        ListNode head = result;
        //小顶堆优先队列
        PriorityQueue<ListNodeFlag> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.listNode.val > o2.listNode.val) {
                return 1;
            } else if (o1.listNode.val == o2.listNode.val) {
                return 0;
            } else {
                return -1;
            }
        });

        // 遍历lists,将各链表的第一个节点放入优先队列
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                priorityQueue.add(new ListNodeFlag(i, lists[i]));
        }
        //队列不为空，则每次取出队列头的元素加入result中
        while (!priorityQueue.isEmpty()) {
            ListNodeFlag nextNode = priorityQueue.poll();
//        result.next = nextNode.listNode;
            int curFlag = nextNode.flag;
            //若取出的节点不为空，则将其加入到result结果中
            if (lists[curFlag] != null) {
                head.next = lists[curFlag];
                head = head.next;
                lists[curFlag] = lists[curFlag].next;
                if (lists[curFlag] != null) {
                    priorityQueue.add(new ListNodeFlag(curFlag, lists[curFlag]));
                }
            }
        }
        return result.next;
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

        ListNode[] listst = new ListNode[2];

        new ProblemMergeKListsBetter().mergeKLists(listst);


    }
}
