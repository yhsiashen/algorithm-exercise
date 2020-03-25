package org.yuhang.algorithm.leetcode.array;

/**
 * 将数组分成和相等的三个部分 LC1013
 */
public class ProblemPartitionArrayIntoThreePartswithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int[] P =new int[A.length+1];
        for (int i = 0; i < A.length; i++) {
            P[i+1] = P[i]+A[i];
        }
        if(P[A.length] % 3 !=0) return false;
        int t = P[A.length] / 3;


        for (int i = 1; i < P.length-2; i++) {
            if(P[i] == t){//找第一个分界点
                int j = i+2;
                while (j < P.length && P[j]-P[i]-A[j-1] != t){//找第二个分界点
                    j++;
                }
                if(j<P.length && P[j]-P[i]-A[j-1] == t) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(new ProblemPartitionArrayIntoThreePartswithEqualSum().canThreePartsEqualSum(A));
    }


}
