package com.chinalife.springmvc.algorithm.rowtooffer;

/** 青蛙跳台阶问题
 * Created by chinalife on 2018/5/2.
 */
public class Problem8 {

    public int JumpFloor(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        System.out.println(new Problem8().JumpFloor(5));
    }
}
