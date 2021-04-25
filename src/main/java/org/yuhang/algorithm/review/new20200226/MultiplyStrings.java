package org.yuhang.algorithm.review.new20200226;

/**
 * 字符串相乘
 * 非负整数 num1 和 num2
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] n1 = new int[len1];
        int[] n2 = new int[len2];
        for (int i = len1-1; i >=0 ; i--) {
            n1[len1-1-i] = num1.charAt(i) - '0';
        }
        for (int i = len2-1; i >=0 ; i--) {
            n2[len2-1-i] = num2.charAt(i) - '0';
        }
        String res = "";
        int cnt = 0;
        for (int i = 0; i < len2; i++) {//将n2的每一个数字与n1相乘
            int carry = 0;
            StringBuilder eachRes = new StringBuilder();
            for (int j = 0; j < len1; j++) {
                int multi = n2[i] * n1[j] + carry;
                carry = multi / 10;
                multi = multi % 10;
                eachRes.append(multi);
            }
            if(carry!=0) eachRes.append(carry);
            String str = eachRes.reverse().toString();
            if(cnt > 0){
                int k = cnt;
                while (k > 0){
                    str += "0";
                    k--;
                }
            }
            //将str加到res中
            res = addStr(res,str);
            cnt++;
        }
        return res;
    }

    /**
     * 两字符串相加
     * @param s1
     * @param s2
     * @return
     */
    private String addStr(String s1,String s2){
        if(s1.length() == 0) return s2;
        if(s2.length() == 0) return s1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int k1 = s1.length()-1, k2 = s2.length()-1;
        while (k1 >=0 || k2 >= 0){
            int n1 = 0;
            int n2 = 0;
            if(k1>=0) n1 = s1.charAt(k1) - '0';
            if(k2>=0) n2 = s2.charAt(k2) - '0';
            int n = n1+n2+carry;
            carry = n / 10;
            n = n % 10;
            res.append(n);
            k1--;
            k2--;
        }

        if(carry!=0) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1,num2));
    }
}
