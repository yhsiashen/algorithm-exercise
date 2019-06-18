package org.yuhang;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
         Map<String,String> map = new HashMap<>();
         map.put("1","2");
         map.put("2","s");
         map.put("3","m");
        for (String key:map.keySet()) {
            System.out.println(key);
            if("2".equals(key)) map.put("2","3");
        }
        System.out.println(map.get("2"));
    }
}

