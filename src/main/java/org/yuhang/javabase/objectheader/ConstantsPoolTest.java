package org.yuhang.javabase.objectheader;

public class ConstantsPoolTest {

    private static final int sfint = 1;
    private final int fint=2;
    private static int sint = 3;
    private int in = 4;
    private static String sstring = "kja";
    private String string = "hello";

    public int test(int i,int j){
        int res = in+sint;
        final int res1 = sfint+fint;
        String res3 = string+sstring;
        int res4 = i+j;
        System.out.println(res+" "+res1+" "+res3);
        return res4;
    }

    public static void main(String[] args) {
        new ConstantsPoolTest().test(sint,sfint);
    }
}
