package org.yuhang.algorithm;

import java.util.Arrays;

/**二分查找法
 * Created by yuhang on 2018/3/13.
 */
public class BinarySearch {

    private static int searchIndex(int[] a,int key){
        return searchIndexByRec(a,key,0,a.length-1);
    }

    //递归解法
    private static int searchIndexByRec(int[] a,int key,int min,int max){
        if(min>max ){
            return -1;
        }
        int mid = (min+max)/2;
        if(key < a[mid]){
            return searchIndexByRec(a,key,min,mid-1);
        }else if(key > a[mid]){
            return searchIndexByRec(a,key,mid+1,max);
        }else {
            return mid;
        }
    }

    //非递归解法
    private static void serchIndex(int[] a,int key){
        int min = 0;
        int max = a.length-1;
        int mid = (a.length-1)/2;

      for(int i = 0;i<Math.log(a.length)/Math.log(2);i++) {
          if(min>=max){
              System.out.println(-1);
              break;
          }
          if (key < a[mid]) {
                max = mid-1;
                mid = (min+max)/2;
                continue;
          }else if(key > a[mid]){
                min = mid+1;
                mid = (min+max)/2;
                continue;
          }else{
              System.out.println(mid);
              break;
          }
      }
    }

    public static void main(String[] args) {
        int[] a = {6,1,9,7,8,12,11,18};
        int key = 10;
        Arrays.sort(a);
//        System.out.println(BinarySearch.searchIndexByRec(a,key,0,a.length-1));
        serchIndex(a,key);

    }
}
