package org.yuhang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 每日温度 LC739
 */
public class ProblemDailyTemperatures {


    public int[] dailyTemperatures(int[] T){
        int[] res= new int[T.length];
        res[T.length-1] = 0;
        for (int i = T.length-2; i >=0 ; i--) {//从右向左遍历
            for (int j = i+1; j < T.length ; j+=res[j]) {
                if(T[j] > T[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 栈
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T){
       int[] res = new int[T.length];
       Stack<Integer> stack = new Stack<>();//栈保存一个单调递增的索引序列，栈顶为最小元素的索引
        for (int i = T.length-1; i >= 0 ; i--) {
            int j = i;
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                j = stack.peek();
            }

            res[i] = j-i;
            stack.push(i);
        }
        return res;
    }
}
