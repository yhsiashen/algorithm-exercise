package org.yuhang.javabase.gctest;

import java.util.ArrayList;
import java.util.List;

public class MetaspaceOOMTest {

    private static String str = "test";

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        while (true){
            String str1= str+str;
            str  = str1;
            list.add(str1);
        }
    }
}
