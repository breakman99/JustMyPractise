package com.leetcode.subject;

import java.util.Arrays;

/**
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，
 * 表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，
 * 使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 */
public class No787 {
}

// Bellman-Ford
class No787_Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        dist[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] copy = dist.clone();
            for (int[] flight : flights) {
                dist[flight[1]] = Math.min(dist[flight[1]], copy[flight[0]] + flight[2]);
            }
        }
        return dist[dst] >= Integer.MAX_VALUE >> 1 ? -1 : dist[dst];
    }
}








