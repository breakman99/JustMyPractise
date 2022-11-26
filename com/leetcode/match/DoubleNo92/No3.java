package com.leetcode.match.DoubleNo92;

public class No3 {
    public static void main(String[] args) {
        System.out.println(new No3().bestClosingTime("YYNY"));
        System.out.println(new No3().bestClosingTime("NNNNN"));
        System.out.println(new No3().bestClosingTime("YYYY"));
        System.out.println(new No3().bestClosingTime("YN"));
    }
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[][] map = new int[2][n+1];
        // init
        for (int i = 1; i <= n; i++) {
            if (customers.charAt(i - 1) == 'N') map[0][i]++;
            else map[1][i]++;
        }
        for (int i = 1; i <= n; i++) {
            map[0][i] += map[0][i - 1];
        }
        for (int i = n - 1; i >= 0 ;i--) {
            map[1][i] += map[1][i + 1];
        }
        int idx = -1, result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (result > map[0][i - 1] + map[1][i]) {
                idx = i;
                result = map[0][i - 1] + map[1][i];
            }
        }
        if (map[0][n] < result) {
            return n;
        }
        return idx - 1;
    }
}
