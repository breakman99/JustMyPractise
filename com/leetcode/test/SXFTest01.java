package com.leetcode.test;

public class SXFTest01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 字符串1
     * @param b string字符串 字符串2
     * @return int整型
     */
    public int minDistance (String a, String b) {
        // write code here
        int len1 = a.length();
        int len2 = b.length();
        if (len1 * len2 == 0) return Math.max(len1, len2);
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int l = dp[i - 1][j] + 1;
                int w = dp[i][j - 1] + 1;
                int lw= dp[i - 1][j - 1];
                if (a.charAt(i - 1) != b.charAt(j - 1)) lw++;
                dp[i][j] = Math.min(l, Math.min(w, lw));
            }
        }
        return dp[len1][len2];
    }
}
