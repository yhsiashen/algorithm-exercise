package org.yuhang.algorithm.leetcode.queue;


/**
 * 链表实现头尾相连(链表实现没必要头尾相连！)的队列
 */
public class LinkedDeque {

    /** Node definition */
    public class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
        }
    }

    /** head node */
    private Node head;

    /** tail node */
    private Node tail;

    /** deque capacity */
    private int capacity;

    /** tail node count */
    private int tailCount;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LinkedDeque(int k) {
       this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        // if deque is full ,return false
        if(isFull()){
            return false;
        }

       if(isEmpty()){
           // initialize head node & tail node
           head = new Node(value);
           tail = head;
           tailCount++;
           return true;
       }

       // insert into value between tail and head node
        Node p = tail;
        Node q = head;
        // only one node
        if(p==q){
            // if deque is full ,return false
            p.next = new Node(value);
            head = p.next;
            head.next = tail;
            tailCount++;
            return true;
        }
        // > one node
        Node insertNode = new Node(value);
        insertNode.next = q;
        p.next = insertNode;
        head = insertNode;
        tailCount++;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        // if deque is full ,return false
        if(isFull()){
            return false;
        }

        if(isEmpty()){
            // initialize head node & tail node
            head = new Node(value);
            tail = head;
            tailCount++;
            return true;
        }
        // insert into value between tail and head node
        Node p = tail;
        Node q = head;
        // only one node
        if(p==q){
            p.next = new Node(value);
            tail = tail.next;
            //cicular deque
            tail.next = head;
            tailCount++;
            return true;
        }
        // > one node
        Node insertNode = new Node(value);
        insertNode.next = q;
        p.next = insertNode;

        tail = insertNode;
        tailCount++;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        // if deque is empty ,return false
        if(isEmpty())
            return false;
        if(tailCount==1) {
            head = tail = null;
            tailCount--;
            return true;
        }

        // > one node
        Node p = head;
        Node q = tail;
        q.next = p.next;
        p.next = null;
        head = q.next;
        tailCount--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        // if deque is empty ,return false
        if(isEmpty())
            return false;
        if(tailCount==1) {
            head = tail = null;
            tailCount--;
            return true;
        }
        // > one node
        Node p = head;
        Node q = tail;
        while (p.next!=tail){
            p = p.next;
        }
        p.next = q.next;
        tail = p;
        tailCount--;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return head.data;
    }

    /** Get the last item from the deque. */
    public int getRear() {
         if(isEmpty())
             return -1;
         return tail.data;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return tailCount == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return tailCount == capacity;
    }

    public static void main(String[] args) {
        LinkedDeque linkedDeque = new LinkedDeque(3);
        linkedDeque.insertFront(6);
        linkedDeque.insertFront(7);
        linkedDeque.insertFront(8);
        System.out.println(linkedDeque.insertFront(9));
    }


}
