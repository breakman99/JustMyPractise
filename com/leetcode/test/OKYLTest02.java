package com.leetcode.test;

import java.util.HashMap;
import java.util.Map;

public class OKYLTest02 {
    public boolean wordPattern (String pattern, String str) {
        // write code here
        char[] arr = pattern.toCharArray();
        String[] target = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        if (arr.length != target.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], target[i]);
            }
            if (!target[i].equals(map.get(arr[i]))) return false;
        }
        return true;
    }
}
