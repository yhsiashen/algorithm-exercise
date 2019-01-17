package org.yuhang.algorithm.rowtooffer;

import java.util.ArrayList;

/** 从尾到头打印链表节点的值
 * Created by yuhang on 2018/3/25.
 */
public class Problem3 {

    //定义节点
    class ListNode{
        int val;
        ListNode next =null;
        ListNode(int val){
            this.val = val;
        }
    }
    //根节点
    public ListNode root;

    //链表尾部插入节点
     void insertNode(int val){
        if(root == null){
            root = new ListNode(val);
        }else {
            ListNode current = root;
            while (true) {
                if (current.next == null) {
                    current.next = new ListNode(val);
                    break;
                } else {
                    current = current.next;
                }
            }
        }
    }

    //遍历链表 尾->头
    void printNode(ListNode listNode,ArrayList<Integer> list){
        if(listNode == null){
            return;
        }
        if(listNode.next!=null){
            printNode(listNode.next,list);
        }
        list.add(listNode.val);
    }
    //遍历链表 头->尾
    void printNodeReverse(ListNode listNode){
        System.out.println(listNode.val);
        if(listNode.next!=null){
            printNodeReverse(listNode.next);
        }
    }

    //反向打印链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        printNode(listNode,list);
        return list;
    }


    public static void main(String[] args) {
        Problem3 p = new Problem3();
        p.insertNode(2);
        p.insertNode(3);
        p.insertNode(5);
        p.insertNode(1);
        p.insertNode(0);
        p.printNodeReverse(p.root);
    }



}
