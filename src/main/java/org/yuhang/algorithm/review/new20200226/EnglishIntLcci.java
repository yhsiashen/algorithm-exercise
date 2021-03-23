package org.yuhang.algorithm.review.new20200226;

import java.util.HashMap;
import java.util.Map;

/**
 * 非负整数的英文表示(0~2147483647)
 *
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * 输入: 1000000
 * 输出: ""
 */
public class EnglishIntLcci {

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] words1 = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] words2 = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] words3 = {"Eleven", "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        Map<Integer,String> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        Map<Integer,String> map3 = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map1.put(i, words1[i-1]);
            map2.put(i, words2[i-1]);
            map3.put(i, words3[i-1]);
        }
        StringBuilder res = new StringBuilder();
        int divisor = 10;
        int remainder;//余数
        int cnt = 0,unitIdx = 1;
        while (num!=0){
           remainder = num % divisor;//余数,循环依次取出个位，十位，百位，千位....
           num = num / divisor;
           if(remainder!=0){
               if(cnt == 0 && (num % 10)!=1){
                   res.append(map1.get(remainder)).append(" ");
               }else if(cnt == 0 && (num % 10)==1){
                   res.append(map3.get(remainder)).append(" ");
                   num = num/divisor;
                   cnt = (cnt+1)%3;
               }else if(cnt == 1) {
                   res.append(map2.get(remainder)).append(" ");
               }else{
                   res.append("Hundred").append(" ").append(map1.get(remainder)).append(" ");
               }
           }
           cnt = (cnt+1) % 3;
           if(unitIdx == 3 && (num % 1000)!= 0){
                res.append("Thousand ");
           }else if(unitIdx == 6 && (num % 1000)!= 0){
                res.append("Million ");
           }else if(unitIdx == 9 && (num % 1000)!= 0){
                res.append("Billion ");
           }
           unitIdx++;
        }

        String[] str  = res.toString().split(" ");
        StringBuilder strs = new StringBuilder();
        for (int i = str.length-1; i >=0 ; i--) {
            strs.append(str[i]).append(" ");
        }
        return strs.substring(0,strs.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(new EnglishIntLcci().numberToWords(1234567891));
    }
}
