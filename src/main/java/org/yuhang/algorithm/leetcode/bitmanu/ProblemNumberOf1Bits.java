package org.yuhang.algorithm.leetcode.bitmanu;


/**
 * 数字n的二进制中bit为1的个数  LC191
 * @tag:位运算
 */
public class ProblemNumberOf1Bits {


    /**
     * 将n依次与掩码1,2,4,8,16,32....相与,不得0即表示该位置为1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
      int count = 0;
      int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((mask & n)!=0){
                count++;
            }
            mask <<=1;
        }
      return count;
    }

    /**
     * 将n与(n-1)相与,每次会消除n中最后一个bit 1,直到n为0
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemNumberOf1Bits().hammingWeight(2394));
    }
}
