package com.leetcode.LCP;

import java.util.Deque;
import java.util.LinkedList;

public class LCP07 {
    public static void main(String[] args) {
        System.out.println(new LCP07Solution().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println(new LCP07Solution().numWays(3, new int[][]{{0, 2}, {0, 1}, {1, 2}, {2, 1}, {2, 0}, {1, 0}}, 1));
    }

}

// bfs
class LCP07Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[][] map = new int[n][n];
        int count = 0;
        for (int[] i : relation) {
            map[i[0]][i[1]] = 1;
        }
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] a = deque.removeFirst();
            if (a[0] >= k) {
                if (a[0] == k && a[1] == n - 1) count++;
            } else for (int i = 0; i < n; i++) {
                if (map[a[1]][i] == 1) {
                    deque.addLast(new int[]{a[0] + 1, i});
                }
            }
        }
        return count;
    }
}

//dp
class LCP07Solution01 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] f = new int[k+1][n];
        f[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] re : relation) {
                f[i][re[1]] += f[i - 1][re[0]];
            }
        }
        return f[k][n - 1];
    }
}





