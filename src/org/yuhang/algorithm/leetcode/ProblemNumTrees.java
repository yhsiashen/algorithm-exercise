package org.yuhang.algorithm.leetcode;

/** 1,2...n个数可以构造的二叉搜索树的数目
 * Created by chinalife on 2018/10/15.
 */
public class ProblemNumTrees {
    public int numTrees(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        // n个数字可以构造的二叉树数目
        int[] numTrees = new int[n+1];
        numTrees[0] = 1;
        numTrees[1] = 1;
        // i个数字可以构造的二叉树数目为从将0,1..到i作为顶点的左右子树相乘的累加和
        for (int i = 2; i < n+1 ; i++) {
            for (int j = 1; j <= i ; j++) {
                numTrees[i] = numTrees[i] + numTrees[j-1] * numTrees[i-j];
            }
        }
       return  numTrees[n];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemNumTrees().numTrees(3));

    }
}
