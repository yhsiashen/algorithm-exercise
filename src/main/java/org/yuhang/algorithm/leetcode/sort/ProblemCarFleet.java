package org.yuhang.algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * 车队 LC853
 */
public class ProblemCarFleet {


    class Car{
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; ++i)
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        Arrays.sort(cars, (o1, o2) -> o1.position-o2.position);

        int ans = 0, t = N;
        while (--t > 0) {
            if (cars[t].time < cars[t-1].time) ans++; //if cars[t] arrives sooner, it can't be caught
            else cars[t-1] = cars[t]; //else, cars[t-1] arrives at same time as cars[t]
        }

        return ans + (t == 0 ? 1 : 0); //lone car is fleet (if it exists)
    }


    public static void main(String[] args) {
        System.out.println(new ProblemCarFleet().carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3}));
    }

}
