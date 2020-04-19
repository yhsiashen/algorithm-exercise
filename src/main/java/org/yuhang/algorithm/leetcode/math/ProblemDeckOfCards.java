package org.yuhang.algorithm.leetcode.math;

/**
 * 卡牌分组 LC914
 */
public class ProblemDeckOfCards {


    /**
     * 暴力法,O(n^2)
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length == 0|| deck.length ==1 )return false;
        int[] maps = new int[10000];
        for (int value : deck) {
            maps[value]++;
        }
        for (int i = 2; i < 10000; i++) {//从i=2开始判断i是否能被maps中的各个数整除
            int j = 0;
            while (j< maps.length){
                if(maps[j] % i !=0){
                    break;
                }
                j++;
            }
            if(j == maps.length) return true;
        }
        return false;
    }


    /**
     * 最大公约数法，数字出现的的次数两两之间的最大公约数>=2，则可以分组 ,O(nlog10000)
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX1(int[] deck) {
        if(deck.length == 0|| deck.length ==1 )return false;
        int[] maps = new int[10000];
        for (int value : deck) {
            maps[value]++;
        }
        int x = maps[deck[0]];
        for (int i = 0; i < 10000; i++) {
            if(maps[i] == 1) return false;
            if(maps[i] > 1){
                x = gcd(x ,maps[i]);
                if(x == 1) return false;//两两之间的最大公约数不能为1
            }
        }
        return true;
    }

    /**
     * 辗转相除法求最大公约数
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }



    public static void main(String[] args) {
        int[] deck = {1,2,2,3,2,2,2,1};
        System.out.println(new ProblemDeckOfCards().hasGroupsSizeX1(deck));
    }
}
