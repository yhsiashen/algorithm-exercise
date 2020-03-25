package org.yuhang.algorithm.interview;

/**
 * 剪绳子II
 */
public class ProblemCuttingRopeII {

    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;//防止运算过程中的(还未来得及取模之前)的整数溢出
        while(n > 4){
            res *= 3;
            res = res % 1000000007;//对每一步结果取模防止溢出
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new ProblemCuttingRopeII().cuttingRope(80));
    }
}
