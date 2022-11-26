package com.leetcode.match.DoubleNo92;

public class No2 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] diff = new int[m][n];
        int[] a = new int[m], b = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    a[i]++;
                    b[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = (2 * a[i] - m) + (2 * b[j] - n);
            }
        }
        return diff;
    }
}
