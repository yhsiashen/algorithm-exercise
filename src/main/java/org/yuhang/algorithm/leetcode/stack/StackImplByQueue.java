package org.yuhang.algorithm.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 用队列实现栈 225
 */
public class StackImplByQueue {

    Queue<Integer> in = new LinkedList<>();
    Queue<Integer> out = new LinkedList<>();

    /** Initialize your data structure here. */
    public StackImplByQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        in.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = in.size();
        for (int i = 0; i < size-1; i++) {
            out.offer(in.poll());
        }
        int res = in.poll(); //找到最后一个元素
        while (!out.isEmpty()){
            in.offer(out.poll());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        int size = in.size();
        for (int i = 0; i < size-1; i++) {
            out.offer(in.poll());
        }
        int res = in.poll();
        while (!out.isEmpty()){
            in.offer(out.poll());
        }
        in.offer(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return in.isEmpty();
    }

    public static void main(String[] args) {
        StackImplByQueue stackImplByQueue = new StackImplByQueue();
        stackImplByQueue.push(1);
        stackImplByQueue.push(2);
        stackImplByQueue.push(3);
        System.out.println(stackImplByQueue.top());
    }
}
