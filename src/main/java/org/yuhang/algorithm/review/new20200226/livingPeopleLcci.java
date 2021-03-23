package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.Arrays;

/**
 * 生存人数
 */
public class livingPeopleLcci {

    /**
     * 计算范围内每年有多少人存活，选取最大值
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death) {
        int minYear = Integer.MAX_VALUE, maxYear = 0;
        for (int year: birth){
            minYear = year < minYear? year: minYear;
            maxYear = year > maxYear? year: maxYear;
        }

        for (int year: death){
            minYear = year < minYear? year: minYear;
            maxYear = year > maxYear? year: maxYear;
        }

        int[] table = new int[maxYear - minYear+1];
        for (int i = 0; i < birth.length; i++) {
            //遍历每个人的出生年月，记录他在哪个范围内活着
            int start  = birth[i] - minYear;
            int end = death[i] - minYear;
            for (int j = start; j <= end ; j++) {
                table[j]++;
            }
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < table.length; i++) {
            if(table[i] > max){
                max = table[i];
                idx = i;
            }
        }
        return minYear+idx;
    }

    public static void main(String[] args) {
        int[] birth = {1900, 1901, 1950};
        int[] death = {1948, 1951, 2000};
        System.out.println(new livingPeopleLcci().maxAliveYear(birth,death));
    }
}
