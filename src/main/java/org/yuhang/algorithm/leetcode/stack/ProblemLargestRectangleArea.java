package org.yuhang.algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 求柱状图中的最大矩形 84
 */
public class ProblemLargestRectangleArea {

    /**
     * 暴力法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            int maxArea = Integer.MIN_VALUE;
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (i - j + 1) * minHeight);
            }
            max = Math.max(maxArea, max);
        }
        return max;
    }

    /**
     * 单调递增栈,用一个栈保存一个单调递增的序列，遇到减的元素则弹出栈顶元素计算一次面积大小
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new ProblemLargestRectangleArea().largestRectangleArea2(heights));
    }
}
