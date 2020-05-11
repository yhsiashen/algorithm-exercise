package org.yuhang.algorithm.leetcode.array;

/**
 * 在山脉数组中查找目标值 LC1095
 */
public class FindInMountainArray {

    interface MountainArray{
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0,r = mountainArr.length()-1;
        int top = -1;
        while (l <= r){
            int mid = (l+r)/2;
            int before = mountainArr.get(mid-1);
            int cur = mountainArr.get(mid);
            int after = mountainArr.get(mid+1);
            if(before < cur && cur > after){
                top = mid;
                break;
            }else if(before < cur && cur < after){//山顶元素在右边
                l = mid;
            }else if(before > cur
                && cur > after){//山顶元素在左边
                r = mid;
            }
        }

        l = 0;
        r = top;
        while (l <= r){
            int mid = (l+r)/2;
            int cur = mountainArr.get(mid);
            if(cur == target){
                return mid;
            }else if(cur < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        l = top+1;
        r = mountainArr.length()-1;
        while (l<=r){
            int mid = (l+r)/2;
            int cur = mountainArr.get(mid);
            if(cur == target){
                return mid;
            }else if(cur < target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return -1;
    }
}
