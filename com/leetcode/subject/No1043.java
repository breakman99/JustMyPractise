package com.leetcode.subject;

public class No1043 {
    public static void main(String[] args) {
        System.out.println();
    }
}

/**
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 *
 *          [10,1,9,1,1,1]
 */
class No1043Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            int max = 0;
            for (int j = 0; j < k; j++) {
                if (i+j >= len) break;
                max = Math.max(max, arr[i + j - 1]);
                dp[i + j] = Math.max(dp[i] + (max * (j + 1)), dp[i + j]);
            }
        }
        return 0;
    }
}









