package org.yuhang.algorithm.leetcode.stack;


import java.util.Stack;

/**
 * 接雨水 LC42
 */
public class ProblemTrapWater {


    /**
     * 动态规划，计算每列左右边的最大高度，然后按列计算每列存储的水
     * @param height
     * @return
     */
    public int trap(int[] height){
        int n = height.length;
        int res=0;
        if(n == 0) return 0;
        int[] max_left = new int[n]; //max_left[i]表示i索引左边的最大高度
        int[] max_right = new int[n]; //max_right[i]表示i索引右边的最大高度
        max_left[0] = 0;
        max_right[n-1] = 0;
        for (int i = 1; i < n-1 ; i++) {
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }
        for (int i = n-2; i >= 0 ; i--) {
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        for (int i = 0; i < n ; i++) {
            int min = Math.min(max_left[i],max_right[i]);
            if(height[i] < min){
                res+=min-height[i];
            }
        }
        return res;
    }

    /**
     * 双指针减少动态规划需要的空间
     * @param height
     * @return
     */
    public int trap1(int[] height){
        int n = height.length;
        int res=0;
        if(n == 0) return 0;
        int max_left = 0;
        int[] max_right = new int[n]; //max_right[i]表示i索引右边的最大高度
        max_right[n-1] = 0;
        for (int i = n-2; i >= 0 ; i--) {
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        for (int i = 1; i < n-1 ; i++) {
            max_left = Math.max(max_left,height[i-1]); //max_left在遍历中维护最大值
            int min = Math.min(max_left,max_right[i]);
            if(height[i] < min){
                res+=min-height[i];
            }
        }
        return res;
    }


    /**
     * 用栈保存墙高度的状态，在每次遇到高墙(>栈顶墙高)时计算一次雨水的容量，完毕之后将高墙压入栈中
     * @param height
     * @return
     */
    public int trap2(int[] height){
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int current = 0;
        while (current < height.length){
            while (!stack.isEmpty() && height[stack.peek()] < height[current]){
               int h = height[stack.pop()];
               if(stack.isEmpty()) break;
               int distance = current - stack.peek()-1;
               int min = Math.min(height[stack.peek()],height[current]);
               res += distance*(min-h);
            }
            stack.push(current);
            current++;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemTrapWater().trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
