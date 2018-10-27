package org.yuhang.algorithm.jiketime;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * Created by chinalife on 2018/10/26.
 */
public class ProblemMinStack {


    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    public ProblemMinStack(){
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }


    public int getMin() throws Exception {
        if(minStack.isEmpty())
            throw new Exception("stack is empty");
        return minStack.peek();
    }

    public int pop() throws Exception {
        if(dataStack.isEmpty())
            throw new Exception("stack is empty!");
        int val = dataStack.pop();
        if(val == getMin())
            minStack.pop();
        return val;
    }

    public void push(int val) throws Exception {
         dataStack.push(val);
         if( minStack.isEmpty() || val <= getMin())
               minStack.push(val);
    }


}
