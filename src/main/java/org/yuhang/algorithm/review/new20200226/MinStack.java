package org.yuhang.algorithm.review.new20200226;

import java.util.Stack;

/**
 * 最小栈(单调栈)
 */
public class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
       stack = new Stack<>();
       minStack = new Stack<>();
    }

    public void push(int val) {
       stack.push(val);
       if(val <= minStack.peek()){//新加入的元素比栈顶元素小，则加入栈
           minStack.push(val);
       }
    }

    public void pop() {
       int val = stack.pop();
       if(val == minStack.peek()){
           minStack.pop();
       }
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
