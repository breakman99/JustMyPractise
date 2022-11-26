package com.leetcode.subject;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No882 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1, 10},
                {0, 2, 1},
                {1, 2, 2}
        };
        System.out.println(new No882Solution01().reachableNodes(edges, 6, 3));
    }
}

class No882Solution01 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // use dijkstra get path
        int M = 10002*2, N = 3002;
        int m = edges.length;
        int[] he = new int[N], ne = new int[M], w = new int[M], e = new int[M];
        Arrays.fill(he, -1);
        Arrays.fill(ne, -1);
        int idx = 1;
        // create graph
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            w[idx] = c;
            e[idx] = b;
            ne[idx] = he[a];
            he[a] = idx;

            w[idx+m] = c;
            e[idx+m] = a;
            ne[idx+m] = he[b];
            he[b] = idx+m;
            idx++;
        }
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] path = new int[n];
        boolean[] used = new boolean[n];
        Arrays.fill(path, Integer.MAX_VALUE >> 1);
        path[0] = 0;
        used[0] = true;
        heap.add(new Integer[]{0, 0});
        while (!heap.isEmpty()) {
            Integer[] temp = heap.remove();
            int t = temp[0];
            for (int edge = he[t]; edge != -1; edge = ne[edge]) {
                int weight = w[edge];
                int target = e[edge];
                path[target] = Math.min(path[target], path[t] + weight + 1);
                if (!used[target]) {
                    used[target] = true;
                    heap.add(new Integer[]{target, path[target]});
                }
            }
        }
        int[] newW = new int[M];
        int result = 0;
        for (int i = 0; i < path.length; i++) {
            int step = maxMoves - path[i];
            if (step >= 0) {
                result++;
                for (int edge = he[i]; edge != -1; edge = ne[edge]) {
                    newW[edge] -= step;
                }
            }
        }
        for (int i = 1; i <= edges.length; i++) {
            if (w[i] + newW[i] + newW[i + m] <= 0) result += w[i];
            else result -= (newW[i] + newW[i + m]);
        }
        return result;
    }
}

// Dijkstra 邻接矩阵：感觉还是矩阵做无向图更有利一些（邻接表构造搞麻了已经）
class No882Solution02 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // create graph
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE >> 1);
            graph[i][i] = 0;
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            graph[a][b] = c;
            graph[b][a] = c;
        }
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE >> 1);
        path[0] = 0;
        boolean[] used = new boolean[n];
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        heap.add(new Integer[]{0, 0});
        used[0] = true;
        while (!heap.isEmpty()) {
            Integer[] temp = heap.remove();
            int t = temp[0];
            for (int i = 0; i < n; i++) {
                path[i] = Math.min(path[i], path[t] + graph[t][i] + 1);
                if (!used[i] && graph[t][i] < Integer.MAX_VALUE >> 1) {
                    used[i] = true;
                    heap.add(new Integer[]{i, path[i]});
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (used[i]) result++;
        }
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] < Integer.MAX_VALUE >> 1) {

                }
            }
        }

        return 0;
    }
}













