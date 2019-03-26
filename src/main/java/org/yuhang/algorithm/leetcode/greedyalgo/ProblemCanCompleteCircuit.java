package org.yuhang.algorithm.leetcode.greedyalgo;

/**
 * N个加油站，判断汽车能否行使一圈  134
 */
public class ProblemCanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //目前油量
        int curSave = 0;
        //加油站数目
        int gasStationNums = gas.length;
        //满足条件的车站索引
        int index = -1;
        boolean flag = true;
        for (int i = 0; i < gasStationNums; i++) {
            //若该站收益不为负，则从该站出发
            if (gas[i] - cost[i] >= 0) {
                //从i出发
                for (int j = i; j < gasStationNums; j++) {
                    curSave += gas[j] - cost[j];
                    if (curSave < 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    //从0站出发到i-1站
                    for (int j = 0; j < i; j++) {
                        curSave += gas[j] - cost[j];
                        if (curSave < 0) {
                            flag=false;
                            break;
                        }
                    }
                }
                //所有车站跑完，curSave>0则认为该点满足条件
                if(flag) {
                    index = i;
                    break;
                }
            }
            //一种可能性跑完则油量清零,油量为负的标志重置
            curSave=0;
            flag=true;
        }

        return index;

    }

    public static void main(String[] args) {
        int[] gas = {2};
        int[] cost = {2};
        System.out.println(new ProblemCanCompleteCircuit().canCompleteCircuit(gas, cost));
    }
}
