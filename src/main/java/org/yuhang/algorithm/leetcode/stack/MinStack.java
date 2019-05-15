package org.yuhang.algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 设计一个支持push，pop，top操作，并能在常数时间内检索到最小元素的栈 155
 *
 */
public class MinStack {


    int[] element;
    int size;
    Queue<Integer> queue = new PriorityQueue<>();
    static final int DEFAULT_SIZE = 16;

    /** initialize your data structure here. */
    public MinStack() {
       element = new int[DEFAULT_SIZE];
       size = 0;
    }

    public void push(int x) {
       if(!rangeCheck()){
           grow();
       }
       element[size++] = x;
       queue.offer(x);
    }

    /**
     * 扩容
     */
    private void grow() {
        int oldLength = element.length;
        int newLength = oldLength<<2; //扩充为原来的2倍
        element =  Arrays.copyOf(element,newLength); //数据搬移
    }

    private boolean rangeCheck() {
        return size<element.length;
    }

    public void pop() {
       if(isEmpty()){
           return;
       }
       size--;
       queue.remove(element[size]);
    }

    public int top() {
       if(isEmpty()){
           throw new RuntimeException("stack is empty");
       }
        return element[size-1];
    }

    public int getMin() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
//        MinStack minStackImpl = new MinStack();
//        minStackImpl.push(-1);
////        minStackImpl.push(0);
////        minStackImpl.push(-3);
//        System.out.println(minStackImpl.top());
////        minStackImpl.pop();
////        System.out.println(minStackImpl.top());
//        System.out.println(minStackImpl.getMin());

    }
}
