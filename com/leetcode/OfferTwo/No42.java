package com.leetcode.OfferTwo;

public class No42 {
    public static void main(String[] args) {
        System.out.println(new No42Solution().maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
        System.out.println(new No42Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

class No42Solution {
    //e.g: nums = [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxValue = nums[0];
        int nowSum = 0;
        for (int i = 0; i < len; i++) {
            nowSum = Math.max(nums[i], nowSum + nums[i]);
            maxValue = Math.max(maxValue, nowSum);
        }
        return maxValue;
    }
}

class No42Solution2 {
    //e.g: nums = [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}