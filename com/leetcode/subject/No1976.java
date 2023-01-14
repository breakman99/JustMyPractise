package com.leetcode.subject;

import java.util.*;

public class No1976 {
}

class No1976_Solution {
    public int countPaths(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE >> 1);
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        for (int[] road : roads) {
            int a = road[0], b = road[1], c = road[2];
            graph[a][b] = c;
            graph[b][a] = c;
        }
        boolean[] used = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        used[0] = true;
        queue.add(new int[]{0, -1});
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            int to = temp[0], val = temp[1];
            dist[to] = Math.min(dist[to])
        }
        return 0;
    }
}






