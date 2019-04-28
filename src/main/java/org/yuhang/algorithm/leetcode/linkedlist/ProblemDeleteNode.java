package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 删除链表中的节点 237
 */
public class ProblemDeleteNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 由于node就是要删除的节点，无法取得node之前的节点，故这里可以将此节点的值复制为后一个节点的值，将后一个节点的值删掉
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
         node.val = node.next.val;
         node.next = node.next.next;
    }

}
