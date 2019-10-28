package org.yuhang.algorithm.leetcode.array;

/**
 *  将数组加1 LC66
 */
public class ProblemPlusOne {

    public int[] plusOne(int[] digits) {
       int num = digits.length-1; //从个位开始判断
       while (num >=0 && digits[num] == 9){
          digits[num] = 0;
          num--;
       }
       if(num > -1){
           digits[num] = digits[num] + 1;
       }else{ // 做数据搬移
           int[] res = new int[digits.length + 1];
           System.arraycopy(digits,0,res,1,digits.length);
           res[0] = 1;
           return res;
       }

       return digits;
    }

    public static void main(String[] args) {
        int[] digits = {0};
        new ProblemPlusOne().plusOne(digits);

    }
}
