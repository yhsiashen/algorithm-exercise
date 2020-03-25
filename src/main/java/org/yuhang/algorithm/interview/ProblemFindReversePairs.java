package org.yuhang.algorithm.interview;

/**
 * 求数组中逆序对的总数
 */
public class ProblemFindReversePairs {

    int res;

    /**
     * 归并算法(分治思想)
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        calReverseParisInMerge(nums,0,nums.length-1);
        return res;
    }

    /**
     * 归并
     * @param nums
     * @param start
     * @param end
     */
    private void calReverseParisInMerge(int[] nums,int start,int end) {
        if(start<end){
            int mid = start+(end-start)/2;
            calReverseParisInMerge(nums,start,mid);//左边区间有序
            calReverseParisInMerge(nums,mid+1,end);//右边区间有序
            merge(nums,start,mid,mid+1,end);//合并左右两区间
        }
    }

    /**
     * 在归并的时候计算逆序数
     * @param nums
     * @param l_start
     * @param l_end
     * @param r_start
     * @param r_end
     */
    private void merge(int[] nums, int l_start, int l_end, int r_start, int r_end) {
         int mergeL = r_end - l_start+1;
         int[] merge = new int[mergeL];
         int l=l_start,r=r_start,m=0;
         while (l<=l_end && r<=r_end){
             if(nums[l] < nums[r]){//左边元素出列
                merge[m++] = nums[l++];
             }else{//右边元素出列
                merge[m++] = nums[r++];
                res += l_end-l+1;//右边元素出列时，计算左边元素此时还有多少个未出列的元素，即和右边的元素组成逆序对
             }
         }
         //左边还有值
         while (l<=l_end){
             merge[m++] = nums[l++];
         }
         //右边还有值
         while (r<=r_end){
             merge[m++] = nums[r++];
         }
         System.arraycopy(merge,0,nums,l_start,merge.length);
    }

    public static void main(String[] args) {
        new ProblemFindReversePairs().reversePairs(new int[]{7,5,6,4});
    }
}
