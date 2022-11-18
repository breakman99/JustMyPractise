package com.leetcode.test;

import java.util.*;

public class DDTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] t = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) map.put(i, i);
        for (int i = 0; i < n; i++) left[i] = sc.nextInt();
        for (int i = 0; i < n; i++) right[i] = sc.nextInt();
        for (int i = 0; i < n; i++) t[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int count = 0;
            int l = left[i];
            int r = right[i];
            for (int j = l; j <= r; j++) {
                int temp = 0;
                if (!map.containsKey(j)) {
                    int a = j;
                    while (a > 0) {
                        int x = a % 10;
                        temp ^= x;
                        a /= 10;
                        if (map.containsKey(a)) {
                            temp ^= map.get(a);
                            break;
                        }
                    }
                    map.put(j, temp);
                } else {
                    temp = map.get(j);
                }
                if (temp == t[i]) count++;
            }
            System.out.printf(count + " ");
        }
    }
}
