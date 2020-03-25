package org.yuhang.algorithm.leetcode.slidingwindow;

/**
 * 最小覆盖子串 LC76
 */
public class ProblemMinimumWindowSubstringI {

    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return s;
        if(s.length() < t.length()) return "";
        int[] t_maps = new int[128];
        int t_num = 0;
        for (int i = 0; i < t.length(); i++) {
            t_maps[t.charAt(i)]++;
            t_num++;
        }
        int[] s_maps = new int[128];
        int s_num = 0;
        int i = 0, j =0 ,minl = Integer.MAX_VALUE ,left = 0, right = 0;
        while (j < s.length()){
            s_maps[s.charAt(j)]++;
            if(t_maps[s.charAt(j)] > 0 && s_maps[s.charAt(j)]<= t_maps[s.charAt(j)]) {
                s_num++;
            }
            while (s_num == t_num ){//当子串符合要求时记录一下此时子串的最小值，然后移动左边窗口直至窗口不符合要求
                if(s_maps[s.charAt(i)] == t_maps[s.charAt(i)]){
                    s_num--;
                    if(j-i+1<minl) {//记录此时的left与right
                        minl = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
                s_maps[s.charAt(i)]--;
                i++;
            }
            j++;
        }

        return minl == Integer.MAX_VALUE?"":s.substring(left,right+1);
    }

    public static void main(String[] args) {
        System.out.println(new ProblemMinimumWindowSubstringI().minWindow("a","b"));
    }
}
