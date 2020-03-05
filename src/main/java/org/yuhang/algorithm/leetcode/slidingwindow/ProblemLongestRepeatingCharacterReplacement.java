package org.yuhang.algorithm.leetcode.slidingwindow;

/**
 * 替换后的最长重复字符  LC424
 * @tag:滑动窗口
 */
public class ProblemLongestRepeatingCharacterReplacement {


    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;
        int[] map = new int[26];
        int left=0,right=0,res=0,maxCount=0;
        while (right < s.length()){
            map[s.charAt(right)-'A']++;//记录数字出现的次数
            maxCount = Math.max(maxCount,map[s.charAt(right)-'A']);
            if(right-left+1-maxCount > k){//滑动窗口里需要替换的字符个数大于了k，这时需要移动左边边界
                map[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res,right-left+1);//更新长度
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemLongestRepeatingCharacterReplacement().characterReplacement("AABABBA",1));
    }
}
