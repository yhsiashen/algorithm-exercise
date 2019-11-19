package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数(数组中大于n/3的数字的集合) LC229 要求时间复杂度O(n),空间复杂度O(1)
 *
 */
public class ProblemMajorityElementII {


    /**
     * 投票法:大于n/3的数字最多只能有两个,选定两个候选数字,遍历数组开始投票,遇到相同的数字则票数+1,
     * 遇到不同的数字则看现在是否有票数等于0的候选数字，有的话换候选数字，没有的话则将所有候选数字的票数-1
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA=0;
        int countB=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == candidateA){
                countA++;
                continue;
            }

            if(nums[i] == candidateB){
                countB++;
                continue;
            }

            if(countA==0){
                candidateA = nums[i];
                countA++;
                continue;
            }

            if(countB==0){
                candidateB = nums[i];
                countB++;
                continue;
            }

            countA--;
            countB--;
        }

        int A=0;
        int B=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==candidateA){
                A++;
            }else if(nums[i]==candidateB){
                B++;
            }
        }
        if(A>nums.length/3) res.add(candidateA);
        if(B>nums.length/3) res.add(candidateB);
        return res;
    }

    public static void main(String[] args) {

    }
}
