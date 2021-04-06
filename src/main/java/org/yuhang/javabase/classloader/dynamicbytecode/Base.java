package org.yuhang.javabase.classloader.dynamicbytecode;

public class Base {

    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            process();
        }
    }
    private static void process(){
        System.out.println("process");
    }
}
