package com.leetcode.test;

import java.util.*;

public class MYJFTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[26];
        arr[0] = x;
        for (int i = 1; i < 26; i++) {
            int ta = arr[i - 1] / 2;
            int tb = arr[i - 1] % 2;
            arr[i - 1] = tb;
            arr[i] = ta;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (arr[i]-- != 0) {
                sb.append((char)('a' + i));
            }
        }
        System.out.println(sb.toString());
    }
}

/**
 * aaaaa
 * bba
 * ca
 */
