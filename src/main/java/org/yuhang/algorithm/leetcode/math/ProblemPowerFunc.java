package org.yuhang.algorithm.leetcode.math;

/**
 * 实现Pow(x,n)函数 LC50
 */
public class ProblemPowerFunc {


    /**
     * 暴力法 O(n)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 1.0) return 1.0;
        if(x == -1.0) return n % 2==0?1.0:-1.0;
        long N = n;
        double res = 1;
        N = Math.abs(N);//注意整数溢出，故要用long替换int
        while (N > 0){
            res = res*x;
            N--;
        }
        return n>0?res:1/res;
    }

    /**
     * 快速幂算法(递归) O(logn)
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if(n==0) return 1.0;
        long N = n;
        if(N < 0){
            N = -N;
            x = 1/x;
        }
        return fastPow(x,N);
    }

    private double fastPow(double x, long n) {
        if(n == 0) return 1.0;
        double half = fastPow(x, n/2);
        if(half % 2 == 0)
            return half*half;
        else
            return half*half*x;
    }

    /**
     * 快速幂算法(递推) O(logn)
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x,int n){
        double res = 1.0;
        for(int i = n;i!=0;i/=2){
            if(i%2!=0){
                res *= x;
            }
            x *= x;
        }
        return n>0?res:1/res;
    }




    public static void main(String[] args) {
        System.out.println(new ProblemPowerFunc().myPow2(2.00000
               , 101));
    }

}
