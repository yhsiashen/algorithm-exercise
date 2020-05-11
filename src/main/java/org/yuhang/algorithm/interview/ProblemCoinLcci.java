package org.yuhang.algorithm.interview;

/**
 * 硬币
 */
public class ProblemCoinLcci {

    int[] coins = {25,10,5,1};

    public int waysToChange(int n) {
       if(n < 1) return 0;
       int[] ways = new int[n+1];//ways[i]表示i分钱具有多少种兑换方法
       ways[0] = 1;
       for(int coin: coins){
           for (int i = coin; i <=n ; i++) {
               ways[i] = (ways[i]+ways[i-coin])%1000000007;
           }

       }
       return ways[n];
    }


}
