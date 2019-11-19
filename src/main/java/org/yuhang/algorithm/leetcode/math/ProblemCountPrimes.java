package org.yuhang.algorithm.leetcode.math;

/**
 * 统计质数 LC204
 */
public class ProblemCountPrimes {

    public int countPrimes(int n) {
      int count = 0;
      boolean[] flag = new boolean[n];
        for (int i = 2; i < n ; i++) {
            if(!flag[i]){
                count++;
                for (int j = i+i; j < n; j+=i) { //遍历i的倍数
                     flag[j] = true; //i的倍数不是质数
                }
            }
        }
      return count;
    }

    public int countPrimes1(int n) {
        int count = 0;
        int[] flag = new int[n/32+1]; //一个bit位代表一个数,n为31以内只需要一个整数，n32~63需要两个整数，以此类推.....
                                      //初始化时默认都为质数,标记为0
        for (int i = 2; i < n ; i++) {
            if((flag[i/32] & (1<<i)) == 0 ){
                count++;
                for (int j = i+i; j < n; j+=i) { //遍历i的倍数
                     flag[j/32] |= 1<< j;//i的倍数不是质数,标记为1
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemCountPrimes().countPrimes1(10));
    }
}
