package org.yuhang.algorithm.interview;

/**
 * 拼写单词
 */
public class ProblemCountCharacters {


    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] chars_map = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            chars_map[chars.charAt(i)-'a']++;
        }
        for(String word:words){
            int[] word_map = new int[26];
            boolean canSpell = true;
            for (int i = 0; i < word.length(); i++) {
                if(++word_map[word.charAt(i)-'a'] > chars_map[word.charAt(i)-'a']){
                    canSpell = false;
                }
            }
            res += canSpell?word.length():0;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(new ProblemCountCharacters().countCharacters(words,chars));
    }
}
