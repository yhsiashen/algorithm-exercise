package com.chinalife.springmvc.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chinalife on 2017/12/7.
 */
public class Main1 {

    public static void main(String[] args) {

        int n = 0;
        int m = 0;

        //输入类
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

       //定义站点图数组
        int position[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int p = 0; p < n; p++) {
                position[i][p] = sc.nextInt();
                if (position[i][p] == -1) {
                    position[i][p] = Integer.MAX_VALUE;
                }
            }
        }
        for (int k = 0; k < m; k++) {

            int ss = sc.nextInt();
            int ee = sc.nextInt();
            ss --;
            ee --;
            int l=0;
            int t=0;
            int[] ll = new int[n];
            int[] qq = new int[n];
            int[] mm = new int[n];
            int router = ee;
            int number = 0;

            Arrays.fill(ll, Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                mm[i] = i;
            }
            qq[ss] = 1;    ll[ss] = 0;
            while (true) {
                // 0赋值给t
                t = 0;
                while (t < n && qq[t] == 0) {
                    t++;
                }
                if (t == n) {
                    break;
                }
                for (l = 0; l < n; l++) {
                    if (ll[l] > position[t][l] + ll[t]) {
                          if( Integer.MAX_VALUE > position[t][l] ) {
                              ll[l] = position[t][l] + ll[t];
                              qq[l] = 1;  mm[l] = t;
                          }
                    }
                }
                qq[t] = 0;
            }

            while (mm[router] != ss) {
                router = mm[router];
               number = number + 1;
            }
            System.out.println(number + " " + ll[ee]);
        }
    }

}


