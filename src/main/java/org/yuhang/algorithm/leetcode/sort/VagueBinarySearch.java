package org.yuhang.algorithm.leetcode.sort;


/**
 * 模糊的二分搜索
 */
public class VagueBinarySearch {

    /**
     * 找到数组中大于等于key的第一个元素,找不到则返回-1
     *
     * @param nums
     * @param key
     * @return
     */
    public int vagueBinarySearchIndex(int[] nums, int key) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return binarySearchIndex(nums, 0, nums.length - 1, key);
    }

    private int binarySearchIndex(int[] nums, int start, int end, int key) {
        if (start > end)
            return -1;
        //防止溢出
        int mid = start+((end-start)>>1);
        //若中间值大于等于key,则判断nums[mid-1]的值与key的大小
        if(nums[mid] >= key){
          if( mid==0 || nums[mid-1] < key){
              return mid;
          }else{
             return binarySearchIndex(nums,start,mid-1,key);
          }
        } else{
            //若中间值小于key，则第一个比key大的值必在mid+1~key区间
            return binarySearchIndex(nums,mid+1,end,key);
        }
    }

    public static void main(String[] args) {
        int[] a= {2,4,6,8,9,10};
        System.out.println(new VagueBinarySearch().vagueBinarySearchIndex(a,11));
    }
}

