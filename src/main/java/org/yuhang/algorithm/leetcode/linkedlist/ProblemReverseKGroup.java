package org.yuhang.algorithm.leetcode.linkedlist;


/**
 * k个一组翻转链表  25
 */
public class ProblemReverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 一个区间一个区间的翻转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head; //只有一个节点时直接返回链表
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        while (true) {
            if (rangeCheck(pre.next, k)) { //确保剩余节点的数量 >=k
                ListNode currenNode = pre.next; //开始翻转的节点
                for (int i = 1; i < k; i++) { //每次翻转k个节点做k-1次操作
                    ListNode nextNode = currenNode.next;
                    currenNode.next = nextNode.next;
                    nextNode.next = pre.next;
                    pre.next = nextNode;
                }
                //一个阶段翻转完后
                pre = currenNode;
            } else break; //剩余节点数量<k，则直接返回
        }
        return dummyNode.next;
    }

    private boolean rangeCheck(ListNode node, int k) {
        int length = 0;
        while (node!=null){
            node = node.next;
            length ++;
        }
        return length >= k;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ProblemReverseKGroup().reverseKGroup(head,2);
    }


}
