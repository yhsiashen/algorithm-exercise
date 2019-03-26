package org.yuhang.algorithm.leetcode.array;


/**
 * 在一组数据里找到第K大的元素，要求时间复杂度为O(n),快排思想- O(n+n/2+n/8+...+1) = O(2n-1) = O(n)
 */
public class ProblemFindKthNum {


    public int findKthNum(int[] nums,int k ){
          if(nums==null || nums.length==0 || k<=0 || k>nums.length )
              return Integer.MIN_VALUE;

      return  findKthNumBySort(nums,0,nums.length-1,k);


    }

    private int findKthNumBySort(int[] nums,int start,int end,int k){
        if(start <= end) {
            // 选定哨兵为start，pos为最后一个比哨兵小的元素
            int pos = start;
            // 遍历数组,以哨兵为界分区
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] <= nums[start]) {
                    swap(nums, i, pos + 1);
                    pos++;
                }
            }
            // 遍历完毕将哨兵元素换到正确的位置
            swap(nums, start, pos);
            // 判断此时哨兵元素所在位置是否为第k大
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                return findKthNumBySort(nums, start, pos - 1, k);
            } else {
                return findKthNumBySort(nums, pos + 1, end, k);
            }
        }
        return Integer.MIN_VALUE;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a= {2,1,0,-1,4,3,5,8,1};
        int k = 10;
        System.out.println(new ProblemFindKthNum().findKthNum(a,k));
    }



}
