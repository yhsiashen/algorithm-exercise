package org.yuhang;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;


public class Main {


    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "中";
//        byte[] bytes = str.getBytes("Unicode");
//        for (int i = 0; i <bytes.length ; i++) {
//            System.out.println(bytes[i]);
//        }
//        System.out.println(-2147483648>>>1);
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(-8>>>1));
        int i = (Integer.MAX_VALUE+10);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);

    }

}

