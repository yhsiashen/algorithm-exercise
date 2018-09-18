package com.chinalife.springmvc.multthread;

/**
 * Created by chinalife on 2018/4/18.
 */
public class TestMult {

    private String str;

    private void testStr(String str){
         this.str = str;
    }

    private void testStr2(){
        this.str = "asd";
    }


    public static void main(String[] args) throws InterruptedException {
//        MyRunnable my =new MyRunnable();
//        my.setS("222");
//        Thread t = new Thread(my);
//        t.start();
//        String[]  str = {"111","222","333"};
//        ConcurrentTestAtomatic cc= new ConcurrentTestAtomatic();
//        cc.main(str);
          String str = "123";
          String  s1= "124";
          if(str.equals(s1)){
              System.out.println(s1+str);
          }

    }  
}
