package com.leetcode.subject;

/**
 * https://leetcode.cn/problems/decode-ways/
 */
public class No91 {
    public static void main(String[] args) {
        System.out.println();
    }
}

class No91Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int a = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            int num = !(a > 0 && a <= 26) || (s.charAt(i - 1) - '0') == 0 ? 0 : dp[i - 1];
            int num2 = s.charAt(i) == '0' ? 0 : dp[i];
            dp[i + 1] = num2 + num;
        }
        return dp[len];
    }
}
