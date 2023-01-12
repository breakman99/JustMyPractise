package com.leetcode.subject;

import java.util.*;

public class No1807 {
    public static void main(String[] args) {
        List<List<String>> dict = new ArrayList<>();
        List<String> dict1 = new ArrayList<>();
        List<String> dict2 = new ArrayList<>();
        dict1.add("name");
        dict1.add("bob");
        dict2.add("age");
        dict2.add("two");
        dict.add(dict1);
        dict.add(dict2);
        System.out.println(new No1807_Solution().evaluate("(name)is(age)yearsold", dict));
    }
}

class No1807_Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}