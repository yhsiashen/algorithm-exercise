package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;

/**
 * 区间列表的交集 LC986
 */
public class ProblemIntervalListIntersetions {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> res = new ArrayList<>();
        if(A.length == 0 || B.length ==0 )return res.toArray(new int[][]{});
        int a = 0, b=0;
        while (a < A.length && b < B.length){
            if(A[a][0] > B[b][1]){//丢弃当前的B
                b++;
            }else if(A[a][1] < B[b][0]){//丢弃当前的A
                a++;
            }else{
                int left = Math.max(A[a][0],B[b][0]);
                int right = Math.min(A[a][1],B[b][1]);
                res.add(new int[]{left,right});
                if(A[a][1] < B[b][1]){
                    a++;
                }else if(A[a][1] > B[b][1]){
                    b++;
                }else{
                    a++;
                    b++;
                }
            }
        }

        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {

    }
}
