package org.yuhang.algorithm.leetcode.queue;

import java.util.*;

/**
 * 队列的最大值
 */
public class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> help;//单调递减队列存最大值

    public MaxQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!help.isEmpty() && value > help.peekLast()) {//保证在help队列队头的为最大值
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if(help.peek() == val) {
            help.pop();
        }
        return val;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(16);
        maxQueue.push_back(9);
        maxQueue.push_back(94);
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();

    }


}
