package org.yuhang.algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * 合并排序的数组
 */
public class ProblemSortedMergeLcci {

    public void merge(int[] A, int m, int[] B, int n) {
       if(n== 0) return;
       int[] tmp = Arrays.copyOf(A,m);
       int a=0,b=0,c=0;
       while (a<m && b <n){
           if(A[a] < B[b]){
               tmp[c++]=A[a++];
           }else{
               tmp[c++]=B[b++];
           }
       }

       while (a<m){
           tmp[c++] = A[a++];
       }

       while (b<n){
           tmp[c++] = B[b++];
       }
       A = tmp;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        new ProblemSortedMergeLcci().merge(A,3,B,3);
    }

}
