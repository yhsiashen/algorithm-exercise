package org.yuhang.algorithm.leetcode.queue;

import java.util.Stack;

/**
 * 用栈实现队列 232
 */
public class MyQueue {

    Stack<Integer> in = new Stack();
    Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()){
            throw new RuntimeException("queue is empty!");
        }
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
            return out.pop();
        }else{
            return out.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            throw new RuntimeException("queue is empty!");
        }
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
            return out.peek();
        }else{
            return out.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return in.isEmpty() && out.isEmpty();
    }
}
