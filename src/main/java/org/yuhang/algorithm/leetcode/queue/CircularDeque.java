package org.yuhang.algorithm.leetcode.queue;


/**
 * 循环队列实现--用数组实现且不用数据搬移
 */
public class CircularDeque {

     /** 元素数组 */
     private int[]  element;
     /** 队列容量 */
     private int capacity;
     /** 队列头指针 */
     private int head;
     /** 队列尾指针 */
     private int tail;
     /** 默认队列容量 */
    private static int DEFAULT_CAPACITY = 10;

     public CircularDeque(){
         this.element = new int[DEFAULT_CAPACITY];
         this.capacity = DEFAULT_CAPACITY;
     }

     public CircularDeque(int capacity){
         this.capacity = capacity;
         this.element = new int[capacity];
     }

    /**
     * 队尾加元素
     * @param val
     */
     public boolean add(int val){
        if(isFull())
            return false;

        element[tail] =val;
        tail=(tail+1)%capacity;
        return true;
     }

     /**
     * 队头出队列
     */
     public int remove(){
         if(isEmpty())
             throw new ArrayIndexOutOfBoundsException("deque is empty");
         int val = element[head];
         head =  (head+1)%capacity;
         return val;
     }

    /**
     * 判断队列是否为空
     */
     public boolean isEmpty(){
         return head == tail;
     }

    /**
     * 判断队列是否满了
     */
     public boolean isFull(){
        return (tail+1)%capacity==head;
     }
}
