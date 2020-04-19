package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 实现一个LinkedList
 */
public class MyLinkedList {

    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;

    Node tail;

    int size;


    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node cur = head;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(isEmpty()){
            head = new Node(val);
            size++;
            tail = head;
            return;
        }
        Node p = new Node(val);
        p.next = head;
        head = p;
        size++;
    }


    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(isEmpty()){
            head = new Node(val);
            tail = head;
            size++;
            return;
        }
        tail.next = new Node(val);
        tail = tail.next;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index <= 0){
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }
        Node cur = head;
        while (index > 1){
            cur = cur.next;
            index--;
        }
        Node insertNode = new Node(val);
        insertNode.next = cur.next;
        cur.next = insertNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node cur = head;
        while (index > 1){
            cur = cur.next;
            index--;
        }
        Node next = cur.next;
        if(next == tail){//删除的是尾节点
            cur.next = null;
            tail = cur;
        }else{
            cur.next = next.next;
            next.next = null;//help gc
        }

    }

    private boolean isEmpty() {
        return size == 0;
    }
}
