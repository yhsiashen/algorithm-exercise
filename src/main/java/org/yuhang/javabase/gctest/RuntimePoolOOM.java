package org.yuhang.javabase.gctest;

import java.util.ArrayList;
import java.util.List;

public class RuntimePoolOOM {
    static class OOMObject{

    }


    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        int i=0;
        while (true){
            Thread.sleep(1);
//            list.add(String.valueOf(i++));
            list.add(new OOMObject());
        }
    }
}
