package org.yuhang.algorithm.leetcode.tire;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中l两个数的最大异或值 LC421
 */
public class ProblemMaximumXorFfTwoNumbersInArray {

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            // 注意点1：注意保留前缀的方法，mask 是这样得来的
            // 用异或也是可以的 mask = mask ^ (1 << i);
            mask = mask | (1 << i);

            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 注意点2：这里使用 & ，保留前缀的意思（从高位到低位）
                set.add(num & mask);
            }

            // 这里先假定第 n 位为 1 ，前 n-1 位 res 为之前迭代求得
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemMaximumXorFfTwoNumbersInArray().findMaximumXOR(new  int[]{3, 10, 5, 25, 2, 8}));
    }


}
