package org.yuhang.algorithm.rowtooffer;


import org.yuhang.algorithm.rowtooffer.Problem14.ListNode;

import java.util.Stack;

/** 反转链表
 * Created by chinalife on 2018/5/9.
 */
public class Problem15 {

    private ListNode ReverseList(ListNode head) {
        try {
            if (head == null) {
                return null;
            }
            Stack<Integer> stack = new Stack<Integer>();
            while (true) {
                stack.push(head.data);
                //对null变量操作会出现空指针异常
                if (head.next == null) {
                    break;
                }
                head = head.next;
            }
            ListNode root = null;
            if (!stack.isEmpty()) {
                root = new ListNode(stack.pop());
            }
            while (!stack.isEmpty()) {
                insertNode(root, stack.pop());
            }
            return root;
        }catch(Exception e){
            System.out.println("1111");
            e.printStackTrace();
        }
        return null;

    }


    private void insertNode(ListNode listNode, int i) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(i);
    }

    public static void main(String[] args) {
        Problem15 p = new Problem15();
        ListNode head = new ListNode(1);
//        p.insertNode(head, 2);
//        p.insertNode(head, 3);
//        p.insertNode(head, 4);
//        p.insertNode(head, 5);
        p.ReverseList(head);

    }
}
