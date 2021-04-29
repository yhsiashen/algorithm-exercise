package org.yuhang.algorithm.review.new20200226;

import java.util.Random;

public class ImplementRand10UsingRand7 {


    public int rand10() {
        while(true) {
            int num = (rand7() - 1) * 7 + rand7(); // 等概率生成[1,49]范围的随机数
            if(num <= 40) return num % 10 + 1; // 拒绝采样，并返回[1,10]范围的随机数
        }
    }

    private Random random = new Random();

    public int rand7() {
        return random.nextInt(7)+1;
    }

    public static void main(String[] args) {
        ImplementRand10UsingRand7 im = new ImplementRand10UsingRand7();
        for (int i = 0; i < 100; i++) {
            System.out.println(im.rand10());
        }
    }

}
