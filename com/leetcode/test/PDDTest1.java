package com.leetcode.test;

import java.util.*;

public class PDDTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            // coding
            int[] arr = new int[26];
            for (int i = 0; i < 26; i++) {
                arr[i] = i;
            }
            for (int i = 0; i < n; i++) {
                int c = str.charAt(i) - 'a';
                if (c == find(c, arr)) {
                    while (k > 0 && c > 0) {
                        if (c == find(c, arr)) {
                            merge(c--, c, arr);
                            k--;
                        } else break;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append((char)('a' + find(str.charAt(i) - 'a', arr)));
            }
            System.out.println(builder.toString());
        }

    }
    static int find(int x, int[] arr) {
        if (arr[x] == x) return x;
        else return find(arr[x], arr);
    }

    static void merge(int i, int j, int[] arr) {
        arr[find(i, arr)] = find(j, arr);
    }
}
