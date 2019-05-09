package org.yuhang.algorithm.leetcode.math;

/**
 * 比较版本号 165
 */
public class ProblemCompareVersion {


    public int compareVersion(String version1, String version2) {
        int[] version1Num = new int[version1.length()];
        int i1 = 0;
        int[] version2Num = new int[version2.length()];
        int i2 = 0;
        for (int i = 0; i < version1.length(); i++) {
            if(Character.isDigit(version1.charAt(i))){
                int curNum = Character.getNumericValue(version1.charAt(i));
                while (i+1 < version1.length() && Character.isDigit(version1.charAt(i+1))){
                    curNum = curNum*10+Character.getNumericValue(version1.charAt(++i));
                }
                version1Num[i1++] = curNum;
            }
        }


        for (int i = 0; i < version2.length(); i++) {
            if(Character.isDigit(version2.charAt(i))){
                int curNum = Character.getNumericValue(version2.charAt(i));
                while (i+1 < version2.length() && Character.isDigit(version2.charAt(i+1))){
                    curNum = curNum*10+Character.getNumericValue(version2.charAt(++i));
                }
                version2Num[i2++] = curNum;
            }
        }

        //从大到小版本比较两版本号大小
        for (int i = 0; i < Math.min(i1,i2); i++) {
            if(version1Num[i] < version2Num[i]){
                return -1;
            }else if(version1Num[i] > version2Num[i]){
                return 1;
            }
        }

        if(i1 < i2){
            int count = i1;
            while (count < i2){
                if(version2Num[count++] !=0) return -1;
            }
        }

        if(i2 < i1){
            int count = i2;
            while (count < i1){
                if(version1Num[count++] !=0) return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String v1 = "010.23.1";
        String v2 = "010.23.2.2";
        System.out.println(new ProblemCompareVersion().compareVersion(v1,v2));
    }

}
