package org.yuhang;


public class Main1 {

    public String test(){
        return "myclassloader!!!!";
    }

    public static void main(String[] args) {
        System.out.println(new Main1().test());
    }


}

