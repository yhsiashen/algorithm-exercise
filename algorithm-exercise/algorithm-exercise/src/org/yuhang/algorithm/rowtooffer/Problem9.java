package org.yuhang.algorithm.rowtooffer;

/**变态跳台阶
 * Created by chinalife on 2018/5/2.
 */
public class Problem9 {
    public int JumpFloorII(int target) {
        int sum = 0;
        if(target == 0)
            return  0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        if(target == 3)
            return 4;
        while (target >0 ){
            sum += JumpFloorII(target-1);
            target --;
        }
        return sum;

    }
}
