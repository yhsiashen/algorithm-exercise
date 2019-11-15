package org.yuhang.algorithm.leetcode.math;


/**
 * 判断一个数是不是快乐数 LC202
 */
public class ProblemHappyNumer {

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }while (slow!=fast);

        return slow == 1;
    }

    private int squareSum(int n) {
        int squareSum = 0;
        while (n!=0){
            squareSum += (n%10) * (n%10);
            n = n/10;
        }
        return squareSum;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemHappyNumer().isHappy(19));
    }
}
