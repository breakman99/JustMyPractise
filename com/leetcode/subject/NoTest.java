package com.leetcode.subject;

public class NoTest {
    public static void main(String[] args) {
        System.out.println(test("abcdcb"));
    }
    public static String test(String str) {
        int len = str.length();
        String res = "";
        for (int i = 0; i < len - 1; i++) {
            String a = getStr(i,i,str);
            String b = getStr(i, i+1, str);
            String temp = a.length() > b.length() ? a : b;
            res = temp.length() > res.length() ? temp : res;
        }
        return res;
    }
    private static String getStr(int i, int j, String s) {
        int len = s.length();
        String res = "";
        while (i >= 0 && j < len) {
            if (i == j) {
                res = s.charAt(i) + "";
                i--;
                j++;
            } else if (s.charAt(i) == s.charAt(j)) {
                res = s.charAt(i--) + res +s.charAt(j++);
            } else break;
        }
        return res;
    }
}
