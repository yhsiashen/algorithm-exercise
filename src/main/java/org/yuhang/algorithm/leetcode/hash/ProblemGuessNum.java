package org.yuhang.algorithm.leetcode.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 猜数字 299
 */
public class ProblemGuessNum {

    public String getHint(String secret, String guess) {
        StringBuilder result = new StringBuilder();
        int bulls = 0;
        int cows = 0;
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        int[] numbers = new int[10];
        for (int i = 0; i < secretChars.length; i++) {
            int s = Character.getNumericValue(secretChars[i]);
            int g = Character.getNumericValue(guessChars[i]);
            if(s == g) bulls++;
            else {
               if(numbers[s] < 0) cows++;
               if(numbers[g] > 0) cows++;
               numbers[s] ++;
               numbers[g] --;

            }
        }
        return result.append(bulls).append('A').append(cows).append('B').toString();
    }

    public String getHint2(String secret, String guess) {
        StringBuilder result = new StringBuilder();
        int bulls = 0;
        int cows = 0;
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < secretChars.length; i++) {
             if(secretChars[i] == guessChars[i]){
                 bulls++;
             }else{
                 //在map中记录secret中数字出现的次数
                 if(!map.containsKey(secretChars[i])) {
                     map.put(secretChars[i], 1);
                 }else{
                     map.put(secretChars[i],map.get(secretChars[i])+1);
                 }
             }
        }

        for (int i = 0; i < secretChars.length; i++) {
            if(secretChars[i] != guessChars[i]){
                if(map.containsKey(guessChars[i]) && map.get(guessChars[i]) > 0){
                    cows++;
                    map.put(guessChars[i],map.get(guessChars[i])-1);
                }
            }
        }
        return result.append(bulls).append('A').append(cows).append('B').toString();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemGuessNum().getHint("1122","2211"));
    }
}
