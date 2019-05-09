package org.yuhang;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String pattern = "[0-9]";
        while (sc.hasNext()) {
            System.out.println(sc.next(pattern));

        }
    }
}

