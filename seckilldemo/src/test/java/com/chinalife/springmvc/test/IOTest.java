package com.chinalife.springmvc.test;




import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int count = 0; count< N; count++) {
            String[]  TS = sc.nextLine().split(" ");
            int[] T = new int[TS.length];
            for (int i = 0; i < TS.length; i++) {
                T[i] = Integer.parseInt(TS[i]);
            }
            int s = 0;
            for (int num : T)
                s += num;
            if (s % 2 != 1) {
                int t = s / 2;
                boolean[][] sm = new boolean[T.length][t + 1];
                if (T[0] <= t) {
                    sm[0][T[0]] = true;
                }
                for (int k = 0; k < T.length; k++) {
                    sm[k][0] = true;
                }
                for (int k = 1; k < sm.length; k++) {
                    for (int l= 1; l < sm[0].length; l++) {
                        if (l < T[k]) {
                            sm[k][l] = sm[k - 1][l];
                        } else {
                            sm[k][l] = sm[k - 1][l] || sm[k - 1][l- T[k]];
                        }
                    }
                }
                if(sm[sm.length - 1][sm[0].length - 1]){
                    System.out.println("TRUE");
                }else{
                    System.out.println("FALSE");
                }
            } else {
                System.out.println("FALSE");
            }
        }
    }
    }

