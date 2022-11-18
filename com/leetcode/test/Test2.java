package com.leetcode.test;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = n;
        List<Integer> arr = new ArrayList<>();
        while (num-- > 0) {
            arr.add(sc.nextInt());
        }
        Set<Integer> set = new HashSet<>(arr);
        for (Integer i : arr) {
            set.remove(i);
            for (int j = 0; j < (int) 1e9; j++) {
                if (!set.contains(j)) {
                    System.out.printf(j + " ");
                    break;
                }
            }
            set.add(i);
        }
    }
}
