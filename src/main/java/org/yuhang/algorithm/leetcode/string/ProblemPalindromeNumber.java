package org.yuhang.algorithm.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 判断一个整数是否为回文数  LC9
 */
public class ProblemPalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        //转换为字符串
//        String xStr = String.valueOf(x);
//        int start = 0;
//        int end = xStr.length()-1;
//        while (start < end){
//            if(xStr.charAt(start) != xStr.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
        //直接处理
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while ( x/10!=0){
            deque1.add(x % 10);
            deque2.add(x % 10);
            x = x/10;
        }
        deque1.add(x % 10);
        deque2.add(x % 10);
        while (!deque1.isEmpty()){
            if(!deque1.removeFirst().equals(deque2.removeLast())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemPalindromeNumber().isPalindrome(1232));
    }
}
