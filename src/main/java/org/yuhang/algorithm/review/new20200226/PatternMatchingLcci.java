package org.yuhang.algorithm.review.new20200226;

/**
 * 模式匹配
 * 输入:pattern = "abba", value = "dogdogdogdog"
 * 输出:true
 * 解释:"a"="dogdog",b=""，反之也符合规则
 *
 * 输入:aabab,catcatgocatgo
 * 输出:true
 *
 * a, b不能同时表示相同的字符串
 * 1 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母
 *
 *
 */
public class PatternMatchingLcci {

    public boolean patternMatching(String pattern, String value) {
        int pl = pattern.length();
        int vl = value.length();
        if(vl == 0 && pl == 1) return true;//若value为""，则pattern为a或b时都能匹配




        return false;
    }
}
