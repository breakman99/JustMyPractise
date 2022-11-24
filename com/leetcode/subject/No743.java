package com.leetcode.subject;
import java.util.*;
public class No743 {
    public static void main(String[] args) {
        System.out.println();
    }
}

// Dijkstra: Adjacency matrix (邻接矩阵)
class No743_Solution01 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int V = Integer.MAX_VALUE >> 1;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
            graph[i][i] = 0;
        }
        // create graph
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        // shortest path array
        int[] path = new int[n];
        Arrays.fill(path, V);
        // used point set
        boolean[] used = new boolean[n];
        path[k - 1] = 0;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new Integer[]{k - 1, 0});
        while (!queue.isEmpty()) {
            Integer[] temp = queue.remove();
            int t = temp[0];
            if (used[t]) continue;
            // mark as used
            used[t] = true;
            for (int i = 0; i < n; i++) {
                if (graph[t][i] != -1) {
                    path[i] = Math.min(path[i], path[t] + graph[t][i]);
                    if (!used[i]) queue.add(new Integer[]{i, path[i]});
                }
            }
        }
        int max = -1;
        for (int i : path) {
            if (i == Integer.MAX_VALUE >> 1) return -1;
            else max = Math.max(max, i);
        }
        return max;
    }
}

// Dijkstra: (邻接表)
class No743_Solution02 {
    int M = 6002;
    int N = 102;
    int[] he = new int[N];
    int[] ne = new int[M];
    int[] e  = new int[M];
    int[] w  = new int[M];
    int idx = 0;
    public int networkDelayTime(int[][] times, int n, int k) {
        // create graph
        for (int[] time : times) {
            add(time[0], time[1], time[2]);
        }
        int[] path = new int[n];
        boolean[] used = new boolean[n];
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new Integer[]{k, 0});
        while (!queue.isEmpty()) {
            Integer[] temp = queue.remove();
            int t = temp[0];
        }
        return 0;
    }

    // a:起点  b:终点  c:边权值
    void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }
}














