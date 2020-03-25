package org.yuhang.algorithm.interview;

/**
 * 找出只出现一次的两个数字
 */
public class ProblemFindSingleNumbers {

    public int[] singleNumbers(int[] nums) {
         if(nums.length == 0) return new int[]{};
         int x = 0;
         for (int num:nums) x ^= num;//异或所有数字，最后得到一个数，这个数即为两个数字异或得来，如果这个数字的某一位为1，则两个数字的这位一定分别为0和1
         int low1 = x & -x; //取x最低位的1，其他位都为0的数做掩码
         int a=0,b=0;
         for(int num:nums){//遍历数组将数与掩码做与运算，这两个不一样的数字肯定被分到a,b两组
             if((num & low1) == 0){
                 a ^= num;
             }else{
                 b ^= num;
             }
         }

         return new int[]{a,b};
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-2));
    }
}
