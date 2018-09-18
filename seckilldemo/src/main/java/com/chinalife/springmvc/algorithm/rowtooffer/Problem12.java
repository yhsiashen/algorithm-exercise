package com.chinalife.springmvc.algorithm.rowtooffer;

/** 数的整数次方
 * Created by chinalife on 2018/5/3.
 */
public class Problem12 {

    public double Power(double base, int exponent) {
            if(exponent == -1)
                return 1/base;
            if(exponent == 0 )
                return 1;
            if(exponent == 1)
                return base;

            if(exponent<-1)
                return (1/base)*Power(base,exponent+1);
            return base*Power(base,exponent-1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem12().Power(2,-3));
        int a= 100;



    }

    private static void f1() {
    }


}
