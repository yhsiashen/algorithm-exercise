package org.yuhang.algorithm.leetcode.math;


/**
 * 灯泡开关 LC319
 */
public class ProblemBulbSwitcher {

    /**
     * 递推
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        if(n<1) return 0;
        boolean[] status = new boolean[n]; //灯泡的状态数组
        int level=1; //从第二轮开始改变灯泡状态
        while (level < n) {
            for (int i = level; i < n; i+=level+1) {
                status[i] = !status[i];
            }
            level++;
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            if(!status[i]) res++;
        }
        return res;
    }


    /**
     * 数学法分析
     * @param n
     * @return
     */
    public int bulbSwitch1(int n){
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(new ProblemBulbSwitcher().bulbSwitch1(99999999));
    }
}
