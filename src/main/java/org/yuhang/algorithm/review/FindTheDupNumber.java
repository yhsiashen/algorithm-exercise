package org.yuhang.algorithm.review;

/**
 * 找到重复数 LC287
 */
public class FindTheDupNumber {

    /**
     * 二分查找 O(nlogn)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
       int n = nums.length;
       int l = 1, r = n-1;//长度为n的数组，包含的数据范围为1~n-1
       while (l < r){//在1~n-1中做二分查找
           int mid = (l+r)/2+1;//避免取到mid=1
           int count = 0;
           for(int num:nums){
               if(num < mid) count++;//统计数组中比mid小的数
           }
           if(count < mid){//如果统计的count数目小于mid，则重复数不在左边区间
               l = mid;
           }else{
               r = mid-1;
           }
       }
       return l;
    }

    /**
     * 数组中的快慢指针找环
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int slow = 0,fast = 0;
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow){//两指针相遇说明数组内有"环",然后找环的入口即为重复数字
                fast = 0;
                while (nums[fast]!=nums[slow]){//让快指针重新从0开始，慢指针从相遇的位置开始同时向前走，相遇时即为环的入口
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[fast];
            }

        }
    }
}
