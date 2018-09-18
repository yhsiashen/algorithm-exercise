package com.chinalife.springmvc.test;

import java.util.HashMap;


/**
 * Created by chinalife on 2017/12/7.
 */
public class TestMain {
    public static void main(String[] args) {
        HashMap<String,String>  map = new HashMap<String, String>();
        map.put("yuhang","111");
        map.put("yuhang","222");
        map.put("yuhang","333");
        map.put("asd","444");
        for (String s:map.keySet()
             ) {
            System.out.println(s);
        }

        for (String c:map.values()
             ) {
            System.out.println(c);
        }
    }

}
