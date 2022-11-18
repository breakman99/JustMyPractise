package com.leetcode.subject;

import java.util.Arrays;

/**
 * No322 零钱兑换
 * :
 * https://leetcode.cn/problems/coin-change/
 */
public class No322 {
    public static void main(String[] args) {
        System.out.println(new No322().coinChange(new int[]{1,2,5}, 11));
    }

    /**
     * 输入：coins = [1, 2, 5], amount = 11 <br>
     * 输出：3 <br>
     * 解释：11 = 5 + 5 + 1<br>
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
