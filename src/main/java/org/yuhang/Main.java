package org.yuhang;


import java.io.UnsupportedEncodingException;


public class Main {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "中";
        byte[] bytes = str.getBytes("Unicode");
        for (int i = 0; i <bytes.length ; i++) {
            System.out.println(bytes[i]);
        }
//        System.out.println(Charset.defaultCharset());
    }
}

