package org.yuhang.algorithm.review;

import java.util.Stack;

/**
 * 接雨水 LC42
 */
public class TrappingRainWater {


    public int trap(int[] height) {
        if(height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length;i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {//若高度大于栈顶元素，则不断弹出栈顶元素并计算接雨水的面积
                   int top = stack.pop();
                   if(!stack.isEmpty()){
                       int h = Math.min(height[i], height[stack.peek()]) - height[top];
                       int w = i - stack.peek() - 1;
                       res += h*w;
                   }
              }
            stack.push(i);
        }

        return res;
    }

}
