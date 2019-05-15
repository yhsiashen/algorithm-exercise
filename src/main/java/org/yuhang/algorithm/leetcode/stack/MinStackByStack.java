package org.yuhang.algorithm.leetcode.stack;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 双栈或 栈+优先队列实现
 */
public class MinStackByStack {

    Stack<Integer> stack = new Stack();
    Queue<Integer> queue = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MinStackByStack() {

    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
       int x = stack.peek();
       queue.remove(x);
       stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return queue.peek();
    }
}
