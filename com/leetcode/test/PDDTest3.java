package com.leetcode.test;
import java.util.*;

public class PDDTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int count = 0;
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') arr[s.charAt(i) - 'a']++;
            else count++;
        }
        if (count == 0) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i) - 'a']++;
        }
        int[] res = new int[26];
        while (true) {
            for (int i = 25; i >= 0; i--) {
                if (arr[i] - arr2[i] < 0) {
                    int temp = arr2[i] - arr[i];
                    while (temp-- > 0 && count-- > 0) {
                        res[i]++;
                    }
                } else {
                    arr[i] -= arr2[i];
                }
            }
            boolean flag = false;
            for (int i = 0; i < 25; i++) {

            }
        }
    }
}