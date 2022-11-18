package com.leetcode.test;
import java.util.*;
public class SXFTest02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            a[i][0] = temp - x;
            a[i][1] = temp + x;
        }
        int left = a[0][0], right = a[0][1];
        int result = 0;
        for (int[] b : a) {
            if ((left >= b[0] && left <= b[1]) || (right >= b[0] && right <= b[1])) {
                left = Math.max(left, b[0]);
                right = Math.min(right, b[1]);
            } else {
                result++;
                left = b[0];
                right = b[1];
            }
        }
        System.out.println(result);
    }
}
/**
 * 5 4
 * 4 9 6 7 8
 */