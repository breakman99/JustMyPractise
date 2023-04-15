package com.leetcode.subject;

import java.util.Arrays;

/**
 * No322 零钱兑换
 * :
 * https://leetcode.cn/problems/coin-change/
 */
public class No322 {
    public static void main(String[] args) {
        System.out.println(new No322().coinChange(new int[]{5,2,1}, 11));
    }

    /**
     * 输入：coins = [1, 2, 5], amount = 11 <br>
     * 输出：3 <br>
     * 解释：11 = 5 + 5 + 1<br>
     */
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
