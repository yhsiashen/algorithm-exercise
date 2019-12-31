package org.yuhang;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {

    static class Student implements Serializable {

        String sex;
        int age;

        public Student() {
        }

        public Student(String sex, int age) {
            this.sex = sex;
            this.age = age;
        }
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "中";
//        byte[] bytes = str.getBytes("Unicode");
//        for (int i = 0; i <bytes.length ; i++) {
//            System.out.println(bytes[i]);
//        }
//        System.out.println(-2147483648>>>1);
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(-8>>>1));
//        String i = "abc";
//        String j = new String("abc").intern();
//        String c = "abc";
//        System.out.println(i==c);
//        System.out.println(Pattern.matches("ab{1,3}+bc","abbc"));


        List<Student> list = new ArrayList<>();
        list.add(new Student("male",20));
        list.add(new Student("female",17));
        list.add(new Student("female",21));
        list.add(new Student("female",15));
        list.add(new Student("male",17));
        list.add(new Student("male",18));
        list.add(new Student("male",22));

        Map<String, List<Student>> stuMap;
        stuMap = list.stream().filter(student -> student.age > 18).collect(Collectors.groupingBy(student -> student.sex));
        System.out.println(stuMap);

    }

}

