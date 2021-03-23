package org.yuhang.algorithm.review.new20200226;

/**
 * 08.11 硬币
 */
public class CoinLcci {

    public int waysToChange(int n) {
         if(n == 0) return 0;
         int[] coins = {1,5,10,25};
         int[] ways = new int[n+1];
         ways[0] = 1;
         for(int coin:coins){
             for (int i = coin; i < n+1; i++) {
                 ways[i] = (ways[i]+ways[i-coin]) % 1000000007;
             }
         }
         return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(new CoinLcci().waysToChange(10));
    }
}
