package org.yuhang.algorithm.review.new20200226;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
       stack1 = new Stack<>();
       stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
       stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(empty()){
           throw new RuntimeException("queue is empty");
       }
       int res = 0;
       while (!stack1.isEmpty()){
           if(stack1.size() == 1){
               res = stack1.pop();
           }else{
               stack2.push(stack1.pop());
           }
       }
       while (!stack2.isEmpty()){
           stack1.push(stack2.pop());
       }
       return res;
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            throw new RuntimeException("queue is empty");
        }
        int res = 0;
        while (!stack1.isEmpty()){
            if(stack1.size() == 1){
                res = stack1.pop();
                stack2.push(res);
            }else{
                stack2.push(stack1.pop());
            }
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;


    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return stack1.isEmpty();
    }
}
