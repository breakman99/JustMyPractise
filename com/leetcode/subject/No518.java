package com.leetcode.subject;

/**
 * https://leetcode.cn/problems/coin-change-2/
 */
public class No518 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) dp[i][j] += dp[i][j - coins[i - 1]];
            }
        }
        return dp[coins.length][amount];
    }
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1]) dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}

class No518Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}