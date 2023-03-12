package com.leetcode.subject;

public class No2461 {
}

class No2461_Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < k) return -1;
        int init = 0;
        for (int i = 0; i < k; i++) {
            init += nums[i];
        }

        return 0;
    }
}
