package com.leetcode.test;
import java.util.*;
public class MYJFTest03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int[] temp = new int[26];
            for (int j = i; j < len; j++) {
                temp[s.charAt(j) - 'a']++;
                if (judge(temp)) count++;
            }
        }
        System.out.println(count);
    }

    private static boolean judge(int[] temp) {
        int count1 = 0;
        boolean count2 = false;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] % 2 == 0) count2 = true;
            else count1++;
        }
        if (count1 == 1 && count2) return true;
        return false;
    }
}