package org.yuhang.algorithm.leetcode.math;

/**
 * 整数反转 7
 */
public class ProblemReverseInteger {

    public int reverse(int x) {
       if(x == 0 || x == Integer.MIN_VALUE) return 0;
       int[] radix = new int[10]; //存储每个位的数字
       int count = 0;
       int sign = x < 0? -1:1; //标识符号
       x = (x < 0) ? -x:x; //取x绝对值,若x为最小整数,不能取反,因为取反会超过正整数的最大范围造成溢出
       while (x >= 10){
          radix[count++] = x % 10;
          x = x/10;
       }
       radix[count++] = x;
       int res = 0;
       for (int i = 0; i < count; i++) {
            if( Integer.MAX_VALUE/10 < res){ //判断此次操作是否溢出
                return 0;
            }else if(Integer.MAX_VALUE/10 == res && radix[i] > 7) { //刚好溢出
                return 0;
            }
                res = res*10+radix[i];
       }
       return res*sign;
    }


    public static void main(String[] args) {
        System.out.println(new ProblemReverseInteger().reverse(-2147483647));
    }
}
