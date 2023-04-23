package com.leetcode.subject;

public class No6390 {
    public static void main(String[] args) {
        System.out.println();
    }
}

/**
 * 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
 * 输出：[-1,-2,-2]
 * 解释：总共有 3 个 k = 3 的子数组。
 * 第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
 * 第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
 * 第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。
 */
class No6390Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;
        int resLen = len - k + 1;
        int[] res = new int[resLen];
        int idx = 0;
        int[] carr = new int[101];
        // init
        for (int i = 0; i < k; i++) {
            carr[nums[i]]++;
        }
        for (int i = 0; i < resLen; i++) {

        }
        return null;
    }
}