package org.yuhang.algorithm.leetcode.math;

/**
 * 数字转罗马数字 LC12
 */
public class ProblemIntegertoRoman {

    public String intToRoman(int num) {
        char[] maps = new char[1001];
        maps[1] = 'I';
        maps[5] = 'V';
        maps[10] = 'X';
        maps[50] = 'L';
        maps[100] = 'C';
        maps[500] = 'D';
        maps[1000] = 'M';
        StringBuilder res = new StringBuilder();
        int level = 1;
        while (num > 0){
            int a = num % 10;
            switch (a){
                case 1:
                    res.append(maps[level]);
                    break;
                case 2:
                    res.append(maps[level]).append(maps[level]);
                    break;
                case 3:
                    res.append(maps[level]).append(maps[level]).append(maps[level]);
                    break;
                case 4:
                    res.append(maps[5*level]).append(maps[level]);
                    break;
                case 5:
                    res.append(maps[5*level]);
                    break;
                case 6:
                    res.append(maps[level]).append(maps[5*level]);
                    break;
                case 7:
                    res.append(maps[level]).append(maps[level]).append(maps[5*level]);
                    break;
                case 8:
                    res.append(maps[level]).append(maps[level]).append(maps[level]).append(maps[5*level]);
                    break;
                case 9:
                    res.append(maps[10*level]).append(maps[level]);
                    break;
            }
            num /= 10;
            level *= 10;

        }
        return res.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new ProblemIntegertoRoman().intToRoman(40));
    }
}
