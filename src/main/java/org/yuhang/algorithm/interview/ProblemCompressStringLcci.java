package org.yuhang.algorithm.interview;

/**
 * 字符串压缩
 */
public class ProblemCompressStringLcci {

    public String compressString(String S) {
       StringBuilder res = new StringBuilder();
       int index = 0;
       for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i)!=S.charAt(i-1)){
                int num = i-index;
                res.append(S.charAt(i-1)).append(num);
                index = i;
            }
       }
       return res.length()>=S.length()?S:res.toString();
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(2));
    }
}
