package com.leetcode.subject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1027 {
    public static void main(String[] args) {
        System.out.println(new No1027Solution().longestArithSeqLength(new int[]{83, 20, 17, 43, 52, 78, 68, 45}));
    }
}

/**
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 */
class No1027Solution {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Map<Integer, Integer>[] maps = new HashMap[len];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int key = nums[i] - nums[j];
                int val = maps[j].getOrDefault(key, 1) + 1;
                maps[i].put(key, Math.max(maps[i].getOrDefault(key, 1), val));
                dp[i] = Math.max(dp[i], val);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

