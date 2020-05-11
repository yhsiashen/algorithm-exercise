package org.yuhang.algorithm.review;

import java.util.Stack;

/**
 * 每日温度 LC739
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length ; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);//存索引
        }

        return res;
    }


    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(new DailyTemperatures().dailyTemperatures(T));
    }
}
