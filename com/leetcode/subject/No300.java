package com.leetcode.subject;

import java.util.Arrays;

public class No300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
