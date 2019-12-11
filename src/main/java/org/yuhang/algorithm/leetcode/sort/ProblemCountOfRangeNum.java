package org.yuhang.algorithm.leetcode.sort;

/**
 * 区间和的个数 LC327 TODO
 * @tag:排序应用
 */
public class ProblemCountOfRangeNum {

    int cnt;

    /**
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0) return 0;
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0]; //前缀和数组
        for (int i = 1; i < nums.length; i++) {
             preSum[i] = preSum[i-1]+nums[i];
        }
        long[] tmp = new long[preSum.length];
        merge(preSum,tmp,0,preSum.length-1,lower,upper);
         return cnt;
    }

    private void merge(long[] preSum,long[] tmp, int l, int r, int lower, int upper) {
        if(l == r) return;
        int mid = l+(r-l)/2;
        merge(preSum,tmp,l,mid,lower,upper);
        merge(preSum,tmp,mid+1,r,lower,upper);
        mergeCount(preSum,tmp,l,mid,r,lower,upper);
    }

    /**
     * 将前缀和数组做归并升序,并在归并过程中计算区间和
     * @param preSum
     * @param tmp
     * @param l
     * @param mid
     * @param r
     * @param lower
     * @param upper
     */
    private void mergeCount(long[] preSum, long[] tmp,int l, int mid, int r, int lower, int upper) {
        int i = l,j = mid+1,idx = l;
        int m1 = mid+1,m2 = mid+1;
        while (i<=mid){
            while (m1<=r && preSum[m1]-preSum[i]<lower) m1++;
            while (m2<=r && preSum[m2]-preSum[i]<=upper) m2++;
            while (j<=r && preSum[j]<preSum[i]) tmp[idx++] = preSum[j++];
            tmp[idx++] = preSum[i++];
            cnt+=m2-m1;
        }
        while (j<=r) tmp[idx++] = preSum[j++];
        for (int k = l; k <= r; k++) {
            preSum[k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        System.out.println(new ProblemCountOfRangeNum().countRangeSum(nums,-2,2));
    }
}
