package org.yuhang.algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 求最大矩形面积 LC85
 */
public class ProblemMaximalrectangle {

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length ==0 || matrix[0].length == 0) return 0;
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == '1'){//计算每行的"矩形高度",然后代如计算连续矩阵的算法中
                    heights[col] += 1;
                }else{
                    heights[col] = 0;
                }
            }
            max = Math.max(max, calrow(heights));
        }
        return max;
    }


    /**
     * 计算连续矩阵的最大面积和
     * @param heights
     * @return
     */
    private int calrow(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] h = Arrays.copyOf(heights,heights.length+1);
        int i = 0;
        while (i < h.length){
            if(stack.isEmpty() || h[stack.peek()]< h[i]){//比栈顶元素还大的元素进入栈，即栈为单调递增栈
                stack.push(i++);//存放数组的索引位
            }else{
                int topIndex = stack.pop();
                max = Math.max(max, h[topIndex] * (stack.isEmpty()?i:i-stack.peek()-1));
            }
        }

        return max;
    }


}
