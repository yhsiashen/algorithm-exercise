package org.yuhang.javabase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        for (String str: filtered){
            System.out.println(str);
        }
        Arrays.stream(new int[]{1,3,4,5,6}).filter(x -> x!=4).forEach(System.out::println);
    }
}
