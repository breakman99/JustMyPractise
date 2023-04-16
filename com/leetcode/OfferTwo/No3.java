package com.leetcode.OfferTwo;

import java.util.Arrays;

public class No3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new No3Solution().countBits(5)));
    }
}


class No3Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}