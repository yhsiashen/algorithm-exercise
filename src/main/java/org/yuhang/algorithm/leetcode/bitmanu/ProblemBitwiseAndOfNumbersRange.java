package org.yuhang.algorithm.leetcode.bitmanu;


/**
 * 将数字按位与 LC201
 * @tag:位运算
 */
public class ProblemBitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m!=n){
            m >>= 1; //不断循环找到第一个相同的高位
            n >>= 1;
            offset++;
        }
        return m << offset;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemBitwiseAndOfNumbersRange().rangeBitwiseAnd(0,1));
    }
}
