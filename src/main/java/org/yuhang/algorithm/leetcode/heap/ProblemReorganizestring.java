package org.yuhang.algorithm.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 重构字符串 LC767
 */
public class ProblemReorganizestring {

    class MultiChar {
        int count;
        char letter;

        MultiChar(int ct, char ch) {
            count = ct;
            letter = ch;
        }
    }

    /**
     * 贪心 & 堆
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c: S.toCharArray()) count[c-'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i) if (count[i] > 0) {
            if (count[i] > (N + 1) / 2) return "";
            pq.add(new MultiChar(count[i], (char) ('a' + i)));
        }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            ans.append(mc1.letter);
            ans.append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
        }
        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }




    public static void main(String[] args) {
        System.out.println(new ProblemReorganizestring().reorganizeString("zhmyo"));
    }
}
