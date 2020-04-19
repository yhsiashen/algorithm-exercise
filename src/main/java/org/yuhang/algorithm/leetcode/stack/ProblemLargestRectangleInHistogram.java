package org.yuhang.algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 柱状图中的最大矩形 LC84
 */
public class ProblemLargestRectangleInHistogram {


    /**
     * 单调栈,从头开始遍历数组，当遇到比栈顶元素小的元素时，把栈顶元素弹出来计算面积(因为后面不需要此元素了)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int i = 0;
        int[] h = Arrays.copyOf(heights,heights.length+1);
        while (i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else{
                int t = stack.pop();
                res = Math.max(res, h[t] * (stack.isEmpty()?i:i-stack.peek()-1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height  = {2,1,5,6,2,3};
        System.out.println(new ProblemLargestRectangleInHistogram().largestRectangleArea(height));
    }
}
