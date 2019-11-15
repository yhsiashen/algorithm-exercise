package org.yuhang.algorithm.leetcode.array;


import java.util.Arrays;

/**
 * 最大数 LC179
 */
public class ProblemLargestNumber {

    public String largestNumber(int[] nums) {

        if(nums.length == 0) return null;
        Integer[] ns = new Integer[nums.length];//类型转换
        for (int i = 0; i < nums.length; i++) {
            ns[i] = nums[i];
        }

        //将数组按元素的首个数字大小由大到小排序
        Arrays.sort(ns, (o1, o2) -> {
            String s1 = Integer.toString(o1);
            String s2 = Integer.toString(o2);
            String r1 = s1+s2;
            String r2 = s2+s1;
            while (r1.length()!=0){//为防止字符串转整数时溢出，用字符串一位一位比较
                if(r1.charAt(0) > r2.charAt(0)){
                    return -1;
                }else if(r1.charAt(0)<r2.charAt(0)){
                    return 1;
                }else{
                    r1 = r1.substring(1);
                    r2 = r2.substring(1);
                }
            }

            return 0;
        });
       StringBuilder res = new StringBuilder();
       for (int i : ns){
           res.append(i);
       }

       return res.charAt(0) == '0' ? "0": res.toString();
    }

    public String largestNumber1(int[] nums){
        if(nums.length == 0) return null;
        String[] ns = new String[nums.length];//转换为字符串数组
        for (int i = 0; i < nums.length; i++) {
            ns[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(ns,(o1,o2)-> (o2+o1).compareTo(o1+o2));
        StringBuilder res = new StringBuilder();
        for (String i : ns){
            res.append(i);
        }

        return res.charAt(0) == '0' ? "0": res.toString();

    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        new ProblemLargestNumber().largestNumber1(nums);
    }
}
