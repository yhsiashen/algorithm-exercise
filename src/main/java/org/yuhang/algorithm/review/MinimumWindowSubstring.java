package org.yuhang.algorithm.review;

/**
 * 最小覆盖子串 LC76
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] tmaps = new int[128];
        int tl = 0;
        for (int i = 0; i < t.length() ; i++) {
            tmaps[t.charAt(i)]++;
            tl++;
        }
        int[] smaps = new int[128];
        int sl = 0;
        int l=0,r=0;
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        while (r<s.length()){
            char ch = s.charAt(r);
            smaps[ch]++;
            if(smaps[ch] <= tmaps[ch]){
                sl++;
            }
            while (sl == tl){//当滑动窗口满足要求时，移动左指针直到滑动窗口不满足要求
               if(r-l+1 < min){//计算一次满足要求的子串
                   min =r-l+1;
                   left = l;
                   right = r;
               }
               char remove = s.charAt(l);
               if(smaps[remove] <= tmaps[remove]){
                   sl--;
               }
               smaps[remove]--;
               l++;
            }

            r++;
        }


        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
    }

}
