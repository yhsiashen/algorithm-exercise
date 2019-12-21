package org.yuhang.algorithm.leetcode.math;

/**
 * excel表列名 LC168
 */
public class ProblemExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemExcelSheetColumnTitle().convertToTitle(701));
    }
}
