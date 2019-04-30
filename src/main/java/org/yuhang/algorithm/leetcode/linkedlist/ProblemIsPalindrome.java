package org.yuhang.algorithm.leetcode.linkedlist;


import java.util.Stack;

/**
 * 判断一个链表是否为回文链表 234
 */
public class ProblemIsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 用栈，时间复杂度O(n) 空间复杂度O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
         if(head==null) return true;
         ListNode p =head;
         Stack<Integer> stack = new Stack<>();
         while (p!=null){
             stack.push(p.val);
             p = p.next;
         }

         while (!stack.isEmpty()){
             if(head.val != stack.pop()) return false;
             head = head.next;
         }
         return true;
    }


    /**
     * 用快慢指针先找到中间节点，然后翻转后半部分后与前半部分比较
     * 时间复杂度O(n)，空间复杂度O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head){
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){ //快慢指针找到中间节点
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode q = reverseList(slow.next); //将后部分节点翻转
        while (q!=null){
            if(q.val != head.val) return false;
            q= q.next;
            head= head.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode list) {
        if(list == null) return null;
        ListNode result = null;
        ListNode cur = list;
        while (cur!=null){
            ListNode nextNode = cur.next;
            cur.next = result;
            result = cur;
            cur = nextNode;
        }
        return result;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        new ProblemIsPalindrome().isPalindrome(head);
    }
}
