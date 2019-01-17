package org.yuhang.algorithm.rowtooffer;

/** 旋转数组的最小值
 * Created by chinalife on 2018/5/2.
 */
public class Problem6 {

    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }

        for(int i =0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
             int[] i={1,2,3,4,5};
             System.out.println(Problem6.minNumberInRotateArray(i));
    }
}
