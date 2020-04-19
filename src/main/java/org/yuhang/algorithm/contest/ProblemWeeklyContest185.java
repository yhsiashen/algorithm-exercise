package org.yuhang.algorithm.contest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemWeeklyContest185 {

    public String reformat(String s) {
         String nums = "";
         String chrs = "";
         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
            if(Character.isDigit(ch)) nums = nums+ch;
            else chrs = chrs+ch;
         }

         if(Math.abs(nums.length() - chrs.length())>1) return "";
         int i = 0,j=0;
         StringBuilder res=  new StringBuilder();
         if(nums.length() <=chrs.length()){
             while (i<nums.length() && j< chrs.length()){
                 res.append(chrs.charAt(j++));
                 res.append(nums.charAt(i++));
             }
             if(j<chrs.length()) res.append(chrs.charAt(j));
         }else{
             while (i<nums.length() && j< chrs.length()){
                 res.append(nums.charAt(i++));
                 res.append(chrs.charAt(j++));
             }
             res.append(nums.charAt(i));

         }

         return res.toString();


    }

    public List<List<String>> displayTable(List<List<String>> orders) {


        return null;
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('c',0);
        map.put('r',1);
        map.put('o',2);
        map.put('a',3);
        map.put('k',4);
        int[] needed = new int[5];
        int res = 0;
        for (int i = 0; i <croakOfFrogs.length() ; i++) {
             char ch = croakOfFrogs.charAt(i);
             int need = map.get(ch);
             if(need == 0){
                 int cur = 0;
                 for (int j = 1; j < 5; j++) {
                     cur += needed[j];
                 }
                 needed[1]++;
                 if(cur==res) {
                     res++;
                 }
             }else{
                 if(needed[need] == 0) {
                     return -1;
                 }else{
                     needed[need]--;
                     if(need != 4) needed[need+1]++;
                 }

             }
        }
        for (int i = 1; i < 5; i++) {
            if(needed[i]!=0) return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemWeeklyContest185().minNumberOfFrogs("croakcroak"));
    }
}
