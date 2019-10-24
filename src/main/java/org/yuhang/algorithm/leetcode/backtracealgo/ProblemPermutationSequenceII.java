package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.ArrayList;
import java.util.List;


/**
 * 找到第K个排列 LC60
 * 回溯+剪枝
 * @tag:回溯算法
 */
public class ProblemPermutationSequenceII {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre);
    }


    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String c : pre) {
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial(n - 1 - depth); //算出下一区间的阶乘(即总共有多少个排列)
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (ps < k) { //确定不在i开头的区间,直接剪枝
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre);
        }
        return null;
    }


    private int factorial(int n) {
        // 这种编码方式包括了 0 的阶乘是 1 这种情况
        int res = 1;
        while (n > 0) {
            res *= n;
            n -= 1;
        }
        return res;
    }
}
