package org.yuhang.algorithm.leetcode.string;


/**
 * 反转字符串 LC344
 */
public class ProblemReverseString {

    public void reverseString(char[] s) {
        if(s.length == 0) return;
        int i  = 0,j = s.length -1;
        while (i < j){
            swap(s, i ,j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
