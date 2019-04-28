package org.yuhang.javabase.bigclass;

import java.math.BigDecimal;

/**
 * BigDecimal(十进制)类测试
 */
public class BigDecimalTest {


    public static void main(String[] args)
    {
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 - 0.1);
        System.out.println(0.2 * 0.1);
        System.out.println(0.3 / 0.1);

        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal bDouble = new BigDecimal(2.3); //不推荐用double型的参数做构造器,因为double无法准确表示2.3
        BigDecimal bString = new BigDecimal("2.2"); //推荐String型做构造器

        System.out.println(bigDecimal);
        System.out.println(bDouble);
        System.out.println(bString);

        System.out.println(bigDecimal.add(new BigDecimal("2.1")));
    }
}
