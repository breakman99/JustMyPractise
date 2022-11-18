package com.leetcode.subject;

/**
 * https://leetcode.cn/problems/ones-and-zeroes/
 */
public class No474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][n + 1][m + 1];
        for (int i = 1; i <= len; i++) {
            String str = strs[i - 1];
            int num1 = 0, num0 = 0;
            for (int a = 0; a < str.length(); a++)
                if (str.charAt(a) == '1') num1++; else num0++;
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (num1 <= j && num0 <= k)
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - num1][k - num0] + 1);
                }
            }
        }
        return dp[len][n][m];
    }
}
