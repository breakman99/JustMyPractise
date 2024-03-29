package com.leetcode.subject;

import java.util.*;

public class No743 {
    public static void main(String[] args) {
        int[][] times = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(new No743_Solution02().networkDelayTime(times, 4, 2));
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
    int[] e = new int[M];
    int[] w = new int[M];
    int idx = 1;

    public int networkDelayTime(int[][] times, int n, int k) {
        // create graph
        for (int[] time : times) {
            add(time[0], time[1], time[2]);
        }
        int[] path = new int[n + 1];
        Arrays.fill(path, Integer.MAX_VALUE >> 1);
        path[k] = 0;
        boolean[] used = new boolean[n + 1];
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new Integer[]{k, 0});
        while (!queue.isEmpty()) {
            Integer[] temp = queue.remove();
            int t = temp[0];
            used[t] = true;
            List<Integer> edges = getEdges(t);
            for (int i : edges) {
                path[e[i]] = Math.min(path[e[i]], path[t] + w[i]);
                if (!used[e[i]]) queue.add(new Integer[]{e[i], w[i]});
            }
        }
        int max = -1;
        for (int i = 1; i < path.length; i++) {
            if (path[i] == Integer.MAX_VALUE >> 1) return -1;
            max = Math.max(max, path[i]);
        }
        return max;
    }

    // a:起点  b:终点  c:边权值
    void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }

    List<Integer> getEdges(int a) {
        List<Integer> edges = new ArrayList<>();
        for (int i = he[a]; i != 0; i = ne[i]) {
            edges.add(i);
        }
        return edges;
    }
}

// floyd 邻接矩阵
class No743_Solution03 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        int VAL = Integer.MAX_VALUE >> 1;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], VAL);
            graph[i][i] = 0;
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][l] + graph[l][j]);
                }
            }
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, graph[k][i]);
        }
        return max >= VAL ? -1 : max;
    }
}

// Bellman-Ford
class No743_Solution04 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        dist[k] = 0;

        for (int i = 1; i <= n; i++) {
            int[] pre = dist.clone();
            for (int[] time : times) {
                dist[time[1]] = Math.min(dist[time[1]], pre[time[0]] + time[2]);
            }
        }
        // get max value
        int maxValue = -1;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            maxValue = Math.max(maxValue, dist[i]);
        }
        return maxValue >= (Integer.MAX_VALUE >> 1) ? -1 : maxValue;
    }
}










