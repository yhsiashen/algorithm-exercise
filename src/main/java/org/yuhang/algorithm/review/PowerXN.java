package org.yuhang.algorithm.review;

/**
 * 实现Pow(x,n)函数 LC50
 */
public class PowerXN {

    public double myPow(double x, int n) {
        if(x == 0.0) return 0.0;
        if(n == 0) return 1.0;
        long n_long = Math.abs((long)n);
        double res = calpowerxn(x,n_long);
        return n<0?1/res:res;
    }

    private double calpowerxn(double x, long n_long) {
        if( n_long == 1L) return x;
        double res;
        if((n_long&1)==0){
            res =  calpowerxn(x,n_long>>1);
            return res*res;
        }else{
            res = calpowerxn(x,(n_long-1)>>1);
            return res*res*x;
        }

    }

    public static void main(String[] args) {
        System.out.println(new PowerXN().myPow(1.0,Integer.MIN_VALUE));
    }
}
