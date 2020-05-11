package org.yuhang.algorithm.leetcode.sort;

import java.util.Random;

/**
 * 排序数组 LC912
 */
public class ProblemSortAnArray {


    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 快排
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        partition(nums,0,nums.length-1);
        return nums;
    }

    Random random = new Random();

    private void partition(int[] nums, int start, int end) {
        if(start<end){
            //随机选取nums中的一个数做哨兵
            int pivotIndex = random.nextInt(end-start)+start;
            swap(nums,start,pivotIndex);
            int j = start;
            for (int i = start; i <=end ; i++) {
                if(nums[i] < nums[start]){
                    swap(nums,i,++j);
                }
            }
            //交换哨兵与最后一个元素
            swap(nums,start,j);
            partition(nums,start,j-1);
            partition(nums,j+1,end);
        }

    }

    /**
     * 归并
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if(start < end){
            int mid = start+(end-start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            int[] mergeArray = new int[end-start+1];
            int l=start;
            int r=mid;
            int k=0;
            while (l<=mid && r<=end){
                if(nums[l] < nums[r]){
                    mergeArray[k++] = nums[l++];
                }else{
                    mergeArray[k++] = nums[r++];
                }
            }
            while (l<=mid){
                mergeArray[k++] = nums[l++];
            }
            while (r<=end){
                mergeArray[k++] = nums[r++];
            }

            System.arraycopy(mergeArray,0,nums,start,end-start+1);
        }

    }

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public int[] sortArray3(int[] nums) {
        heapify(nums);//将数组堆化(大顶堆)
        for (int i = nums.length-1; i >=1 ; ) {
            swap(nums,0,i);//将堆顶元素交换到最后
            i--;
            shitDown(nums,0,i);//将交换过来的元素重新下沉满足0~i区间的堆性质
        }
        return nums;
    }

    /**
     * 将数组堆化
     * @param nums
     */
    private void heapify(int[] nums) {
        int len = nums.length;
        for (int i = (len-1)/2; i >=0 ; i--) {
            shitDown(nums,i,len-1);
        }

    }

    /**
     * 将k位置的元素下沉，满足堆性质
     * @param nums
     * @param k
     * @param end
     */
    private void shitDown(int[] nums, int k, int end) {
        while (2*k+1<=end){
            int j = 2*k+1;
            if(j+1<=end && nums[j+1]>nums[j]){//在k的左右子树 2*k+1 和 2*k+2 中选择较大的与k交换
                j++;
            }
            if(nums[j] > nums[k]){
                swap(nums,j,k);
            }else{
                break;
            }
            k = j;
        }

    }

    /**
     * 计数排序,适用于已知数据范围的排序,O(n)
     * @param nums
     * @return
     */
    public int[] sortArray4(int[] nums) {
        int max = -50001,min = 50001;
        for(int num:nums){//在待排序的数据集中找到边界值
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] counter = new int[max-min+1];
        for(int num:nums){
            counter[num-min]++;
        }
        int idx = 0;
        for (int num = min; num <=max ; num++) {
            int cnt = counter[num-min];//得到counter[num-min]索引位置的数，表示num有这么多重复的
            while (cnt-- > 0){
                nums[idx++] = num;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1,1,3,5,4};
        System.out.println(new ProblemSortAnArray().sortArray4(nums));
    }
}
