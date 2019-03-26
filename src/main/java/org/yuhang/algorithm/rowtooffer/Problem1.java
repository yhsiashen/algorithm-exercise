package org.yuhang.algorithm.rowtooffer;

/** 二维数组的查找
 * Created by yuhang on 2018/3/25.
 */
public class Problem1 {
    public boolean Find(int target, int [][] array) {
        int i = 0;
        boolean result = false;
        while(i<array.length){
            int[] a= array[i];
            result = FindInArray(a,0,a.length-1,target);
            if(result){
                break;
            }
            i++;
        }
        return result;
    }

    public boolean FindInArray(int[] a ,int min,int max,int target){
        if(min > max){
            return false;
        }
        int mid = (min+max)/2;
        if(target < a[mid]){
            return FindInArray(a,min,mid-1,target);
        }else if(target > a[mid]){
            return FindInArray(a,mid+1,max,target);
        }else{
            return true;
        }

    }

    public static void main(String[] args) {
        int[][] array ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 1;
        Problem1 p = new Problem1();
        System.out.println(p.Find(target,array));
    }
}
