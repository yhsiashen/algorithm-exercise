package org.yuhang.algorithm.leetcode.array;


import java.util.Arrays;

/**
 * 求一组论文的h指数 274
 */
public class ProblemHIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len ;
        for(int i=0;i<citations.length;i++){
            len = citations.length-i;
            if(citations[i]>=len)
                return len;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(new ProblemHIndex().hIndex(citations));
    }
}
