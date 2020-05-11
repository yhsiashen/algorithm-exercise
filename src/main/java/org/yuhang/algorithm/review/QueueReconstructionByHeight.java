package org.yuhang.algorithm.review;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 根据身高重建队列 LC406
 */
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        if(people.length ==0) return new int[][]{};
        Arrays.sort(people,(o1, o2) -> o1[0] == o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] person:people){
            res.add(person[1],person);
        }

        return res.toArray(new int[][]{});
    }
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] res = new QueueReconstructionByHeight().reconstructQueue(people);
        System.out.println(res);
    }
}
