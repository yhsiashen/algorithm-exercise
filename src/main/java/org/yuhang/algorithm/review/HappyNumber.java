package org.yuhang.algorithm.review;

/**
 * 快乐数 LC202
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        fast = squareNum(squareNum(fast));
        slow = squareNum(slow);
        if(fast == 1 || slow == 1) return true;
        while (fast!=slow) {
            fast = squareNum(squareNum(fast));
            slow = squareNum(slow);
            if(slow == 1|| fast == 1) return true;
        }
        return false;

    }

    private int squareNum(int num){
        int res = 0;
        while (num > 0){
            res += (num%10) * (num%10);
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(18));
    }
}
