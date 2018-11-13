package org.yuhang.algorithm.leetcode.LinkedList;

/**
 * 将存放在链表中的两数相加
 * Created by chinalife on 2018/11/12.
 */
public class ProblemAddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //反转两链表
        l1=reserveList(l1);
        l2=reserveList(l2);
        //结果链表
        ListNode resultNode = null;
        //顺序遍历两链表,将所有位数取出,构成数字
        int suml1 = 0;
        int suml2 = 0;
        while (l1 != null) {
            suml1 = suml1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            suml2 = suml2 * 10 + l2.val;
            l2 = l2.next;
        }
        int sum = suml1 + suml2;
        ListNode head = null;
        if(sum == 0)
            return new ListNode(0);
        //将sum结果存入链表中
        while (sum>0){
            if(resultNode==null){
                resultNode = new ListNode(sum%10);
                 head = resultNode;
                sum/=10;
            }else {
                resultNode.next = new ListNode(sum%10);
                resultNode = resultNode.next;
                sum/=10;
            }
        }

        return head;
    }

    //链表反转
    public ListNode reserveList(ListNode list) {
        ListNode currentList = list;
        ListNode preNode = null;
        ListNode nextNode;
        while (currentList != null) {
            nextNode = currentList.next;
            //链表反转即将前驱节点作为后置节点
            currentList.next = preNode;
            preNode = currentList;
            currentList = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new ProblemAddTwoNumbers().addTwoNumbers(l1,l2);
    }
}
