package org.yuhang.algorithm.leetcode.math;


/**
 * 整数转换英文表示 LC273
 */
public class ProblemIntegerToWords {


    public String numberToWords1(int num) {
        if (num == 0) return "Zero";
        int billion = num / 1000000000; //取十亿位以上的数字
        int million = (num - billion * 1000000000)  / 1000000; //取百万~亿上的数字
        int thousand = (num - billion * 1000000000 - million * 1000000) /1000; //取千~十万位上的数字
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;
        String res = "";
        if(billion!=0){
            res+=threeHandle(billion)+" Billion";
        }
        if(million!=0){
            if(!res.isEmpty()){
                res += " ";
            }
            res+=threeHandle(million)+" Million";
        }

        if(thousand!=0){
            if(!res.isEmpty()){
                res +=" ";
            }
            res+=threeHandle(thousand)+" Thousand";
        }

        if (rest != 0) {
            if (! res.isEmpty())
                res += " ";
            res += threeHandle(rest);
        }

        return res;



    }

    private String mapOne(int number){
        switch(number) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private String mapLessTwo(int number){
       switch (number){
           case 10: return "Ten";
           case 11: return "Eleven";
           case 12: return "Twelve";
           case 13: return "Thirteen";
           case 14: return "Fourteen";
           case 15: return "Fifteen";
           case 16: return "Sixteen";
           case 17: return "Seventeen";
           case 18: return "Eighteen";
           case 19: return "Nineteen";
       }
       return "";
    }

    public String mapTwo(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }


    private String threeHandle(int number) {
        int hundred = number/100;
        int rest = number - hundred * 100;
        String res="";
        if(hundred != 0){
            if(rest!=0){
                res +=mapOne(hundred)+" Hundred "+twoHandle(rest);
            }else{
                res += mapOne(hundred) +" Hundred";
            }
        }else{
            if(rest!=0){
                res +=twoHandle(rest);
            }
        }
       return res;
    }

    private String twoHandle(int number) {
        if(number == 0){
            return "";
        }else if(number < 10){
            return mapOne(number);
        }else if(number < 20){
            return mapLessTwo(number);
        }else {
            int tenner = number / 10;
            int rest = number - tenner * 10;
            if (rest != 0)
                return mapTwo(tenner) + " " + mapTwo(rest);
            else
                return mapOne(tenner);
        }

    }

    public static void main(String[] args) {
        System.out.println(new ProblemIntegerToWords().numberToWords1(1234567891));
    }
}
